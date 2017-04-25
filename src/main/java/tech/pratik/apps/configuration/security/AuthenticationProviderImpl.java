package tech.pratik.apps.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Pratik on 3/17/17.
 */
@Component
public class AuthenticationProviderImpl extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
        System.out.println("I am here");
        if(token.getCredentials()==null || userDetails.getPassword()==null){
                throw new BadCredentialsException("Credentials may not be null");
            }

            if(!passwordEncoder().matches((String) token.getCredentials(),userDetails.getPassword())){
                throw  new BadCredentialsException("Email or password invalid");

            }
    }

    @Override
    protected UserDetails retrieveUser(String email, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return userDetailsService.loadUserByUsername(email);
    }
}
