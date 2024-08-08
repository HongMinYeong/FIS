package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StringReturnController {

	@RequestMapping(path="/fisa",method = RequestMethod.GET)
	public ModelAndView m1() {
		System.out.println("m1() ****");
		ModelAndView mv = new ModelAndView();
		//main.jsp 에서 controller 에서 저장한 데이터 출력
		mv.addObject("msg","서버에서 저장한 데이터");
		mv.setViewName("main"); // /WEB-INF/main.jsp 지정하는 설정
		return mv; //forward
	}
		/*
		 * forward 와 redirect 방식 구분
		 * index.html -> SubController -> main.jsp 
		 */
	@RequestMapping(path = "fisa1", method = RequestMethod.GET)
	public String m2() {
		System.out.println("m2()***");
		return "main"; //WEB-INF/main.jsp 정상실행
	}
	//forward 방식으로 main으로 이동
	@RequestMapping(path = "fisa2", method = RequestMethod.GET)
	public String m22(@RequestParam("id") String id) {
		System.out.println("m22()***" + id);
		return "main"; //WEB-INF/main.jsp 정상실행
	}

	@RequestMapping(path = "fisa3", method = RequestMethod.GET)
	public String m3(@RequestParam("id") String id) {
		System.out.println("m3()***" + id);
		return "redirect:main.jsp"; //WEB-INF/main.jsp 정상실행
	}
	
	@RequestMapping(path = "fisa4", method = RequestMethod.GET)
	public String m4(@RequestParam("id") String id) {
		System.out.println("m3()***" + id);
		return "forward:main.jsp"; //WEB-INF/main.jsp 정상실행
	}



}

/*
 * ModelAndView : 데이터, 화면
 */
