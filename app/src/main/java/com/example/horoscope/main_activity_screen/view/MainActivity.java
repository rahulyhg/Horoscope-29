package com.example.horoscope.main_activity_screen.view;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.horoscope.details_screen.view.DetailsActivity;
import com.example.horoscope.main_activity_screen.model.SunSignHolder;
import com.example.horoscope.main_activity_screen.presenter.MainActivityPresenter;
import com.example.horoscope.main_activity_screen.view.adapter.ZodiacAdapter;
import com.example.horoscope.main_activity_screen.view.contracts.IMainActivityContract;
import com.example.zodiac.R;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements IMainActivityContract.View {

    private DrawerLayout mDrawerLayout;
    private MainActivityPresenter mPresenter;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecycler();
        setToolbar();
        setNavigationView();
        mPresenter.attachView(this);
        mPresenter.loadSunSign();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mPresenter.viewIsReady();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.navigation_view);
        mPresenter = new MainActivityPresenter();
        mToolbar = findViewById(R.id.toolbar);
    }

    private void initRecycler() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        RecyclerView mZodiacRecyclerView = findViewById(R.id.zodiac_recycler_view);
        mZodiacRecyclerView.setLayoutManager(layoutManager);
        ZodiacAdapter mAdapter = new ZodiacAdapter(SunSignHolder.getLanguageItems(),
                id -> DetailsActivity.start(MainActivity.this, id));
        mZodiacRecyclerView.setAdapter(mAdapter);
    }

    private void setNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.nav_aries:
                            DetailsActivity.start(this, 0);
                            return true;
                        case R.id.nav_taurus:
                            DetailsActivity.start(this, 1);
                            return true;
                        case R.id.nav_gemini:
                            DetailsActivity.start(this, 2);
                            return true;
                        case R.id.nav_cancer:
                            DetailsActivity.start(this, 3);
                            return true;
                        case R.id.nav_leo:
                            DetailsActivity.start(this, 4);
                            return true;
                        case R.id.nav_virgo:
                            DetailsActivity.start(this, 5);
                            return true;
                        case R.id.nav_libra:
                            DetailsActivity.start(this, 6);
                            return true;
                        case R.id.nav_scorpio:
                            DetailsActivity.start(this, 7);
                            return true;
                        case R.id.nav_sagittarius:
                            DetailsActivity.start(this, 8);
                            return true;
                        case R.id.nav_capricorn:
                            DetailsActivity.start(this, 9);
                            return true;
                        case R.id.nav_aquarius:
                            DetailsActivity.start(this, 10);
                            return true;
                        case R.id.nav_pisces:
                            DetailsActivity.start(this, 11);
                            return true;
                        default:
                            mDrawerLayout.closeDrawers();
                            return true;
                    }
                });
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
    }
}
