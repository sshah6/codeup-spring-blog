package com.codeup.codeupspringblog.Model;

import com.codeup.codeupspringblog.repositories.UserRepository;

import java.util.List;
import java.util.Random;

public class Users {
    public static User randomUser(UserRepository usersDao){
        List<User> allusers = usersDao.findAll();
        int random = new Random().nextInt(allusers.size());
        return allusers.get(random);
    }
}
