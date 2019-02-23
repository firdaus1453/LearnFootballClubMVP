package me.firdaus1453.footballclubmvp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "teams")
public class TeamsItem implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String strTeam;

    @ColumnInfo(name = "strDescriptionEN")
    @SerializedName("strDescriptionEN")
    private String strDescriptionEN;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    public TeamsItem(String idTeam, String strTeam, String strDescriptionEN, String strTeamBadge) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strDescriptionEN = strDescriptionEN;
        this.strTeamBadge = strTeamBadge;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }
}
