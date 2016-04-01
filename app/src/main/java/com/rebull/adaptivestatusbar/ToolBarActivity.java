package com.rebull.adaptivestatusbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ToolBarActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNagigationView;
    private Toolbar mToolbar;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                //将侧边栏顶部延伸至status bar
                mDrawerLayout.setFitsSystemWindows(true);
                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
                mDrawerLayout.setClipToPadding(false);
            }
        }

    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mNagigationView = (NavigationView) findViewById(R.id.id_navigationview);
        mNagigationView.inflateHeaderView(R.layout.header_nav);
        mNagigationView.inflateMenu(R.menu.menu_nav);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtn = (Button) findViewById(R.id.goToActionBar);
        mToolbar.setTitle("");
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ToolBarActivity.this, ActionBarActivity.class));
            }
        });
    }
}
