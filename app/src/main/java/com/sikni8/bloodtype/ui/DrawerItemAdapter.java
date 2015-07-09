package com.sikni8.bloodtype.ui;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.sikni8.bloodtype.R;

import java.util.List;

public class DrawerItemAdapter extends ArrayAdapter<DrawerItem> {
    LayoutInflater mInflater;
    int mDrawerMenuItemResource = R.layout.drawer_item;
    int mDrawerHeaderResource = R.layout.drawer_header;

    public DrawerItemAdapter(Context context, List<DrawerItem> values) {
        super(context, android.R.layout.simple_list_item_1,values);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerItem drawerItem = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            switch (getItem(position).getType())
            {
                case MENU:
                    convertView = mInflater.inflate(mDrawerMenuItemResource, null);
                    break;
                case HEADER:
                    convertView = mInflater.inflate(mDrawerHeaderResource, null);
                    break;
            }
            holder = new ViewHolder();
            holder.attach(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.setTitle(drawerItem.getTitle());
        holder.setIcon(drawerItem.getImageRes());

        return convertView;
    }
}
