package fr.gouv.demo.micro.service.agentservice.mappers;

import org.mapstruct.Mapper;

import fr.gouv.demo.micro.service.agentservice.dto.AgentRequestDto;
import fr.gouv.demo.micro.service.agentservice.dto.AgentResponseDto;
import fr.gouv.demo.micro.service.agentservice.entities.Agent;

@Mapper(componentModel = "spring")
public interface AgentMapper {

	AgentResponseDto agentToAgentResponseDto(Agent agent);
	
	Agent agentRequestDtoToAgent(AgentRequestDto agentRequestDto);
	
}
