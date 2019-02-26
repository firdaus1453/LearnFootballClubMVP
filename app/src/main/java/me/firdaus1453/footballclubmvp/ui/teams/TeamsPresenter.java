package me.firdaus1453.footballclubmvp.ui.teams;

import me.firdaus1453.footballclubmvp.data.remote.ApiClient;
import me.firdaus1453.footballclubmvp.data.remote.ApiInterface;
import me.firdaus1453.footballclubmvp.model.ResponseTeams;
import me.firdaus1453.footballclubmvp.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by firdaus1453 on 2/21/2019.
 */
public class TeamsPresenter implements TeamsContract.Presenter {

    private final TeamsContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public TeamsPresenter(TeamsContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams() {
        view.showProgress();

        Call<ResponseTeams> call = apiInterface.getAllTeams(Constants.S, Constants.C);
        call.enqueue(new Callback<ResponseTeams>() {
            @Override
            public void onResponse(Call<ResponseTeams> call, Response<ResponseTeams> response) {
                view.hideProgress();
                if (response.body() != null) {
                    view.showDataList(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(Call<ResponseTeams> call, Throwable throwable) {
                view.hideProgress();
                view.showFailureMessage(throwable.getMessage());
            }
        });
    }

    @Override
    public void searchTeams(String searchText) {
        if (!searchText.isEmpty()) {
            view.showProgress();
            Call<ResponseTeams> call = apiInterface.getSearchTeams(searchText);
            call.enqueue(new Callback<ResponseTeams>() {
                @Override
                public void onResponse(Call<ResponseTeams> call, Response<ResponseTeams> response) {
                    view.hideProgress();
                    if (response.body() != null) {
                        if (response.body().getTeams() != null) {
                            view.showDataList(response.body().getTeams());
                        }else {
                            view.showFailureMessage("Team tidak ada");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseTeams> call, Throwable throwable) {
                    view.hideProgress();
                    view.showFailureMessage(throwable.getMessage());
                }
            });
        } else {
            getDataListTeams();
        }
    }
}
