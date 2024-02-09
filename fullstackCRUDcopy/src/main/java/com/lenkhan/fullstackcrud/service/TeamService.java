package com.lenkhan.fullstackcrud.service;

import com.lenkhan.fullstackcrud.model.Team;
import com.lenkhan.fullstackcrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeamsSortedByPointsDesc(){
        return teamRepository.findAllByOrderByPointsDesc();
    }
}
