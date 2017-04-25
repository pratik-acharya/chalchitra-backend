package tech.pratik.apps.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.pratik.apps.user.domain.User;
import tech.pratik.apps.user.repository.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Pratik on 3/17/17.
 */
@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userRepository.findByEmail(email);
        System.out.println("--------------------here-------------"+user+"------"+email);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("--------------------user found-------------");

        if(user.getRoles()==null) throw new InsufficientAuthenticationException("User has no roles assigned");
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),true,true,true,true, getGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(User user){
        System.out.println("--------------------here-------role------");

        return user.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_"+role.getName().name()))
                .collect(Collectors.toList());
    }
}
