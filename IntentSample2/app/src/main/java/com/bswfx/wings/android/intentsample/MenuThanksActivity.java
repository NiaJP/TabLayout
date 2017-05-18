package com.bswfx.wings.android.intentsample;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        Intent intent = getIntent();

        //渡された値を取得する
        String menuName = intent.getStringExtra("menuName");
        String menuPrice = intent.getStringExtra("menuPrice");
        String menuTaste = intent.getStringExtra("menuTaste");

        //textView1と2にデータを設定する

        TextView tvMenuName = (TextView) findViewById(R.id.tvName);
        TextView tvMenuPrice = (TextView) findViewById(R.id.tvPrice);
        TextView tvMenuTaste = (TextView) findViewById(R.id.tvTaste);

        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);
        tvMenuTaste.setText(menuTaste);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public  void onBackButtonClick(View view){
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int itemId =  item.getItemId();

        switch (itemId) {
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
