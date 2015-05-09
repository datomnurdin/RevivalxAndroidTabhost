package com.revivalx.revivalxandroidtabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

/**
 * Created by MNurdin on 5/8/15.
 */

public class MainActivity extends ActionBarActivity {

    private static final String TAB_1_TAG = "one";
    private static final String TAB_2_TAG = "two";
    private static final String TAB_3_TAG = "three";
    private static final String TAB_4_TAG = "four";
    private static final String TAB_5_TAG = "five";
    private FragmentTabHost mTabHost;
    private Menu mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tabs);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        Bundle b = new Bundle();
        b.putString("key", "One");
        mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("",getResources().getDrawable(R.drawable.tab_one)),FirstContainerFragment.class, b);

        b = new Bundle();
        b.putString("key", "Two");
        mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator("",getResources().getDrawable(R.drawable.tab_two)), SecondContainerFragment.class, b);

        b = new Bundle();
        b.putString("key", "Three");
        mTabHost.addTab(mTabHost.newTabSpec(TAB_3_TAG).setIndicator("",getResources().getDrawable(R.drawable.tab_three)), ThirdContainerFragment.class, b);

        b = new Bundle();
        b.putString("key", "Four");
        mTabHost.addTab(mTabHost.newTabSpec(TAB_4_TAG).setIndicator("",getResources().getDrawable(R.drawable.tab_four)), FourthContainerFragment.class, b);

        b = new Bundle();
        b.putString("key", "five");
        mTabHost.addTab(mTabHost.newTabSpec(TAB_5_TAG).setIndicator("",getResources().getDrawable(R.drawable.tab_five)), FifthContainerFragment.class, b);

    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();
        if (currentTabTag.equals(TAB_1_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_1_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_2_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_2_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_3_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_3_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_4_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_4_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_5_TAG)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAB_5_TAG)).popFragment();
        }
        if (!isPopFragment) {
            finish();
        }
    }

}
