package me.firdaus1453.footballclubmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTeams {

    @SerializedName("teams")
    private List<TeamsItem> teams;

    public List<TeamsItem> getTeams() {
        return teams;
    }
}
