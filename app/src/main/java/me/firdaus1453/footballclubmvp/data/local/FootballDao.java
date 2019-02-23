package me.firdaus1453.footballclubmvp.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

@Dao
public interface FootballDao {

    @Insert
    void insertItem(TeamsItem teamsItemList);

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    TeamsItem selectItem(String id);

    @Delete
    void delete(TeamsItem teamsItem);

//    @Insert
//    void insert(List<TeamsItem> teamsItemList);
//
    @Query("SELECT * FROM teams ORDER BY strTeam ASC")
    List<TeamsItem> selectFavorite();

//    @Update
//    void update(TeamsItem teamsItem);
}
