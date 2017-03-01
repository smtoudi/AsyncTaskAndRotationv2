package oo.max.asynctaskandrotationv2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_FRAGMENT = "MainFragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(MAIN_FRAGMENT);

        if (fragment == null) {
            Log.e("MainActivity", "Adding new Fragment");
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_main, new MainFragment(), MAIN_FRAGMENT)
                    .commit();
        } else {
            Log.e("MainActivity", "Already added");
        }

    }

}
