package com.example.race_team.service;

import com.example.race_team.model.Team;
import com.example.race_team.repository.TeamRepository;
import com.example.race_team.service.exception.TeamNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllValid() {
        List<Team> teamList = teamRepository.findAllValid();
        if (!teamList.isEmpty()) {
            log.info(teamList.stream().map(t -> t.getName())
                    .collect(Collectors
                            .joining(", ", "MSG: List of teams: [", "]")));
            return teamList;
        } else {
            throw new TeamNotFoundException("EXC: List is empty.");
        }
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList = teamRepository.findAll();
        if (!teamList.isEmpty()) {
            log.info(teamList.stream().map(t -> t.getName())
                    .collect(Collectors
                            .joining(", ", "MSG: List of all teams: [", "]")));
            return teamList;
        } else {
            // Depends on, it is a bug or a feature.
            throw new TeamNotFoundException("EXC: List is empty.");
        }
    }

    public void save(Team team) {
        log.info("MSG: " + team.getName() + " team have been saved.");
        teamRepository.save(team);
    }

    public void update(Team team) {
        var optTmpTeam = teamRepository.findById(team.getId());
        if (optTmpTeam.isPresent()) {
            var tmpTeam = optTmpTeam.get();
            tmpTeam.setName(team.getName());
            tmpTeam.setFoundationYear(team.getFoundationYear());
            tmpTeam.setWorldCupsWon(team.getWorldCupsWon());
            tmpTeam.setEntryFeePaid(team.isEntryFeePaid());
            tmpTeam.setValid(team.isValid());
            teamRepository.save(tmpTeam);
            log.info("MSG: " + team.getName() + " with id " + team.getId() + " will be updated.");
        } else {
            throw new TeamNotFoundException(team.getId());
        }
    }

    @Override
    public void remove(int id) {
        var optTeam = teamRepository.findById(id);
        if (optTeam.isPresent()) {
            var team = optTeam.get();
            teamRepository.delete(team);
            log.info("MSG: " + team.getName() + " with id " + team.getId() + " will be deleted.");
        } else {
            throw new TeamNotFoundException(id);
        }
    }

    @Override
    public void setToInvalid(int id) {
        var optTeam = teamRepository.findById(id);
        if (optTeam.isPresent()) {
            var team = optTeam.get();
            team.setValid(false);
            teamRepository.save(team);
            log.info("MSG: " + team.getName() + " with id " + team.getId() + " will set to invalid.");
        } else {
            throw new TeamNotFoundException(id);
        }
    }


    @Override
    public Team getTeamById(int id) {
        var optTeam = teamRepository.findById(id);
        if (optTeam.isPresent()) {
            return optTeam.get();
        } else {
            throw new TeamNotFoundException(id);
        }
    }
}