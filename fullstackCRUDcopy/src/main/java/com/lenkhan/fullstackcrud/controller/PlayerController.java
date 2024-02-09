package com.lenkhan.fullstackcrud.controller;
import com.lenkhan.fullstackcrud.exception.PlayerNotFoundException;
import com.lenkhan.fullstackcrud.model.Player;
import com.lenkhan.fullstackcrud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/player")
    Player newPlayer(@RequestBody Player newPlayer){
        return playerRepository.save(newPlayer);
    }

    @GetMapping("/players")
    List<Player> getAllPlayers(){
        return playerRepository.findAllByOrderByRatingDesc();
    }

    @GetMapping("/player/{id}")
    Player getPlayerById(@PathVariable Long id){
        return playerRepository.findById(id)
                .orElseThrow(()->new PlayerNotFoundException(id));
    }

    @PutMapping("/player/{id}")
    Player updatePlayer(@RequestBody Player newPlayer,@PathVariable Long id){
        return playerRepository.findById(id)
                .map(player -> {
                    player.setFullname(newPlayer.getFullname());
                    player.setNickname(newPlayer.getNickname());
                    player.setTeam(newPlayer.getTeam());
                    player.setRating(newPlayer.getRating());
                    player.setCountry(newPlayer.getCountry());
                    return playerRepository.save(player);
                }).orElseThrow(()->new PlayerNotFoundException(id));
    }

    @DeleteMapping("/player/{id}")
    String deletePlayer(@PathVariable Long id){
        if(!playerRepository.existsById(id)){
            throw new PlayerNotFoundException(id);

        }
        playerRepository.deleteById(id);
        return "Player with id:" + id + "was deleted";
    }
}
