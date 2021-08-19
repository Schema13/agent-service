package fr.gouv.demo.micro.service.agentservice;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.gouv.demo.micro.service.agentservice.dto.AgentRequestDto;
import fr.gouv.demo.micro.service.agentservice.service.AgentService;

@SpringBootApplication
public class AgentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgentServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(AgentService agentService) {
		return args -> {
			agentService.save(new AgentRequestDto("A01", "PERESSILD", "LOULIA", "loulia.peressild@gmail.com"));
			agentService.save(new AgentRequestDto("A02", "MEIR", "JESSICA", "jessica.meird@gmail.com"));
			agentService.save(new AgentRequestDto("A03", "YAMAZAKI", "NAOKO", "naoko.yamazaki@gmail.com"));
			agentService.save(new AgentRequestDto("A04", "SO-YEON", "YI", "yi.so-yeon@gmail.com"));
		};
	}

}
