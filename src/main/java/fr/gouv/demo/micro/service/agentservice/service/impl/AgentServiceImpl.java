package fr.gouv.demo.micro.service.agentservice.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gouv.demo.micro.service.agentservice.dto.AgentRequestDto;
import fr.gouv.demo.micro.service.agentservice.dto.AgentResponseDto;
import fr.gouv.demo.micro.service.agentservice.entities.Agent;
import fr.gouv.demo.micro.service.agentservice.mappers.AgentMapper;
import fr.gouv.demo.micro.service.agentservice.repositories.AgentRepository;
import fr.gouv.demo.micro.service.agentservice.service.AgentService;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	@Autowired
	private AgentMapper agentMapper;
	
	@Override
	public AgentResponseDto save(AgentRequestDto agentRequestDto) {
		Agent agent = this.agentMapper.agentRequestDtoToAgent(agentRequestDto);
		return this.agentMapper.agentToAgentResponseDto(this.agentRepository.save(agent));
	}

	@Override
	public AgentResponseDto getAgent(String id) {
		Agent agent = agentRepository.findById(id).get();
		return this.agentMapper.agentToAgentResponseDto(agent);
	}

	@Override
	public AgentResponseDto update(AgentRequestDto agentRequestDto) {
		Agent agent = this.agentMapper.agentRequestDtoToAgent(agentRequestDto);
		return this.agentMapper.agentToAgentResponseDto(this.agentRepository.save(agent));
	}

	@Override
	public List<AgentResponseDto> listAgents() {
		List<Agent> agents = agentRepository.findAll();
		List<AgentResponseDto> toutAgentsResponseDtos = 
				agents.stream()
					.map(a -> agentMapper.agentToAgentResponseDto(a))
					.collect(Collectors.toList());
		return toutAgentsResponseDtos;
	}

}
