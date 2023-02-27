package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button change_btn;
    private boolean isDescDisplayed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment(DescFragment.newInstance());

        change_btn = findViewById(R.id.btn);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                if (isDescDisplayed){
                    fragment = DescFragment.newInstance();
                    change_btn.setText("LIHAT KELEBIHAN");
                    displayFragment(fragment);
                    isDescDisplayed = false;

                }else {
                    fragment = AdvantagesFragment.newInstance();
                    change_btn.setText("MANTAP");
                    displayFragment(fragment);
                    isDescDisplayed = true;
                }

            }
        });
    }

    private void displayFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment)
                .addToBackStack(null)
                .commit();
    }
}