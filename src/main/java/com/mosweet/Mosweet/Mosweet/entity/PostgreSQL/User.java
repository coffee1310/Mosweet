package com.mosweet.Mosweet.Mosweet.entity.PostgreSQL;

import com.mosweet.Mosweet.Mosweet.entity.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;

    private String password;

    private Role role;


}
