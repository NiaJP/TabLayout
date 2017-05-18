package com.bswfx.wings.android.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Norio on 2016/11/21.
 */

public class CustomAdapter extends ArrayAdapter<CustomData> {

    private LayoutInflater _layoutInflater;

    public CustomAdapter(Context context, int textViewResourceId, List<CustomData> objects) {
        super(context, textViewResourceId, objects);
        _layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 特定の行(position)のデータを得る
        CustomData item = (CustomData)  getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = _layoutInflater.inflate(R.layout.custom_data, null);
        }

        // CustomDataのデータをViewの各Widgetにセットする
        ImageView imageView;
        imageView = (ImageView)convertView.findViewById(R.id.image);
        imageView.setImageBitmap(item.get_imageData());

        TextView textView;
        textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(item.get_textData1());

        return convertView;
    }


}
