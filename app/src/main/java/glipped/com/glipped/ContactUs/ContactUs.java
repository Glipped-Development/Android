package glipped.com.glipped.ContactUs;

import android.content.Intent;
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


public class ContactUs extends AppCompatActivity {

    /**
     * Variables related to the left drawer
     */
    private ActionBarDrawerToggle leftDrawerToggle = null;
    private DrawerLayout leftDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //Set the color of the statusbar in lollipop
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = ContactUs.this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContactUs.this.getResources()
                    .getColor(R.color.Custom_StatusBar_Color));
        }

        //Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setup the left drawer
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.left_drawer);
        setupLeftDrawer();

        //Setup the button listener
        findViewById(R.id.button_send_a_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSendMessage = new Intent(getBaseContext(), ContactUsMessage.class);
                startActivity(goToSendMessage);
            }
        });
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

        LeftDrawer leftDrawer = new LeftDrawer(leftDrawerToggle, leftDrawerLayout, ContactUs.this);
        leftDrawer.populateLeftDrawer();
    }
}
