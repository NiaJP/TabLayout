package com.bswfx.wings.android.tablayout;

/**
 * Created by Norio on 2017/05/15.
 */

import android.graphics.Bitmap;

// Item.java
// Item.java
public class Item {
    // 記事のタイトル
    private CharSequence mTitle;
    // 記事のサイト名
    private CharSequence mSite;
    // 記事の更新日
    private CharSequence mDate;
    // リンク
    private CharSequence mLink;
    // HTML
    private CharSequence mHtml;
    // サムネイル
    private Bitmap mThumbnail;

    public Item() {
        mTitle = "";
        mSite = "";
        mDate = "";
        mLink = "";
        mThumbnail = null;
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

    public CharSequence getLink() {
        return mLink;
    }

    public void setLink(CharSequence link) {
        mLink = link;
    }

    public CharSequence getHtml() {
        return mHtml;
    }

    public void setHtml(CharSequence html) {
        mHtml = html;
    }

    public Bitmap getmThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(Bitmap mThumbnail) {
        this.mThumbnail = mThumbnail;
    }


}
