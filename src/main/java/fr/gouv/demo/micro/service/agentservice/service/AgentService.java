package fr.gouv.demo.micro.service.agentservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.gouv.demo.micro.service.agentservice.dto.AgentRequestDto;
import fr.gouv.demo.micro.service.agentservice.dto.AgentResponseDto;

public interface AgentService {

	AgentResponseDto save(AgentRequestDto agentRequestDto);
	
	AgentResponseDto getAgent(String id);
	
	AgentResponseDto update(AgentRequestDto agentRequestDto);
	
	List<AgentResponseDto> listAgents();
	
}
