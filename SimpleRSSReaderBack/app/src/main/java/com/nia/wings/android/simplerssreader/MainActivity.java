package com.nia.wings.android.simplerssreader;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    public static final String RSS_FEED_URL = "http://itpro.nikkeibp.co.jp/rss/ITpro.rdf";
    private ArrayList<Item> mItems;
    private RssListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Itemオブジェクトを保持するためのリストを生成し、アダプタに追加する
//        mItems = new ArrayList();
//        mAdapter = new RssListAdapter(this, mItems);
//
//        // アダプタをリストビューにセットする
//        setListAdapter(mAdapter);
//
//        // サンプル用に空のItemオブジェクトをセットする
//        for (int i = 0; i < 10; i++) {
//            mAdapter.add(new Item());
//        }

        // Itemオブジェクトを保持するためのリストを生成し、アダプタに追加する
        mItems = new ArrayList<Item>();
        mAdapter = new RssListAdapter(this, mItems);

        // タスクを起動する
        RssParserTask task = new RssParserTask(this, mAdapter);
        task.execute(RSS_FEED_URL);




    }

}
