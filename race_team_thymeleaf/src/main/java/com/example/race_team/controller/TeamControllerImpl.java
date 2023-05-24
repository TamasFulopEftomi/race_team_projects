package com.example.race_team.controller;

import com.example.race_team.mapper.TeamAndTeamDtoMapper;
import com.example.race_team.model.Team;
import com.example.race_team.dto.TeamDto;
import com.example.race_team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class TeamControllerImpl implements TeamController {

    @Autowired
    private TeamService teamService;

    @Override
    public String list(Model model) {
        model.addAttribute("teamList", teamService.getAllValid());
        return "index";
    }

    @Override
    public String listAll(Model model) {
        model.addAttribute("teamList", teamService.getAll());
        return "index";
    }

    @Override
    public String add(Model model) {
        model.addAttribute("teamDto", new TeamDto());
        return "team_form";
    }

    @Override
    public String teamForm(TeamDto teamDto, Model model) {
        TeamAndTeamDtoMapper teamAndTeamDtoMapper = new TeamAndTeamDtoMapper();
        Team team = teamAndTeamDtoMapper.mapToTeam(teamDto);
        teamService.save(team);
        return "index";
    }

    @Override
    public String modify(int id, Model model) {
        Team team = teamService.getTeamById(id);
        TeamAndTeamDtoMapper teamAndTeamDtoMapper = new TeamAndTeamDtoMapper();
        TeamDto teamDto = teamAndTeamDtoMapper.mapToTeamDto(team);
        model.addAttribute("teamDto", teamDto);
        return "team_form";
    }


    @Override
    public String delete(int id) {
        teamService.getTeamById(id);
        teamService.remove(id);
        return "index";
    }

    @Override
    public String deleteInLogic(int id) {
        teamService.getTeamById(id);
        teamService.setToInvalid(id);
        return "index";
    }
}
