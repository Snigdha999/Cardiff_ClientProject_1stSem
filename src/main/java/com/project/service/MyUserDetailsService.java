package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.Accounts;
import com.project.repository.AccountsRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Accounts> account = accountsRepository.findByUsername(username);

        account.orElseThrow(() -> new UsernameNotFoundException("The username '" + username + "' does not exist."));

        return account.map(MyUserDetails::new).get();
    }
    
}
