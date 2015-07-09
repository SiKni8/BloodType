package com.sikni8.bloodtype.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sikni8.bloodtype.R;

public class ViewHolder {

    public TextView title;

    public ImageView icon;

    public void attach(View v) {
        icon = (ImageView) v.findViewById(R.id.drawer_menu_icon);
        title = (TextView) v.findViewById(R.id.drawer_menu_title);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setIcon(int resId) {
        icon.setImageResource(resId);
    }
}
