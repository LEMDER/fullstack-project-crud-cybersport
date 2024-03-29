package com.lenkhan.fullstackcrud.repository;

import com.lenkhan.fullstackcrud.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAllByOrderByPointsDesc();
}
