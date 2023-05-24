package com.example.race_team.controller;


import com.example.race_team.dto.TeamDto;
import com.example.race_team.model.Team;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface TeamController {

    @GetMapping("/list")
    String list(Model model);

    @GetMapping("/list-all")
    String listAll(Model model);

    @GetMapping("/add")
    String add(Model model);

    @PostMapping("/team-form")
    String teamForm(TeamDto teamDto, Model model);

    @PostMapping("/modify")
    String modify(int id, Model model);

    @PostMapping("/delete")
    String delete(int id);

    @PostMapping("/delete-in-logic")
    String deleteInLogic(int id);
}
