package com.ezen;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.battery.ChargeBattery;
import com.ezen.battery.NormalBattery;
import com.ezen.toy.ElectronicCar;
import com.ezen.toy.ElectronicRadio;

public class MainClass {

	public static void main(String[] args) {
		
		// 일반적인 사용 예
		// 배터리가 장착된 상태로 판매되는 일체형. 객체 생성 하나만으로 사용이 가능하다.
		ElectronicCar carToy = new ElectronicCar();
		
//		ElectronicRadio radioToy = new ElectronicRadio();	// 에러
		// 생성자에 배터리 객체가 전달되어야, 매개변수가 있는 생성자가 실행되므로 위는 에러이다.
		NormalBattery nbatt1 = new NormalBattery();
		ChargeBattery cbatt1 = new ChargeBattery();
		// ElectronicRadio 생성자에 필요한 전달인자 nbatt1이나 cbatt1 객체를 만들고, 이를 넣어주어야 에러가 나지 않는다.
		ElectronicRadio radioToy1 = new ElectronicRadio(nbatt1);
		// 생성자에 배터리 객체를 전달해주면 정상 생성. 이렇게 객체 생성시에 다른 객체의 존재 및 생성자로의 전달이 필수인 상태이다!
		// 객체 생성이 다른 객체에 의존하고 있는 상태! 이를 객체 의존이라고 부른다.
		// 그리고 필요 객체를 생성자의 전달인수로 넣어주는 것을 의존주입(Dependency Injection) 이라고 부른다
		
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		ElectronicCar carToy2 = ctx.getBean("car", ElectronicCar.class);
		ElectronicRadio radioToy2 = ctx.getBean("radio", ElectronicRadio.class);
		radioToy2.setBattery(nbatt1);
		// 스프링 프레임워크에서의 클래스 사용이 약간 업그레이드되어 사용하기 간편해졌다.
	}

}
