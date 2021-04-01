package com.levi.demo.validators.contributors;

import com.levi.demo.validators.ValidColor;
import com.levi.demo.validators.ValidEmail;
import com.levi.demo.validators.ValidMusicianType;
import com.levi.demo.validators.ValidName;
import com.levi.demo.validators.ValidNickName;
import com.levi.demo.validators.groups.FifthGroup;
import com.levi.demo.validators.groups.FirstGroup;
import com.levi.demo.validators.groups.FourthGroup;
import com.levi.demo.validators.groups.SecondGroup;
import com.levi.demo.validators.groups.ThirdGroup;
import com.levi.javax_validation.model.MusicianCostume;
import com.levi.javax_validation.model.MusicianRequest;
import java.lang.annotation.Annotation;
import org.hibernate.validator.cfg.GenericConstraintDef;
import org.hibernate.validator.spi.cfg.ConstraintMappingContributor;

public class MusicianRequestConstraintMappingContributor implements ConstraintMappingContributor {

    @Override
    public void createConstraintMappings(ConstraintMappingBuilder constraintMappingBuilder) {
        constraintMappingBuilder.addConstraintMapping()
            .type(MusicianRequest.class)
            .ignoreAllAnnotations()
            .field("nickName")
                .constraint(createConstraint(ValidNickName.class, FirstGroup.class))
            .field("email")
                .constraint(createConstraint(ValidEmail.class, SecondGroup.class))
            .field("musicianType")
                .constraint(createConstraint(ValidMusicianType.class, ThirdGroup.class))
            .field("costumes")
            .valid();

        constraintMappingBuilder.addConstraintMapping()
            .type(MusicianCostume.class)
            .ignoreAllAnnotations()
            .field("name")
                .constraint(createConstraint(ValidName.class, FourthGroup.class))
            .field("color")
                .constraint(createConstraint(ValidColor.class, FifthGroup.class));
    }

    private <T extends Annotation> GenericConstraintDef<T> createConstraint(Class<T> annotation) {
        return new GenericConstraintDef<>(annotation);
    }

    private <T extends Annotation> GenericConstraintDef<T> createConstraint(Class<T> annotation, Class<?> group) {
        return new GenericConstraintDef<>(annotation).groups(group);
    }

}
