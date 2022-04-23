package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

	@Autowired
	private MyPictureProducer myPictureProducer;

	//valid sources
	private final List<String> SOURCES = List.of("web", "mobile");
	//valid types
	private final List<String> TYPES = List.of("jpg", "png", "svg");

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<1; i++){
			var picture = new Picture();
			picture.setName("Picture " + i);
			picture.setSize(ThreadLocalRandom.current().nextLong(9000, 10000));
			picture.setType(TYPES.get(i % TYPES.size()));
			picture.setSource(SOURCES.get(i % SOURCES.size()));

			myPictureProducer.sendMessage(picture);
		}

	}
}
