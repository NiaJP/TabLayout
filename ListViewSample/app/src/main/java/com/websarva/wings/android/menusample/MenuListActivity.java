package com.websarva.wings.android.menusample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {

    private ListView _lvMenu;
    private List<Map<String, String>> _menuList;
    private static final String[] FROM = {"name", "price"};
    private static final int[] TO = {android.R.id.text1,android.R.id.text2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        _lvMenu = (ListView) findViewById(R.id.lvMenu);  //（5）

        _menuList = createTeishokuList();  //（6）

        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, _menuList, android.R.layout.simple_list_item_2, FROM, TO);
        _lvMenu.setAdapter(adapter);

        _lvMenu.setOnItemClickListener(new ListItemClickListener());

        registerForContextMenu(_lvMenu);
    }

    private List<Map<String, String>> createTeishokuList() {
        List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();

        Map<String, String>  menu = new HashMap<String,String>();

        menu.put("name","から揚げ定食");
        menu.put("price","800円");
        menu.put("desc","若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<String, String>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;

    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);  // （8）
            String menuName = item.get("name");  // （9）
            String menuPrice = item.get("price");  // （9）

            Intent intent = new Intent(MenuListActivity.this, com.websarva.wings.android.menusample.MenuThanksActivity.class);  // （10）
            intent.putExtra("menuName", menuName);  // （11）
            intent.putExtra("menuPrice", menuPrice);  // （11）
            startActivity(intent);  // （12）
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();  //（1）
        inflater.inflate(R.menu.menu_options_menu_list, menu);  //（2）
        return super.onCreateOptionsMenu(menu);  //（3）
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();  //（1）
        switch(itemId) {  //（2）
            case R.id.menuListOptionOsusume:  //（3）
                break;
            case R.id.menuListOptionGeneralSet:  //（3）
                break;
            case R.id.menuListOptionTuutiSet:  //（3）
                break;
            case R.id.menuListOptionWriteReview:  //（3）
                break;
        }
/*
        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this, _menuList, android.R.layout.simple_list_item_2, FROM, TO);  //（5）
        _lvMenu.setAdapter(adapter);  //（5）
*/

        return super.onOptionsItemSelected(item);  //（6）
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);  //（1）
        MenuInflater inflater = getMenuInflater();  //（2）
        inflater.inflate(R.menu.menu_context_menu_list, menu);  //（3）
        menu.setHeaderTitle(R.string.menu_list_context_header);  //（4）
        //アイコンの設定
        menu.setHeaderIcon(android.R.drawable.ic_menu_save);  //（5）
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();  //（1）
        int listPosition = info.position;  //（2）
        Map<String, String> menu = _menuList.get(listPosition);  //（3）

        int itemId = item.getItemId();
        switch(itemId) {  //（4）
            case R.id.menuListContextDesc:  //（5）
                String desc = menu.get("desc");
                Toast.makeText(MenuListActivity.this, desc, Toast.LENGTH_LONG).show();
                break;
            case R.id.menuListContextOrder:  //（6）
                // ここに注文処理を記述。
                break;
        }
        return super.onContextItemSelected(item);
    }

}
