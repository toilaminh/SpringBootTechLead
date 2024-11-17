package com.example.demo.service;

import com.example.demo.model.entity.AppUser;
import com.example.demo.model.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username);
        Role userRole = roleRepository.findRoleById(appUser.getRole().getId());
        if(appUser != null){
            var springUser = User.withUsername(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(userRole.getName()).build();
            return springUser;
        }
        return null;
    }
}
