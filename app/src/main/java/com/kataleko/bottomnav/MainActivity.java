package com.kataleko.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottomNavView);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new HomeFragment())
                .commit();

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.e("Clicou: ", "Yahh");
                Fragment selectedFragment = null;

                Log.e("ITEM ID", String.valueOf(item.getItemId()));

                switch (item.getItemId()) {
                    case R.id.itemHome:
                        Log.e("AQUI: ", "entrou em home");
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.itemProfile:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.itemSearch:
                        selectedFragment = new SearchFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, selectedFragment)
                        .commit();

                return true;
            }
        });


    }
}