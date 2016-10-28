package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes("mid")
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginFrom(){
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String mid, String mpassword, HttpSession session, Model model){
		int result = memberSerivce.login(mid, mpassword);
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
	public String join(Member member) {
		try{
			int result = memberSerivce.join(member);
//			if(result == MemberService.JOIN_FAIL){
//				 return "member/joinForm";
//			}
			return "redirect:/member/login";
		}catch(Exception e){
			
			return "member/joinForm";
		}
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.POST)
	public String findMid(String memail, Model model, HttpSession session){
		String mid = memberSerivce.findMid(memail);
		if(mid == null){
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "redirect:/member/login?mid=" + mid;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		String mid = (String) session.getAttribute("login");
		int result = memberSerivce.logout(mid);
		if(result == MemberService.LOGIN_SUCCESS){
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/info")
	public String info(String mpassword, @ModelAttribute("mid") String mid, Model model){
//		String mid = (String) session.getAttribute("login");
		Member member = memberSerivce.info(mid, mpassword);
		model.addAttribute("member", member);
		return "member/info";
	}	
}
