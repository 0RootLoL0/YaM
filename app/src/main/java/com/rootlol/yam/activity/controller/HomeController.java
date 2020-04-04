package com.rootlol.yam.activity.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.rootlol.yam.R;
import com.rootlol.yam.activity.controller.homecontroller.PlayerController;
import com.rootlol.yam.activity.controller.homecontroller.playlistсontroller.PlaylistController;
import com.rootlol.yam.activity.controller.homecontroller.RadioController;
import com.rootlol.yam.activity.controller.homecontroller.SettingsController;
import com.rootlol.yam.activity.controller.homecontroller.playlistсontroller.TracksController;

public class HomeController extends Controller {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private final RouterPagerAdapter pagerAdapter;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_playlist, R.string.tab_radio, R.string.tab_player, R.string.tab_settings};

    public HomeController() {
        pagerAdapter = new RouterPagerAdapter(this) {
            @Override
            public void configureRouter(@NonNull Router router, int position) {
                if (!router.hasRootController()) {
                    Controller page;
                    switch (position){
                        case 0:
                            page = new PlaylistController();
                            break;
                        case 1:
                            page = new RadioController();
                            break;
                        case 2:
                            page = new PlayerController();
                            break;
                        default:
                            page = new SettingsController();
                    }
                    router.setRoot(RouterTransaction.with(page));
                }
            }

            @Override
            public int getCount() {
                return TAB_TITLES.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getApplicationContext().getResources().getString(TAB_TITLES[position]);
            }
        };
    }

    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_main, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRouter().pushController(RouterTransaction.with(new SearchController()));
            }
        });

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}