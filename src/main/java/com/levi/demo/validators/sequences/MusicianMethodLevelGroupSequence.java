package com.levi.demo.validators.sequences;

import com.levi.demo.validators.groups.FirstGroup;
import com.levi.demo.validators.groups.FourthGroup;
import com.levi.demo.validators.groups.SecondGroup;
import com.levi.demo.validators.groups.ThirdGroup;
import javax.validation.GroupSequence;

@GroupSequence({
    FirstGroup.class,
    SecondGroup.class,
    ThirdGroup.class,
    FourthGroup.class
})
public interface MusicianMethodLevelGroupSequence {

}
