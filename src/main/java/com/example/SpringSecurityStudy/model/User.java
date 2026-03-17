package com.example.SpringSecurityStudy.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Column(length = 225, nullable = false)
    private String password;

}