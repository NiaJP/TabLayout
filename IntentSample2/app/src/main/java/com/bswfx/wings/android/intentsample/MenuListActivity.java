package com.bswfx.wings.android.intentsample;

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

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListActivity extends AppCompatActivity {

    private ListView _lvMenu;
    private List<Map<String,String>> _menuList;
    private static final String[] from = {"name","price"};
    private static final int[] to = {android.R.id.text1,android.R.id.text2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        //adapterを使う

        ListView lvMenu = (ListView) findViewById(R.id.lvMenu);

        List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();

        //
        _lvMenu = (ListView) findViewById(R.id.lvMenu);

        _menuList = createTeishokuList();

        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this,_menuList,android.R.layout.simple_list_item_2,from,to);

        _lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());

        registerForContextMenu(_lvMenu);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_options_menu_list,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);  //（1）
        MenuInflater inflater = getMenuInflater();  //（2）
        inflater.inflate(R.menu.menu_context_menu_list, menu);  //（3）
        menu.setHeaderTitle(R.string.menu_list_context_header);  //（4）
        menu.setHeaderIcon(android.R.drawable.ic_menu_info_details);  //（5）
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int listPosition = info.position;
        Map<String,String> menu = _menuList.get(listPosition);

        int itemId = item.getItemId();
        switch(itemId) {  //（4）
            case R.id.menuListContextDesc:  //（5）
                String desc = menu.get("taste");
                Toast.makeText(MenuListActivity.this, desc, Toast.LENGTH_LONG).show();
                break;
            case R.id.menuListContextOrder:  //（6）

                // ここに注文処理を記述。

                order(menu);

                /*


                //clickしたitemのdataをgetする
                //型を合わせる
                Map<String,String> item1 = (Map<String,String>) parent.getItemAtPosition(position);

                String menuName = item1.get("name");
                String menuPrice = item1.get("price");
                String menuTaste = item1.get("taste");

                //intent
                Intent intent = new Intent(MenuListActivity.this,MenuThanksActivity.class);

                //intent先に値を渡す
                intent.putExtra("menuName",menuName);
                intent.putExtra("menuPrice",menuPrice);
                intent.putExtra("menuTaste",menuTaste);

                startActivity(intent);
*/
                break;
        }
        return super.onContextItemSelected(item);

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch(itemId){
            case R.id.menuListOptionsTeishoku:
                _menuList = createTeishokuList();
                break;
            case R.id.menuListOptionsCurry:
                _menuList = createCurryList();
                break;
        }

        SimpleAdapter adapter = new SimpleAdapter(MenuListActivity.this,  _menuList,android.R.layout.simple_list_item_2 ,from,to)  ;

        _lvMenu.setAdapter(adapter);

        return super.onOptionsItemSelected(item);
    }



    private List<Map<String,String>> createTeishokuList() {

        List<Map<String,String>> menuList = new ArrayList<Map<String, String>>();

        Map<String,String> menu = new HashMap<String,String>();
        menu.put("name","から揚げ定食");
        menu.put("price","800円");
        menu.put("taste","おいしい");
        menuList.add(menu);

        menu = new HashMap<String,String>();
        menu.put("name","ハンバーグ定食");
        menu.put("price","900円");
        menu.put("taste","めっちゃおいしい");
        menuList.add(menu);

        return menuList;

    }

    private List<Map<String,String>> createCurryList() {

        List<Map<String,String>> menuList = new ArrayList<Map<String, String>>();

        Map<String,String> menu = new HashMap<String,String>();
        menu.put("name","カツカレー");
        menu.put("price","1300円");
        menu.put("taste","おいしい");
        menuList.add(menu);

        menu = new HashMap<String,String>();
        menu.put("name","コロッケカレー");
        menu.put("price","1000円");
        menu.put("taste","めっちゃおいしい");
        menuList.add(menu);

        return menuList;

    }

    private void order(Map<String, String> menu) {
        String menuName = menu.get("name");
        String menuPrice = menu.get("price");
        String menuTaste = menu.get("taste");

        Intent intent = new Intent(MenuListActivity.this, MenuThanksActivity.class);
        intent.putExtra("menuName", menuName);
        intent.putExtra("menuPrice", menuPrice);
        intent.putExtra("menuTaste",menuTaste);
        startActivity(intent);
    }


    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //clickしたitemのdataをgetする
            //型を合わせる
            Map<String,String> item = (Map<String,String>) parent.getItemAtPosition(position);

            String menuName = item.get("name");
            String menuPrice = item.get("price");
            String menuTaste = item.get("taste");

            //intent
            Intent intent = new Intent(MenuListActivity.this,MenuThanksActivity.class);

            //intent先に値を渡す
            intent.putExtra("menuName",menuName);
            intent.putExtra("menuPrice",menuPrice);
            intent.putExtra("menuTaste",menuTaste);

            startActivity(intent);


        }





    }



}
