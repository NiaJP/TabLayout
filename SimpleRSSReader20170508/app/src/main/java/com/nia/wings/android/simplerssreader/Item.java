package com.nia.wings.android.simplerssreader;

// Item.java
// Item.java
public class Item {
    // 記事のタイトル
    private CharSequence mTitle;
    // 記事のサイト名
    private CharSequence mSite;
    // 記事の更新日
    private CharSequence mDate;

    public Item() {
        mTitle = "";
        mSite = "";
        mDate = "";
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public void setTitle(CharSequence title) {
        mTitle = title;
    }

    public CharSequence getSite() {
        return mSite;
    }

    public void setSite(CharSequence site) {
        mSite = site;
    }

    public CharSequence getDate() { return mDate; }

    public void setDate(CharSequence date) {
        mDate = date;
    }
}
