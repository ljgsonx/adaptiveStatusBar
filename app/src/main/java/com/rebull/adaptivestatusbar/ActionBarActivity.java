package com.rebull.adaptivestatusbar;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ActionBarActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNagigationView;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actionbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);

        }
        initViews();
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mNagigationView = (NavigationView) findViewById(R.id.id_navigationview);
        mNagigationView.inflateHeaderView(R.layout.header_nav);
        mNagigationView.inflateMenu(R.menu.menu_nav);
        mBtn = (Button) findViewById(R.id.goBack);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
