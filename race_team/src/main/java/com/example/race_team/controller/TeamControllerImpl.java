package com.example.race_team.controller;

import com.example.race_team.model.Team;
import com.example.race_team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamControllerImpl implements TeamController {

    @Autowired
    private TeamService teamService;

    @Override
    public List<Team> list() {
        return teamService.getAllValid();
    }

    @Override
    public List<Team> listAll() {
        return teamService.getAll();
    }

    @Override
    public void add(Team team) {
        teamService.save(team);
    }

    @Override
    public void modify(Team team) {
        teamService.update(team);
    }

    @Override
    public void delete(int id) {
        teamService.remove(id);
    }

    @Override
    public void deleteInLogic(int id) {
        teamService.setToInvalid(id);
    }
}
