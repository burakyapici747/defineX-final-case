package com.defineXfinalcase.service.impl;

import com.defineXfinalcase.constant.EntityConstant;
import com.defineXfinalcase.model.User;
import com.defineXfinalcase.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = getUserByEmail(username);
        final List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()) ;

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    private User getUserByEmail(final String username){
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException(EntityConstant.NOT_FOUND_DATA));
    }
}
