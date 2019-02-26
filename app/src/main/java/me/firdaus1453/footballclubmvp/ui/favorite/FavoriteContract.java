package me.firdaus1453.footballclubmvp.ui.favorite;

import android.content.Context;

import java.util.List;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public interface FavoriteContract {

    interface View{
        void hideRefresh();
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListTeams(Context context);
        void searchTeams(Context context,String searchText);
    }

}
