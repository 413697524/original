package com.ling.original.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ling.engine.activity.BaseActivity;
import com.ling.engine.application.MyApp;
import com.ling.engine.db.UserDao;
import com.ling.original.R;
import com.ling.original.fragment.ContentFragment;
import com.ling.original.fragment.DemoFragmen;
import com.ling.original.fragment.UserInfoFragment;
import com.ling.original.model.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fragment_containner)
    FrameLayout fragmentContainner;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.UserinfoFragment)
    Button UserinfoFragment;
    @BindView(R.id.showDemoFragment)
    Button showDemoFragment;
    // These variable are destroyed along with Activity
    private int someVarA;
    private String someVarB;
    private String TAG = "MainActivity";
    private ArrayList<Fragment> fragmentArrayList;
    private FragmentManager fm;
    private ContentFragment mContentFragment;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("someVarA", someVarA);
        outState.putString("someVarB", someVarB);
        Log.e(TAG, "----------------onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        someVarA = savedInstanceState.getInt("someVarA");
        someVarB = savedInstanceState.getString("someVarB");
        Log.e(TAG, "----------------onRestoreInstanceState");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new UserInfoFragment());
        fragmentArrayList.add(new DemoFragmen());
        fm = getSupportFragmentManager();
        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.fragment_containner);
        if(mContentFragment == null )
        {
            mContentFragment = new ContentFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_containner,mContentFragment)
                    .commit();
        }


    }

    @Override
    protected void initData() {

        long userId = 123456;
//        User user = new User(userId,"貂毛兽","");
        User user1 = new User();
        user1.setName("掉毛");
        user1.setSex("男人");
//        MyApp.getAppComponent().dbManager().getDaoSession().getUserDao().insert(user1);

        UserDao userDao = MyApp.getAppComponent().dbManager().getDaoSession().getUserDao();
        //增加
        userDao.insert(user1);
        //查询
        User testUser = userDao.load(userId);


        Log.e("MainActivity", "-----------------------" + testUser.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void showdialog(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @OnClick({R.id.UserinfoFragment, R.id.showDemoFragment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.UserinfoFragment:
//                fragmentTransaction.replace(R.id.fragment_containner,fragmentArrayList.get(0));
//                fragmentTransaction.commit();
                break;
            case R.id.showDemoFragment:
//                fragmentTransaction.replace(R.id.fragment_containner,fragmentArrayList.get(1));
//                fragmentTransaction.commit();
                break;
        }
    }
}
