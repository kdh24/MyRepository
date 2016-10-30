package com.home.homeweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.homeweb.dto.Member;
import com.home.homeweb.dto.PhotoBoard;
import com.home.homeweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginFrom(){
		return "member/loginForm";
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model){
		int result = memberService.login(mid, mpassword);
		if(result == MemberService.LOGIN_FAIL_MPASSWORD){
			model.addAttribute("error", "LOGIN_FAIL_MPASSWORD");
			return "member/loginForm";
		}else if(result == MemberService.LOGIN_FAIL_MID){
			model.addAttribute("error", "LOGIN_FAIL_MID");
			return "member/loginForm";
		}else{
			session.setAttribute("login", mid);
		}
		return "redirect:/";
	}

	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidFrom(){
		return "member/findMidForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		try{
			int result = memberService.join(member);
			return "redirect:/member/login";
		}catch(Exception e){
			return "member/joinForm";
		}
	}
	
}
