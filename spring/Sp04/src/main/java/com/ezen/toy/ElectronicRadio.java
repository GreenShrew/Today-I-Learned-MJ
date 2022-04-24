package com.ezen.toy;

import com.ezen.battery.Battery;

public class ElectronicRadio {
	private Battery bat;	// 인터페이스 레퍼런스 변수. - 배터리 변수가 멤버변수
	// 생성자를 눈여겨보아야 한다.
	// 생성자에서 배터리가 초기화되는데, 그 초기값이 생성자의 전달인수로 전달되어야 하는 형태이다.
	public ElectronicRadio(Battery bat) {	// ElectronicRadio 클래스는 Battery에 의존하고 있다.
		this.bat = bat;
	}
	public void setBattery(Battery battery) {
		this.bat = battery;
	}	// 추후 배터리를 새로 교체할 수 있는 기능.
	
}
// 구매와 동시에 동봉된 새 배터리 또는 별도 구매한 배터리를 장착할 수 있는 기능이 있다.