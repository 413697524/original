package com.ling.original.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ling.engine.fragment.BaseFragment;
import com.ling.original.R;

/**
 * Created by Administrator on 2017/3/17.
 */

public class DemoFragmen extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_demo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
