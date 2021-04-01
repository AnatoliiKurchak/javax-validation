package com.levi.demo.controllers;

import com.levi.demo.model.Musician;
import com.levi.demo.model.MusicianResponse;
import com.levi.demo.model.MusicianType;
import com.levi.demo.validators.NickNameAndEmailStartWithSameLetter;
import com.levi.demo.validators.ValidEmail;
import com.levi.demo.validators.ValidMusicianType;
import com.levi.demo.validators.ValidNickName;
import com.levi.demo.validators.groups.FirstGroup;
import com.levi.demo.validators.groups.FourthGroup;
import com.levi.demo.validators.groups.SecondGroup;
import com.levi.demo.validators.groups.ThirdGroup;
import com.levi.demo.validators.sequences.MusicianGroupSequence;
import com.levi.demo.validators.sequences.MusicianMethodLevelGroupSequence;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicians")
@Validated
public class MusicianController {

    @GetMapping
    @Validated(MusicianMethodLevelGroupSequence.class)
    @NickNameAndEmailStartWithSameLetter(groups = ThirdGroup.class)
    public ResponseEntity<List<MusicianResponse>> getMusicians(
        @RequestParam("nickName")
        @ValidNickName(groups = FirstGroup.class) String nickName,

        @RequestParam("email")
        @ValidEmail(groups = SecondGroup.class) String email,

        @RequestParam("type")
        @ValidMusicianType(groups = FourthGroup.class, types = MusicianType.ESTRADA) String type) {

        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping
    public ResponseEntity<MusicianResponse> postMusician(
        @RequestBody @Validated(MusicianGroupSequence.class) Musician musician) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MusicianResponse());
    }
}

