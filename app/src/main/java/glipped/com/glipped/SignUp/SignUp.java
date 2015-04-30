package glipped.com.glipped.SignUp;

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

import glipped.com.glipped.LeftDrawer.LeftDrawer;
import glipped.com.glipped.R;


public class SignUp extends AppCompatActivity {

    /**
     * Variables related to the left drawer
     */
    private ActionBarDrawerToggle leftDrawerToggle = null;
    private DrawerLayout leftDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Set the color of the statusbar in lollipop
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = SignUp.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(SignUp.this.getResources()
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

    /**
     * Method to setup the left drawer
     */
    public void setupLeftDrawer() {

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

        LeftDrawer leftDrawer = new LeftDrawer(leftDrawerToggle, leftDrawerLayout, SignUp.this);
        leftDrawer.populateLeftDrawer();
    }
}
