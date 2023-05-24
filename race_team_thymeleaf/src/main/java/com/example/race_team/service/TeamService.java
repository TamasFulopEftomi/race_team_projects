package com.example.race_team.service;

import com.example.race_team.model.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllValid();
    List<Team> getAll();
    void update(Team team);
    void save(Team team);
    void remove(int id);
    void setToInvalid(int id);
    Team getTeamById(int id);
}
