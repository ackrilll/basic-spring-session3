package com.sparta.basicspringsession3.dto;

import lombok.Getter;

@Getter
public class MemberUpdateresponseDto {
    private final Long id;
    private final String name;

    public MemberUpdateresponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
