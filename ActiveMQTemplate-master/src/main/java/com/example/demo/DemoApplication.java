package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import receiver.MyReceiver;
import receiver.MyReceiverTopic;
import sender.MySender;
import sender.MySenderTopic;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		MySenderTopic.main(args);
		MyReceiverTopic.main(args);
		
		MySender.main(args);
		MyReceiver.main(args);
	}
}
