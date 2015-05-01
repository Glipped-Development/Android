package glipped.com.glipped.LeftDrawer;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import glipped.com.glipped.About.About;
import glipped.com.glipped.Causes.Causes;
import glipped.com.glipped.ContactUs.ContactUs;
import glipped.com.glipped.Gallery.Gallery;
import glipped.com.glipped.Home.Home;
import glipped.com.glipped.R;
import glipped.com.glipped.SignUp.SignUp;

/**
 * Created by root on 24/4/15.
 */
public class LeftDrawer {

    /**
     * Variables related to the left drawer
     */
    private ActionBarDrawerToggle leftDrawerToggle = null;
    private DrawerLayout leftDrawerLayout;

    private AppCompatActivity AppCompatActivity;

    public LeftDrawer(ActionBarDrawerToggle leftDrawerToggle,
                      DrawerLayout leftDrawerLayout,
                      AppCompatActivity AppCompatActivity) {

        this.leftDrawerToggle = leftDrawerToggle;
        this.leftDrawerLayout = leftDrawerLayout;
        this.AppCompatActivity = AppCompatActivity;
    }

    /**
     * Method to populate the left drawer with values and icons
     */
    public void populateLeftDrawer() {

        new PopulateDrawer().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /**
     * AsyncTask to populate the drawer
     */
    private class PopulateDrawer extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {


            //Add values into the ArrayLists
            ArrayList<String> elementTextList = new ArrayList<>();
            ArrayList<Integer> elementIconList = new ArrayList<>();

            //First
            elementTextList.add("Home");
            elementIconList.add(R.drawable.glipped_logo_large);
            //First
            elementTextList.add("Causes");
            elementIconList.add(R.drawable.glipped_logo_large);
            //Second
            elementTextList.add("Gallery");
            elementIconList.add(R.drawable.glipped_logo_large);
            //Third
            elementTextList.add("Sign Up");
            elementIconList.add(R.drawable.glipped_logo_large);
            //Fourth
            elementTextList.add("About");
            elementIconList.add(R.drawable.glipped_logo_large);
            //Fifth
            elementTextList.add("Contact Us");
            elementIconList.add(R.drawable.glipped_logo_large);

            LeftDrawerListBaseAdapter leftDrawerListBaseAdapter =
                    new LeftDrawerListBaseAdapter(elementTextList, elementIconList, AppCompatActivity);

            ListView ls = (ListView) AppCompatActivity.findViewById(R.id.left_drawer_listview);
            ls.setDivider(null);
            ls.setAdapter(leftDrawerListBaseAdapter);

            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    leftDrawerLayout.closeDrawer(GravityCompat.START);

                    switch (position) {

                        case 0:
                            Intent goToHome = new Intent(AppCompatActivity, Home.class);
                            AppCompatActivity.startActivity(goToHome);
                            break;

                        case 1:
                            Intent goToCauses = new Intent(AppCompatActivity, Causes.class);
                            AppCompatActivity.startActivity(goToCauses);
                            break;

                        case 2:
                            Intent goToGallery = new Intent(AppCompatActivity, Gallery.class);
                            AppCompatActivity.startActivity(goToGallery);
                            break;

                        case 3:
                            Intent goToSignUp = new Intent(AppCompatActivity, SignUp.class);
                            AppCompatActivity.startActivity(goToSignUp);
                            break;

                        case 4:
                            Intent goToAbout = new Intent(AppCompatActivity, About.class);
                            AppCompatActivity.startActivity(goToAbout);
                            break;

                        case 5:
                            Intent goToContactUs = new Intent(AppCompatActivity, ContactUs.class);
                            AppCompatActivity.startActivity(goToContactUs);
                            break;
                    }
                }
            });

            return null;
        }
    }
}
