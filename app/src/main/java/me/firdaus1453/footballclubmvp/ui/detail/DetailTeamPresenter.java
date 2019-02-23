package me.firdaus1453.footballclubmvp.ui.detail;

import android.content.Context;
import android.os.Bundle;

import me.firdaus1453.footballclubmvp.data.local.FootballDatabase;
import me.firdaus1453.footballclubmvp.model.TeamsItem;
import me.firdaus1453.footballclubmvp.utils.Constants;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class DetailTeamPresenter implements DetailTeamContract.Presenter {

    private final DetailTeamContract.View view;
    private TeamsItem teamsItem;
    private FootballDatabase footballDatabase;

    public DetailTeamPresenter(DetailTeamContract.View view) {
        this.view = view;
    }

    @Override
    public void getDetailTeam(Bundle bundle) {
        if (bundle != null) {
            teamsItem = (TeamsItem) bundle.getSerializable(Constants.KEY_DATA);
            view.showDetailTeam(teamsItem);
        } else {
            view.showFailureMessage("Data kosong");
        }
    }

    @Override
    public void addToFavorite(Context context, TeamsItem teamsItem) {

        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().insertItem(teamsItem);
        view.showSuccessMessage("Tersimpan");

    }

    @Override
    public void removeFavorite(Context context, TeamsItem teamsItem) {

        footballDatabase = FootballDatabase.getFootballDatabase(context);
        footballDatabase.footballDao().delete(teamsItem);
        view.showSuccessMessage("Terhapus");

    }

    @Override
    public Boolean checkFavorite(Context context, TeamsItem teamsItem) {
        Boolean bFavorite = false;
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        bFavorite = footballDatabase.footballDao().selectItem(teamsItem.getIdTeam()) != null;
        return bFavorite;
    }

}
