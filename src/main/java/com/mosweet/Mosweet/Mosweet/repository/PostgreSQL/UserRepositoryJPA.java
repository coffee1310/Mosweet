package com.mosweet.Mosweet.Mosweet.repository.PostgreSQL;

import com.mosweet.Mosweet.Mosweet.entity.PostgreSQL.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {
}
