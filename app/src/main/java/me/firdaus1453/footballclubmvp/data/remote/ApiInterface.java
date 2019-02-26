package me.firdaus1453.footballclubmvp.data.remote;

import me.firdaus1453.footballclubmvp.model.ResponseTeams;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search_all_teams.php")
    Call<ResponseTeams> getAllTeams(
            @Query("s") String s,
            @Query("c") String c
    );

//    https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=Arsenal
    @GET("searchteams.php")
    Call<ResponseTeams> getSearchTeams(@Query("t") String t);
}
