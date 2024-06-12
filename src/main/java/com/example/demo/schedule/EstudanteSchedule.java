package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EstudanteSchedule {

	/*@Scheduled(fixedDelay = 2000)*/
	/*seg(0-59) - min(0-59) - h(0-23) - dia(1-31-*) - mes(1-12*) - dias da semana(1-7-*)*/
	@Scheduled(cron = "1 2 3 4 5 6")
	public void executarTarefa() {
		log.info("Tarefa executada!");
	}
	
}
