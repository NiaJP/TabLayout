package com.bswfx.wings.android.fragmentsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuListFragment extends Fragment {

    private Activity _parentActivity;

    public MenuListFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_list,container,false);
        ListView lvMenu = (ListView) view.findViewById(R.id.lvMenu);

        List<Map<String,String>>  menuList = new ArrayList<Map<String, String>>();

        menuList = createTeishokuList();

        String[] from = {"name","price"};
        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(_parentActivity,menuList,android.R.layout.simple_list_item_2,from,to);
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


