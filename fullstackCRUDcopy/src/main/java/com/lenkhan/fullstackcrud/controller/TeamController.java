package com.lenkhan.fullstackcrud.controller;

import com.lenkhan.fullstackcrud.exception.PlayerNotFoundException;
import com.lenkhan.fullstackcrud.exception.TeamNotFoundException;
import com.lenkhan.fullstackcrud.model.Team;
import com.lenkhan.fullstackcrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/team")
    Team newTeam(@RequestBody Team newTeam){
        return teamRepository.save(newTeam);
    }

    @GetMapping("/teams")
    List<Team> getAllTeams(){
        return teamRepository.findAllByOrderByPointsDesc();
    }

    @GetMapping("/team/{id}")
    Team getTeamById(@PathVariable Long id){
        return teamRepository.findById(id)
                .orElseThrow(()->new TeamNotFoundException(id));
    }

    @PutMapping("/team/{id}")
    Team updateTeam(@RequestBody Team newTeam,@PathVariable Long id){
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(newTeam.getName());
                    team.setCountry(newTeam.getCountry());
                    team.setPoints(newTeam.getPoints());
                    return teamRepository.save(team);
                }).orElseThrow(()->new TeamNotFoundException(id));
    }

    @DeleteMapping("/team/{id}")
    String deleteTeam(@PathVariable Long id){
        if(!teamRepository.existsById(id)){
            throw new TeamNotFoundException(id);

        }
        teamRepository.deleteById(id);
        return "Team with id:" + id + "was deleted";
    }
}
