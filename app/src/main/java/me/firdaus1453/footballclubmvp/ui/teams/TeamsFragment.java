package me.firdaus1453.footballclubmvp.ui.teams;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.firdaus1453.footballclubmvp.R;
import me.firdaus1453.footballclubmvp.model.TeamsItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsFragment extends Fragment implements TeamsContract.View {

    @BindView(R.id.rv_teams)
    RecyclerView rvTeams;
    Unbinder unbinder;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    private ProgressDialog progressDialog;
    private final TeamsPresenter teamsPresenter = new TeamsPresenter(this);

    public TeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teams, container, false);
        unbinder = ButterKnife.bind(this, view);


        teamsPresenter.getDataListTeams();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                teamsPresenter.getDataListTeams();
            }
        });
        return view;

    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        rvTeams.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTeams.setAdapter(new TeamsAdapter(getContext(),teamsItemList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
