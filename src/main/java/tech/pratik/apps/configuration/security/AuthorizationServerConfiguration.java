package tech.pratik.apps.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by Pratik on 3/16/17.
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfiguration  extends AuthorizationServerConfigurerAdapter{
    private static final String RESOURCE_ID = "my_rest_api";



    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;


    @Bean
    public TokenStore tokenStore() {

        final JwtTokenStore tokenStore = new JwtTokenStore(jwtAccessTokenConverter());

        return tokenStore;
    }


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("chalchitra")
                .authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
                .authorities("ROLE_USER")
                .scopes("read", "write", "trust" )
                .resourceIds(RESOURCE_ID)
                .secret("chalchitra")
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(600)
                .and()

                // Public client where client secret is vulnerable (e.g. mobile apps, browsers)
                .withClient("public") // No secret!
                .authorizedGrantTypes("password","client_credentials", "implicit")
                .scopes("read")
                .redirectUris("http://localhost:8080/client/");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
              .tokenStore(tokenStore())
              .authenticationManager(authenticationManager)
              .accessTokenConverter(jwtAccessTokenConverter());

    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore());
        return  tokenServices;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        final JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("chalchitra");
        return  jwtAccessTokenConverter;
    }


}
