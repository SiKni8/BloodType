package com.sikni8.bloodtype;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class BaseNavDrawerActivity extends BaseActionBarActivity {
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
    }

    @Override
    public void onBackPressed() {
        if (isDrawerOpen()) {
            closeNavDrawer();
            return;
        }
        super.onBackPressed();
    }

    public boolean isDrawerOpen() {
        return getDrawerLayout().isDrawerOpen(GravityCompat.START);
    }

    public void closeNavDrawer() {
        getDrawerLayout().closeDrawer(GravityCompat.START);
    }

    public abstract DrawerLayout getDrawerLayout();
}
