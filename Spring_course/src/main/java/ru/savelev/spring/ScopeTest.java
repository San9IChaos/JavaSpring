package ru.savelev.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Dog myDog = context.getBean("dog",Dog.class);
        myDog.say();
//        Dog yourDog = context.getBean("dog",Dog.class);
//
//        System.out.println("Переменные равны? " + (myDog==yourDog));
//        System.out.println(myDog);
//        System.out.println(yourDog);

        context.close();
    }
}
