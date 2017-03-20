package com.ling.engine.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/3/14.
 */

public abstract class BaseFragment extends Fragment {

    private Unbinder bingview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),null);
        bingview = ButterKnife.bind(this,view);
        initView();
        initData();
        return view;
    }

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bingview.unbind();
    }
}
