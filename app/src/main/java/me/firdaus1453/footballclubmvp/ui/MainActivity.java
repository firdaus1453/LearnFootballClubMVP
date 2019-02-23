package me.firdaus1453.footballclubmvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.firdaus1453.footballclubmvp.R;
import me.firdaus1453.footballclubmvp.ui.favorite.FavoriteFragment;
import me.firdaus1453.footballclubmvp.ui.teams.TeamsFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_teams:
// Menmapilkan title
                    getSupportActionBar().setTitle("Teams");
                    // Menampilkan teams fragment
                    TeamsFragment teamsFragment = new TeamsFragment();
                    loadFragment(teamsFragment);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    return true;
                case R.id.navigation_favorite:
// Menmapilkan title
                    getSupportActionBar().setTitle("Favorite Teams");
                    // Menampilkan favorite fragment
                    FavoriteFragment favoriteFragment = new FavoriteFragment();
                    loadFragment(favoriteFragment);
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Menmapilkan title
        getSupportActionBar().setTitle("Teams");

        // Buat object fragment teams
        TeamsFragment teamsFragment = new TeamsFragment();
        loadFragment(teamsFragment);
    }

    private void loadFragment(Fragment fragment) {
        // Menampilkan fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
