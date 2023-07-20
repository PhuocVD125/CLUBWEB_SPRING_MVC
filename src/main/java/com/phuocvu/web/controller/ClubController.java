package com.phuocvu.web.controller;

import com.phuocvu.web.dto.ClubDto;
import com.phuocvu.web.models.Club;
import com.phuocvu.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClub(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubID}/edit")
    public String editClubFrom(@PathVariable("clubID") long clubID,
                               Model model) {
        ClubDto club = clubService.findClubById(clubID);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubID}/edit")
    public String updateClub(@PathVariable("clubID") long clubID,
                             @ModelAttribute("club") ClubDto club
    ) {
        club.setId(clubID);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
