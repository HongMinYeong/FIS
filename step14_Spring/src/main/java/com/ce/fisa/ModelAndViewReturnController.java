package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewReturnController {
	
	//url 자체도 데이터로 구성하는 URL template 기술 적용
	// 문법 :path/{key}/subpath
	//@PathVariable("key")
	@RequestMapping("fisa8/{id}/tester")
	public String m8(@PathVariable("id") String id) {
		System.out.println("m8() ****" +  id);
		return "redirect:/main.jsp"; //?http://ip:port/context명/main.jsp
	}
	
	
	/* url 구성연습
	 * 1단계 - 에러발생 
	 * return "redirect:main.jsp"; 코딩시
	 * http://localhost/step14/fisa7/id/main.jsp 로 요청 미존재 경로 따라서 에러
	 * 
	 * 2단계 - 해결책 
	 * [경로 수정]
	 * return "redirect:/main.jsp"; -> slash 추가  
	 * context 명 인식시키기 
	 * 
	 */
	
	@RequestMapping("fisa7/id/tester")
	public String m3() {
		System.out.println("m3() ****");
		return "redirect:/main.jsp";
	}
	
	/* @RequestParam("id") String id
	 * String id = new 
	 */
	
	@GetMapping("fisa6")
	public ModelAndView m2(@RequestParam("id") String id) {
		System.out.println("m2() ***" + id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "server 에서 new data 저장");
		mv.setViewName("main");
		return mv;
	}
	
	
	// 데이터 저장 후 /WEB-INF/main.jsp로 이동 
	@RequestMapping(path="fisa5",method = RequestMethod.GET)
	public ModelAndView m1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "server 에서 new data 저장");
		mv.setViewName("main");
		return mv; //forward 방식으로 정상 이동 
	}
	
}
