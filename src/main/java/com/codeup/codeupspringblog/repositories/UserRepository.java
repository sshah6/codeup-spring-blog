package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.Model.Post;
import com.codeup.codeupspringblog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
