package com.sikni8.bloodtype.ui;

public class DrawerItem {
    String title;
    int imageRes;
    DrawerItemType type;
    DrawerItemAction action;


    public DrawerItem(String title, int imageRes, DrawerItemType type, DrawerItemAction action) {
        this.title = title;
        this.imageRes = imageRes;
        this.type = type;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public  DrawerItemType getType() {return type;}

    public  DrawerItemAction getAction() {return action;}
}
