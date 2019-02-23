package me.firdaus1453.footballclubmvp.ui.teams;

import android.content.Context;

import java.util.List;

import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public interface TeamsContract {

    interface View{
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListTeams();
    }
}
