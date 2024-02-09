package com.lenkhan.fullstackcrud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "team")
    private String team;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Team team;

    @Column(name = "rating")
    private double rating;

    @Column(name = "country")
    private String country;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Country country;
}
