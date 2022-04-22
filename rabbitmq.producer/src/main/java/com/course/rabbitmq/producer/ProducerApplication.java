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
	private FurnitureProducer furnitureProducer;

	//valid sources
	private final List<String> COLORS = List.of("white", "red", "green");
	//valid types
	private final List<String> MATERIALS = List.of("wood", "plastic", "steel");

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<10; i++){
			var furniture = new Furniture();
			furniture.setName("Furniture " + i);
			furniture.setColor(COLORS.get(i % COLORS.size()));
			furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));

			furnitureProducer.sendMessage(furniture);
		}

	}
}
