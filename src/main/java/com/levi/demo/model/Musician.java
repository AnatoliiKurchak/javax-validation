package com.levi.demo.model;

import com.levi.demo.validators.ValidEmail;
import com.levi.demo.validators.ValidMusicianType;
import com.levi.demo.validators.ValidNickName;
import com.levi.demo.validators.groups.FirstGroup;
import com.levi.demo.validators.groups.SecondGroup;
import com.levi.demo.validators.groups.ThirdGroup;
import java.util.List;
import javax.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Musician {
    @ValidNickName(groups = FirstGroup.class)
    private String nickName;

    @ValidEmail(groups = SecondGroup.class)
    private String email;

    @ValidMusicianType(groups = ThirdGroup.class)
    private String musicianType;

    @Valid
    private List<Costume> costumes;
}
