package com.example.race_team.mapper;

import com.example.race_team.dto.TeamDto;
import com.example.race_team.model.Team;

public class TeamAndTeamDtoMapper {

    public Team mapToTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setId(teamDto.getId());
        team.setName(teamDto.getName());
        team.setFoundationYear(Integer.parseInt(teamDto.getFoundationYear()));
        team.setWorldCupsWon(Integer.parseInt(teamDto.getWorldCupsWon()));
        team.setEntryFeePaid(Boolean.parseBoolean(teamDto.getEntryFeePaid()));
        team.setValid(Boolean.parseBoolean(teamDto.getValid()));
        return team;
    }

    public TeamDto mapToTeamDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setId(team.getId());
        teamDto.setName(team.getName());
        teamDto.setFoundationYear(team.getFoundationYear() + "");
        teamDto.setWorldCupsWon(team.getWorldCupsWon() + "");
        teamDto.setEntryFeePaid(team.isEntryFeePaid() + "");
        teamDto.setValid(team.isValid() + "");
        return teamDto;
    }

}
