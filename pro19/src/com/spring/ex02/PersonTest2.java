package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest2 {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person1 = (PersonService) factory.getBean("personService1"); // id∞° personService1¿Œ ∫Û¿ª ∞°¡Æø».
		person1.sayHello(); // ∫Û¿« sayHello()∏¶ »£√‚
		System.out.println();
		
		PersonService person2 = (PersonService) factory.getBean("personService2"); // id∞° personService2¿Œ ∫Û¿ª ∞°¡Æø».
		person2.sayHello();
	}

}
