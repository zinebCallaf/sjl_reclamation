package com.sjl.reclamation.model.dao.impl;

import com.sjl.reclamation.model.entity.Agent;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgentDaoTest {

    private AgentDao agentDao = new AgentDao();

    @Test
    public void shouldGetAllAgents(){
        agentDao.persist(new Agent());
        final List<Agent> actual = agentDao.findAll();
        assertThat(actual).hasSize(1);
    }

}