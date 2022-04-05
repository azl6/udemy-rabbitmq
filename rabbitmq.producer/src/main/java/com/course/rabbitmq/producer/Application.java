package com.course.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import producer.HelloRabbitProducer;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Configuration
	public class TemplateConfig{
		@Bean
		public HelloRabbitProducer helloRabbitProducer(){
			return new HelloRabbitProducer();
		}
	}

	@Autowired
	private HelloRabbitProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Alex" + Math.random());
	}
}
