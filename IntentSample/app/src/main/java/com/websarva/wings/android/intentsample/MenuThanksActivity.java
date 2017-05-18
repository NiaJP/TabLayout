package com.websarva.wings.android.intentsample;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

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
    }

    public void onBackButtonClick(View view) {  // （3）
        finish();  // （4）
    }
}
