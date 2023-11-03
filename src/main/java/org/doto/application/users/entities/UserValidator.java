package org.doto.application.users.entities;

import br.com.fluentvalidator.AbstractValidator;
import jakarta.inject.Singleton;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringMatches;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeGreaterThan;

@Singleton
public class UserValidator extends AbstractValidator<UserEntity> {
    @Override
    public void rules() {
        ruleFor(UserEntity::gEmail)
        .must(not(nullValue()))
            .withMessage("is required.")
        .withFieldName("Email")
        ;

        ruleFor(UserEntity::getPassword)
        .must(not(nullValue()))
            .withMessage("is required.")
        .must(stringSizeGreaterThan(7))
            .withMessage("must have at least 8 digits.")
        .withFieldName("Password");

        ruleFor(UserEntity::getUsername)
        .must(not(nullValue()))
            .withMessage("is required.")
        .must(stringSizeGreaterThan(3))
            .withMessage("must have at least 8 digits.")
        .withFieldName("Username");

        ruleFor(UserEntity::getFullname)
        .must(not(nullValue()))
            .withMessage("is required.")
        .withFieldName("Full Name");
    }
    
}