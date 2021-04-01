package com.levi.demo.model;

import com.levi.demo.validators.ValidColor;
import com.levi.demo.validators.ValidName;
import com.levi.demo.validators.groups.FifthGroup;
import com.levi.demo.validators.groups.FourthGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Costume {
    @ValidName(groups = FourthGroup.class)
    private String name;
    @ValidColor(groups = FifthGroup.class)
    private String color;
}
