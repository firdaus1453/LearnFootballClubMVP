package me.firdaus1453.footballclubmvp.ui.detail;

import android.content.Context;
import android.os.Bundle;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public interface DetailTeamContract {

    interface View{
        void showDetailTeam(TeamsItem teamsItem);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface Presenter{
        void getDetailTeam(Bundle bundle);
        void addToFavorite(Context context, TeamsItem teamsItem);
        void removeFavorite(Context context, TeamsItem teamsItem);
        Boolean checkFavorite(Context context, TeamsItem teamsItem);
    }
}
