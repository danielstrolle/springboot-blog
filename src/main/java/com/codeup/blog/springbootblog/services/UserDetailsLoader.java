package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.models.UserWithRoles;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UsersRepository userDao;

    public UserDetailsLoader(UsersRepository userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Sorry, cannot find username: " + username + " in our database");
        }
        return new UserWithRoles(user);
    }
}
