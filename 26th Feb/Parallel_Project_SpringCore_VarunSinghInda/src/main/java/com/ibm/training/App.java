package com.ibm.training;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        UI ui = context.getBean("ui",UI.class);
        ui.menu();
    }
}
