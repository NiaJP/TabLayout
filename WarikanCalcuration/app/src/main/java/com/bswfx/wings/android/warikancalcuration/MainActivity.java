package com.bswfx.wings.android.warikancalcuration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalcuration = (Button) findViewById(R.id.btCalcuration);

        //リスナー
        HelloListener listener = new HelloListener();
        btCalcuration.setOnClickListener(listener);

    }

    //リスナーの処理
    private class  HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View view){

            //viewの取得
            TextView tvNet = (TextView) findViewById(R.id.etNet);
            TextView tvPersons = (TextView) findViewById(R.id.etPersons);
            TextView tvResult = (TextView) findViewById(R.id.tvResult);

            //エラーチェック
            if (tvNet == null || tvNet.length() == 0) {
                Toast.makeText(MainActivity.this,"金額を入力してください",Toast.LENGTH_LONG).show();
                return;
            }

            if (tvPersons == null || tvPersons.length() == 0) {
                Toast.makeText(MainActivity.this,"人数を入力してください",Toast.LENGTH_LONG).show();
                return;
            }

            //viewから内容の取得
            Long lngNet = Long.parseLong(tvNet.getText().toString());
            Long lngPersons = Long.parseLong(tvPersons.getText().toString());

            if (lngPersons == 0) {
                Toast.makeText(MainActivity.this,"人数は1人以上を入力してください",Toast.LENGTH_LONG).show();
                return;
            }


            //取得した内容を使った処理
            Long stResult = lngNet / lngPersons;

            //set
            tvResult.setText(String.valueOf(stResult));

        }

    }



    //計算


    //クリアボタンの追加


}
