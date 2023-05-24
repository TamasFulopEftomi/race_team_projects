package com.example.race_team.controller;


import com.example.race_team.model.Team;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeamController {

    @GetMapping("/list")
    List<Team> list();

    @GetMapping("/list-all")
    List<Team> listAll();

    @PostMapping("/add")
    void add(@RequestBody Team team);

    @PostMapping("/modify")
    void modify(@RequestBody Team team);

    @GetMapping("/delete")
    void delete(@RequestParam int id);

    @GetMapping("/delete-in-logic")
    void deleteInLogic(@RequestParam int id);
}
