package ru.eyelog.moxymvppattern;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

public class MainActivity extends MvpAppCompatActivity {

    FrameLayout container00, container01;
    FragmentManager myFragmentManager;
    FragmentTransaction fragmentTransaction;
    FragmentUp fragmentUp;
    FragmentDown fragmentDown;
    final static String TAG_UP = "FRAGMENT_UP";
    final static String TAG_DOWN = "FRAGMENT_DOWN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container00 = findViewById(R.id.container00);
        container01 = findViewById(R.id.container01);

        myFragmentManager = getSupportFragmentManager();
        fragmentUp = new FragmentUp();
        fragmentDown = new FragmentDown();

        // при первом запуске программы
        fragmentTransaction = myFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container00, fragmentUp, TAG_UP);
        fragmentTransaction.commit();

        fragmentTransaction = myFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container01, fragmentDown, TAG_DOWN);
        fragmentTransaction.commit();
    }
}
