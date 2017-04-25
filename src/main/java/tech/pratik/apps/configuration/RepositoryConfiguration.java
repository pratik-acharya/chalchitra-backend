package tech.pratik.apps.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;
import tech.pratik.apps.user.handler.UserEventHandler;


/**
 * Created by Pratik on 3/17/17.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter{
    @Autowired
    Validator validator;

    @Bean
    public UserEventHandler userEventHandler(){
        return  new UserEventHandler();
    }


    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate",validator);
    }
}
