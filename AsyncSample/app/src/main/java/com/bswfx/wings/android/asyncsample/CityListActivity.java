package com.bswfx.wings.android.asyncsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.bswfx.wings.android.asyncsample.R;
import com.bswfx.wings.android.asyncsample.WeatherInfoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CodeZine
 * Android Studio 2で始めるアプリ開発入門
 * クラウド連携サンプル
 *
 * 都市リスト画面のアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
public class CityListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        List<Map<String, String>> list = new ArrayList<Map<String,String>>();

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "横浜");
        map.put("id", "140010");
        list.add(map);
/*
        map = new HashMap<String, String>();
        map.put("name", "神戸");
        map.put("id", "280010");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "豊岡");
        map.put("id", "280020");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "京都");
        map.put("id", "260010");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "舞鶴");
        map.put("id", "260020");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "奈良");
        map.put("id", "290010");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "風屋");
        map.put("id", "290020");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "和歌山");
        map.put("id", "300010");
        list.add(map);
        map = new HashMap<String, String>();
        map.put("name", "潮岬");
        map.put("id", "300020");
        list.add(map);
*/

        ListView lvCityList = (ListView) findViewById(R.id.lvCityList);

        String[] from = {"name"};
        int[] to = {android.R.id.text1};
        SimpleAdapter adapter = new SimpleAdapter(CityListActivity.this, list, android.R.layout.simple_expandable_list_item_1, from, to);

        lvCityList.setAdapter(adapter);
        lvCityList.setOnItemClickListener(new ListItemClickListener());

    }


    /**
     * リストが選択されたときの処理が記述されたメンバクラス。
     *
     * @author Shinzo SAITO
     *
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);
            String cityName = item.get("name");
            String cityId = item.get("id");

            Intent intent = new Intent(CityListActivity.this, WeatherInfoActivity.class);
            intent.putExtra("cityName", cityName);
            intent.putExtra("cityId", cityId);
            startActivity(intent);
        }
    }
}
