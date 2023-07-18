package com.phuocvu.web.service;

import com.phuocvu.web.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
