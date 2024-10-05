package com.p.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.p.demo.doctor.doctor;
import com.p.demo.medicine.medicine;
import com.p.demo.nurse.nurse;
import com.p.demo.vaccine.vaccine;

@SpringBootApplication
@EnableEurekaClient
public class ClientDiplomathesisApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ClientDiplomathesisApplication.class, args);
		
		doctor doctor = new doctor();
		medicine medicine = new medicine();
		vaccine vaccine = new vaccine();
		nurse nurse = new nurse();
		
		while (true) {
			doctor.getAllDoctors();
			medicine.getMedicine("2");
			Thread.sleep(5000);
			vaccine.getAllVaccines();
			Thread.sleep(9000);
			nurse.getAllNurses();
			Thread.sleep(2000);
			doctor.getDoctor("2");
			Thread.sleep(8000);
		}
	}

}
