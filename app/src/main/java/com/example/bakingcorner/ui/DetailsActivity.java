package com.example.bakingcorner.ui;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.example.bakingcorner.R;
import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity implements Serializable{


    private TextView detailsButton;
    private TextView stepsButton;
    public static FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        manager = getSupportFragmentManager();

        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
        if (diagonalInches>=6.5){
            // 6.5inch device or bigger
        }else{
            // smaller device
            detailsButton = findViewById(R.id.tv_det);
            stepsButton = findViewById(R.id.tv_steps);

            detailsButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {

                    DetailsFragment detailsFragment = new DetailsFragment();

                    detailsButton.setBackgroundColor(getColor(R.color.accent));
                    stepsButton.setBackgroundColor(getColor(R.color.colorPrimary));

                    manager.beginTransaction()
                            .replace(R.id.fragment, detailsFragment)
                            .commit();
                }
            });

            stepsButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {

                    StepsFragment stepsFragment = new StepsFragment();

                    stepsButton.setBackgroundColor(getColor(R.color.accent));
                    detailsButton.setBackgroundColor(getColor(R.color.colorPrimary));

                    manager.beginTransaction()
                            .replace(R.id.fragment, stepsFragment)
                            .commit();
                }
            });
        }





    }


}
