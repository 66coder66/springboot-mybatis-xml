package com.example.demo.controller;

import java.util.List;

import com.dsh.demo.util.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsh.demo.mapper.UserMapper;
import com.dsh.demo.pojo.UserPo;
import com.dsh.demo.service.impl.UserServiceImpl;
import com.example.demo.annotation.RedisCacheQ;
import com.example.demo.cache.RedisCache;



/**
 * 官方建议 ：自定义的controller位置与启动类application.java 的位置要同级
 * @author dsh
 *
 */
@Controller
public class MyController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);
	private String clazzName = "com.example.demo.controller.MyController.";
	
	@Autowired
	private UserMapper userMapper;
	@Autowired(required = true)
	private UserServiceImpl userService;
	
	
	@Autowired
    @Qualifier("redisCache")
    private RedisCache redisCache;


	@RequestMapping("/")
	public String index(Model model){
		Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
		model.addAttribute("msg", msg);
		return "home";
	}


	@RequestMapping("/home")
    @ResponseBody
    public String home(Model model) {
		Msg msg =  new Msg("测试标题","测试内容","额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return "home";
    }

	@RequestMapping("/admin")
	@ResponseBody
	public String admin(){
		return "hello admin";
	}
	/**
	 * 跳转页面
	 * 
	 */
	@RequestMapping("/index")
    public String indexHtml(Model model) {
		
		//向模板中添加属性
		UserPo user = new UserPo();
		user.setUser_name("lisi");
        user.setType("BI");
        List<UserPo> users = userMapper.getAll();

		model.addAttribute("user",user);
		model.addAttribute("users",users);
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }
	/**
	 * 跳转vue页面
	 *
	 */
	@RequestMapping("/vuepage")
	public String vuePage(Model model) {
		UserPo user = new UserPo();
		user.setUser_name("lisi");
		user.setType("BI");
		List<UserPo> users = userMapper.getAll();
		model.addAttribute("users",users);
		model.addAttribute("user",user);
		return "vue/index";
	}
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOneUser/{id}")
	@ResponseBody
	@RedisCacheQ
    public String getOneUser(@PathVariable("id") Long id) {
		LOGGER.info("**********getOneUser**********");
		String res = "";
		UserPo user = userMapper.getOneUser(id);
		if(null != user){
			res = user.toString();
		}
        return res;
    }
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping("/getUsers")
	@RedisCacheQ
	public @ResponseBody String getUsers() {
		List<UserPo> users = userMapper.getAll();
		return users.toString();
	}
	@RequestMapping("/add")
    public @ResponseBody int save(UserPo user) {
		int i = userMapper.insert(user);
    	return i;
    }
	/**
	 * 事务
	 * @param user
	 * @return
	 */
	@RequestMapping("/insert")
    public @ResponseBody int saveUser(UserPo user) {
		int i = userService.insertUser(user);
    	return i;
    }
    @RequestMapping(value="/update")
    public @ResponseBody int update(UserPo user) {
    	int i = userMapper.update(user);
    	Object obj =  (Object) user.toString();
    	Integer id = user.getUser_id();
    	String redisKey = id + ":" + clazzName + "getOneUser";
    	String code =  redisCache.saveDataToRedis(redisKey, obj);
    	LOGGER.info("**********从Redis中更新数据**********:"+ code);
    	return i;
    }
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/delete/{id}")
    public @ResponseBody int delete(@PathVariable("id") Long id) {
    	int i = userMapper.delete(id);
    	//删除redis对应的数据
    	String redisKey = id + ":" + clazzName + "getOneUser";
    	Object obj = redisCache.getDataFromRedis(redisKey);

        if(obj!=null){
            LOGGER.info("**********从Redis中查到了数据**********");
            LOGGER.info("Redis的KEY值:"+redisKey);
            Long code =  redisCache.delDataToRedis(redisKey, obj);
            LOGGER.info("**********从Redis中删除数据**********:"+ code);
        }
    	return i;
    }

}
