package com.bswfx.wings.android.customlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リソースに準備した画像ファイルからBitmapを作成しておく
        Bitmap image;
        image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        // データの作成
        List<CustomData> objects = new ArrayList<CustomData>();
        CustomData item1 = new CustomData();
        item1.set_imageData(image);
        item1.set_textData1("１つ目〜１行目");
/*
        item1.set_textData2("１つ目〜２行目");
        item1.set_textData3("１つ目〜３行目");
*/

        CustomData item2 = new CustomData();
        item2.set_imageData(image);
        item2.set_textData1("２つ目〜１行目");
/*
        item2.set_textData2("２つ目〜２行目");
        item2.set_textData3("２つ目〜３行目");
*/

        CustomData item3 = new CustomData();
        item3.set_imageData(image);
        item3.set_textData1("３つ目〜１行目");
/*
        item3.set_textData2("３つ目〜２行目");
        item3.set_textData3("３つ目〜３行目");
*/

        objects.add(item1);
        objects.add(item2);
        objects.add(item3);

        CustomAdapter customAdapater = new CustomAdapter(this, 0, objects);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(customAdapater);

    }
}
