package com.bswfx.wings.android.tablayout;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private final static String BACKGROUND_COLOR = "background_color";
    private Activity _parentActivity;  // （1）

    private String mTest;

    public static NewsFragment newInstance(@ColorRes int IdRes) {
        NewsFragment frag = new NewsFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, IdRes);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        _parentActivity = getActivity();  // （2）

        if (getArguments() != null) {
            mTest = getArguments().getString("text","testだよ");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news,container,false);

        // バッググランドカラーを決めるための処理
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_example_linearlayout);
        linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));

        // listview
        // ListView lvMenu = (ListView) view.findViewById(R.id.lvMenu);  // （2）
        ListView lvMenu = (ListView) view.findViewById(R.id.lvMenu);  // （2）

        List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();
        menuList = createTeishokuList();

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(_parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);  // （4）
        lvMenu.setAdapter(adapter);

        return view;
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



}