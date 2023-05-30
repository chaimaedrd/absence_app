package com.chaimae.absence_app.services;

import com.chaimae.absence_app.models.Compte;
import com.chaimae.absence_app.repositories.CompteRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class CompteService implements UserDetailsService {
    @Autowired
    private CompteRepo compteRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Compte> opt = compteRepo.findByLogin((login));
        if(opt.isEmpty())
            throw new UsernameNotFoundException("User with login: "+login+" not found!");
        else{
            Compte compte = opt.get();
            return  new User(
                    compte.getLogin(),
                    compte.getPassword(),
                    (Collection<? extends GrantedAuthority>) compte.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getNomRole()))
                            .collect(Collectors.toList())
            );
        }
    }
}
