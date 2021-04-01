package com.levi.demo.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicianResponse {
    private String id = UUID.randomUUID().toString();
}
