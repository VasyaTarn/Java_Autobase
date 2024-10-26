package com.example.Autobase;

import com.example.Autobase.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Scanner;

@SpringBootApplication
@EnableScheduling
public class AutobaseApplication {
	@Autowired
	private AutobaseInitializer initializer;

	@Autowired
	private TaskSchedulerService taskSchedulerService;

	public static void main(String[] args)
	{
		SpringApplication.run(AutobaseApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start()
	{
		initializer.autoBaseInitialize();
		taskSchedulerService.setInitializationComplete();
	}
}
