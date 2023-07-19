package com.ohana0.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohana0.spring.ex.ajax.service.NewUserService;
import com.ohana0.spring.ex.jsp.domain.User;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	
	@Autowired
	private NewUserService newUserService;
	
	@GetMapping("/list")
	public String userList(Model model) {
		List<User> userList = newUserService.getUserList();
		
		model.addAttribute("userList", userList);
		return "/ajax/user/list";
	}
	
	@ResponseBody
	@GetMapping("/add")
	public Map<String,String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email")String email
			,@RequestParam("introduce")String introduce) {
		int count = newUserService.addUser(name, birthday, email, introduce);
		
		//성공실패여부
		//성공하면 {"result":"success"}
		//실ㄹ패하면 {"result":"fail"}
		Map<String,String> resultMap = new HashMap<>();
		
		if(count == 1) {//저장성공
			resultMap.put("result","success");
		}
		else {//저장실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/user/add_user";
	}
	
	
	
}
