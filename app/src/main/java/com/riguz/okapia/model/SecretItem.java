package com.riguz.okapia.model;

public class SecretItem {
    private String title;
    private String subTitle;
    private int iconId;

    public SecretItem() {
    }

    public SecretItem(String title, String subTitle, int iconId) {
        this.title = title;
        this.subTitle = subTitle;
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
