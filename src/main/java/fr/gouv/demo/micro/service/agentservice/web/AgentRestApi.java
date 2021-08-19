package fr.gouv.demo.micro.service.agentservice.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gouv.demo.micro.service.agentservice.dto.AgentRequestDto;
import fr.gouv.demo.micro.service.agentservice.dto.AgentResponseDto;
import fr.gouv.demo.micro.service.agentservice.service.AgentService;

@RestController
@RequestMapping(path = "/api")
public class AgentRestApi {

	@Autowired
	private AgentService agentService;
	
	@RequestMapping(path = "/agents")
	public List<AgentResponseDto> tousAgents() {
		return this.agentService.listAgents();
	}
	
	@RequestMapping(path = "/agent/save")
	public AgentResponseDto save(@RequestBody AgentRequestDto agentRequestDto) {
		agentRequestDto.setId(UUID.randomUUID().toString());
		return this.agentService.save(agentRequestDto);
	}
	
	@RequestMapping(path = "/agent/{id}")
	public AgentResponseDto getAgent(@PathVariable String id) {
		return this.agentService.getAgent(id);
	}
	
	@RequestMapping(path = "/agent/update")
	public AgentResponseDto update(@RequestBody AgentRequestDto agentRequestDto) {
		return this.agentService.update(agentRequestDto);
	}
}
