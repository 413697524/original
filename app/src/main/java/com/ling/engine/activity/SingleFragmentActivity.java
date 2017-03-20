package com.ling.engine.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.ling.original.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment =fm.findFragmentById(R.id.fragment_containner);
        if(fragment == null )
        {
            fragment = createFragment() ;

            fm.beginTransaction().add(R.id.fragment_containner,fragment).commit();
//            17000
//            27000
        }
    }

}
