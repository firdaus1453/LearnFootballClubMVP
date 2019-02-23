package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;

import me.firdaus1453.footballclubmvp.data.local.FootballDatabase;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class FavoritePresenter implements FavoriteContract.Presenter{

    private final FavoriteContract.View view;
    private FootballDatabase footballDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams(Context context) {
        footballDatabase = FootballDatabase.getFootballDatabase(context);
        if (footballDatabase.footballDao().selectFavorite() != null){
            view.showDataList(footballDatabase.footballDao().selectFavorite());
        }else {
            view.showFailureMessage("Tidak ada data favorite");
        }
        view.hideRefresh();

    }
}
