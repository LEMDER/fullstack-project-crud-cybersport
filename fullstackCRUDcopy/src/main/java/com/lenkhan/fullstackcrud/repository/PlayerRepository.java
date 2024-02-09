package com.lenkhan.fullstackcrud.repository;

import com.lenkhan.fullstackcrud.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByOrderByRatingDesc();
}
