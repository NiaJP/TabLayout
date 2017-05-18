package com.websarva.wings.android.menusample;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.websarva.wings.android.menusample.R;

public class MenuThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_thanks);

        Intent intent = getIntent();  // （1）
        String menuName = intent.getStringExtra("menuName");  // （2）
        String menuPrice = intent.getStringExtra("menuPrice");  // （2）

        TextView tvMenuName = (TextView) findViewById(R.id.tvMenuName);
        TextView tvMenuPrice = (TextView) findViewById(R.id.tvMenuPrice);

        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

 /*   public void onBackButtonClick(View view) {  // （3）
        finish();  // （4）
    }
*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
