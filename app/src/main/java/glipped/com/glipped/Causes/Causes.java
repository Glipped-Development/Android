package glipped.com.glipped.Causes;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

import glipped.com.glipped.LeftDrawer.LeftDrawer;
import glipped.com.glipped.R;

public class Causes extends AppCompatActivity {

    /**
     * Variables related to the left drawer
     */
    private ActionBarDrawerToggle leftDrawerToggle = null;
    private DrawerLayout leftDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causes);

        //Set the color of the statusbar in lollipop
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = Causes.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Causes.this.getResources()
                    .getColor(R.color.Custom_StatusBar_Color));
        }

        //Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup the left drawer
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.left_drawer);
        setupLeftDrawer();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setupCauseList();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        leftDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        leftDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item) || leftDrawerToggle.onOptionsItemSelected(item);
    }

    private void setupLeftDrawer() {

        leftDrawerLayout.setStatusBarBackground(R.color.Glipped_Logo_Orange);

        //Show drawer toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Handel drawer open/close event
        leftDrawerToggle = new ActionBarDrawerToggle(this, leftDrawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        leftDrawerToggle.setDrawerIndicatorEnabled(true);
        leftDrawerLayout.setDrawerListener(leftDrawerToggle);

        LeftDrawer leftDrawer = new LeftDrawer(leftDrawerToggle, leftDrawerLayout, Causes.this);
        leftDrawer.populateLeftDrawer();
    }

    private void setupCauseList() {

        ArrayList<String> causeNameList = new ArrayList<>();
        ArrayList<Integer> causeImagePathList = new ArrayList<>();

        causeNameList.add("Indian Women Education");
        causeImagePathList.add(R.drawable.indian_women_education);

        causeNameList.add("San Fransisco Homeless Project");
        causeImagePathList.add(R.drawable.homeless_project);

        causeNameList.add("Delhi Dental Campaign");
        causeImagePathList.add(R.drawable.dental_camp);

        ListView causeList = (ListView) findViewById(R.id.causes_list_view);
        CausesListAdapter causesListAdapter = new CausesListAdapter(this, causeNameList,
                causeImagePathList);
        causeList.setAdapter(causesListAdapter);
    }
}
