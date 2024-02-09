package com.lenkhan.fullstackcrud.service;

import com.lenkhan.fullstackcrud.model.Player;
import com.lenkhan.fullstackcrud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayersSortedByRatingDesc(){
        return playerRepository.findAllByOrderByRatingDesc();
    }
}
