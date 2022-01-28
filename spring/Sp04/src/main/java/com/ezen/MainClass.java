package com.ezen;

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
	}

}
