package com.ce.fisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ce.fisa.biz.Car;

@RestController
public class CarController {
	/*
	 * @Component
	 * public class Car{
	 */
	@Autowired //타입과 일치되는 스피링빈을 자동 주입 
	private Car car;

	
	@GetMapping("aop1")
	public String m1() {
		System.out.println("m1() 메서드 호출중 ---");
		car.buy();
		return "m1 응답";
	}
}
