package tech.pratik.apps.user.validator;

import org.springframework.beans.factory.annotation.Autowired;
import tech.pratik.apps.user.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Pratik on 3/23/17.
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail unique) {}


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (userRepository == null)
            return true;
        return userRepository.findByEmail(email) == null;
    }
}