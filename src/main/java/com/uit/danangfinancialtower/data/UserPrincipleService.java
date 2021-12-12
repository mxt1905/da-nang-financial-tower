package com.uit.danangfinancialtower.data;

import com.uit.danangfinancialtower.entity.UserEntity;
import com.uit.danangfinancialtower.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * UserPrincipleService
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserPrincipleService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
        Optional<UserEntity> optional = userRepository.findByUsername(username);
        if (optional.isEmpty())
            throw new UsernameNotFoundException("Username not found");
        UserEntity user = optional.get();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRole().getPermissions().forEach(permission -> grantedAuthorities
            .add(new SimpleGrantedAuthority(permission.getId().name())));
        return new UserPrinciple(
            user.getUsername(),
            passwordEncoder.encode(user.getPassword()),
            grantedAuthorities,
            true,
            true,
            true,
            true
        );
    }
}
