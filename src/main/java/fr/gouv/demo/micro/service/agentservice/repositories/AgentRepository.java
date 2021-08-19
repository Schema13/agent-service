package fr.gouv.demo.micro.service.agentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gouv.demo.micro.service.agentservice.entities.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String>{

}
