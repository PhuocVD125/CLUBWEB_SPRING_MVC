package com.phuocvu.web.service;

import com.phuocvu.web.dto.ClubDto;
import com.phuocvu.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(Club club);
    ClubDto findClubById(long clubId);
    void updateClub(ClubDto club);
}
