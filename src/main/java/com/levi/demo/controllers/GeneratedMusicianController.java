package com.levi.demo.controllers;

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
import com.levi.javax_validation.api.GeneratedMusiciansApi;
import com.levi.javax_validation.model.GeneratedMusicianResponse;
import com.levi.javax_validation.model.MusicianRequest;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratedMusicianController implements GeneratedMusiciansApi {

    @Override
    @Validated(MusicianMethodLevelGroupSequence.class)
    @NickNameAndEmailStartWithSameLetter(groups = ThirdGroup.class)
    public ResponseEntity<List<GeneratedMusicianResponse>> getMusicians(
        @RequestParam("nickName")
        @ValidNickName(groups = FirstGroup.class) String nickName,

        @RequestParam("email")
        @ValidEmail(groups = SecondGroup.class) String email,

        @RequestParam("type")
        @ValidMusicianType(groups = FourthGroup.class, types = MusicianType.LEGACY_ARTIST) String type) {

        return ResponseEntity.ok(Collections.emptyList());
    }

    @Override
    public ResponseEntity<List<GeneratedMusicianResponse>> createMusician(
        @RequestBody @Validated(MusicianGroupSequence.class) MusicianRequest musicianRequest) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
            .body(Collections.singletonList(new GeneratedMusicianResponse().id(UUID.randomUUID().toString())));
    }
}

