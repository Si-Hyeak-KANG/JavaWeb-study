package com.spring.ex01;

public class PersonServiceImpl implements PersonService {

	private String name;
	private int age;
	
	// setter를 작성해줘야 person.xml에서 bean태그의 value 값이 세팅
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {

		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

	
}
