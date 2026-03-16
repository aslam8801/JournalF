package com.engineeringdigest.journalApp;

import org.springframework.boot.SpringApplication;

public class TestJournalAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(JournalApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
