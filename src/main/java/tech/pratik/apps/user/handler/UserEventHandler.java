package tech.pratik.apps.user.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.password.PasswordEncoder;
import tech.pratik.apps.user.domain.Role;
import tech.pratik.apps.user.domain.RoleName;
import tech.pratik.apps.user.domain.Status;
import tech.pratik.apps.user.domain.User;
import tech.pratik.apps.user.repository.RoleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Pratik on 3/17/17.
 */
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @HandleBeforeSave
    public void handlePersonSave(User user) {
        System.out.println("save person called");
    }

    @HandleBeforeCreate
    public void handlePersonCreate(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setJoinedDate(new Date());
        user.setStatus(Status.ACTIVE);
        List<Role> roles = new ArrayList<Role>() {
            {
                add(roleRepository.findByName(RoleName.USER));
            }
        };
        user.setRoles(roles);


    }


}
