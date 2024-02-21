package br.malandrim.schoolgradeapplication.config;

import br.malandrim.schoolgradeapplication.entity.User;
import br.malandrim.schoolgradeapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);

        if (userEntity == null){
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles().forEach( role -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
                }
        );

        return new org.springframework.security.core.userdetails.User(
                "{noop}" + userEntity.getUsername(),
                "{noop}" + userEntity.getPassword(),
                authorities);

    }
}
