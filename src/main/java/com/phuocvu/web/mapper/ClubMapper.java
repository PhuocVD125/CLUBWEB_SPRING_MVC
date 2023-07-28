package com.phuocvu.web.mapper;

import com.phuocvu.web.dto.ClubDto;
import com.phuocvu.web.models.Club;

import java.util.stream.Collectors;

import static com.phuocvu.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club maptoClub(ClubDto club) {
        Club clubDto = Club.builder()
                .id(club.getId())
                .title((club).getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return clubDto;
    }
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
