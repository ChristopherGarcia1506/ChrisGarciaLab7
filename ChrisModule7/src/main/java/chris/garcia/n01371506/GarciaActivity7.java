/*
* Chris Garcia
* n01371506
* */

package chris.garcia.n01371506;

import android.os.Bundle;
import android.provider.Settings;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GarciaActivity7 extends ActionBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedfragment = null;

            if(item.getItemId() == R.id.home){
                selectedfragment = new HomeFragment();
            } else if (item.getItemId() == R.id.chris) {
                selectedfragment = new ChrisFragment();
            }else if (item.getItemId() == R.id.person) {
                selectedfragment = new PersonFragment();
            }else if (item.getItemId() == R.id.settings) {
                selectedfragment = new SettingsFragment();
            }

            if(selectedfragment != null){
               getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedfragment).commit();

            }


            return true;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}