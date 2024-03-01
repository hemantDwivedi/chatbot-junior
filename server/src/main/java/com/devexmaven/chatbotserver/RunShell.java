//package com.devexmaven.chatbotserver;
//
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//
//@Component
//public class RunShell implements ApplicationRunner {
//
//    File file = new File("E:\\projects\\chatbot-junior\\server\\src\\main\\resources\\magic.sh");
//
//    String command = "bash " + file;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("running script");
//        Process exec = Runtime.getRuntime().exec(command);
//        System.out.println(exec.getInputStream().read());
//    }
//}