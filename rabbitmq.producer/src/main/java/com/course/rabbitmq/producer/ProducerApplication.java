package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HumanResourceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

//	@Autowired
//	private HelloRabbitProducer producer;

//	@Autowired
//	private EmployeeJsonProducer employeeJsonProducer;

	@Autowired
	private HumanResourceProducer humanResourceProducer;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		producer.sendHello("Alex" + Math.random());
//		employeeJsonProducer.sendMessage(new Employee("1", "Alex", LocalDate.now()));

		for(int i=1; i <= 5; i++){
			var employee = new Employee("emp" + i, "Employee" + i, LocalDate.now());
			humanResourceProducer.sendMessage(employee);
		}

	}
}
