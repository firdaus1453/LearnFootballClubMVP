package me.firdaus1453.footballclubmvp.ui.favorite;


import android.app.ProgressDialog;
import android.os.Bundle;
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
import butterknife.Unbinder;
import me.firdaus1453.footballclubmvp.R;
import me.firdaus1453.footballclubmvp.model.TeamsItem;
import me.firdaus1453.footballclubmvp.ui.teams.TeamsAdapter;
import me.firdaus1453.footballclubmvp.ui.teams.TeamsPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteContract.View{

    @BindView(R.id.rv_favorite)
    RecyclerView rvFavorite;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    private final FavoritePresenter favoriteFragment = new FavoritePresenter(this);

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        unbinder = ButterKnife.bind(this, view);


        favoriteFragment.getDataListTeams(getContext());

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                favoriteFragment.getDataListTeams(getContext());
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void hideRefresh() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showDataList(List<TeamsItem> teamsItemList) {
        rvFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFavorite.setAdapter(new TeamsAdapter(getContext(),teamsItemList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        favoriteFragment.getDataListTeams(getContext());
    }
}
