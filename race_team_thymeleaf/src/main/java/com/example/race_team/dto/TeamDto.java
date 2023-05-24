package com.example.race_team.dto;

public class TeamDto {

    private Integer id;
    private String name;
    private String foundationYear;
    private String worldCupsWon;
    private String entryFeePaid;
    private String valid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getWorldCupsWon() {
        return worldCupsWon;
    }

    public void setWorldCupsWon(String worldCupsWon) {
        this.worldCupsWon = worldCupsWon;
    }

    public String getEntryFeePaid() {
        return entryFeePaid;
    }

    public void setEntryFeePaid(String entryFeePaid) {
        this.entryFeePaid = entryFeePaid;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
