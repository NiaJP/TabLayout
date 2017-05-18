package com.nia.wings.android.simplepreference;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Norio on 2017/05/10.
 */

public class SimplePreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
