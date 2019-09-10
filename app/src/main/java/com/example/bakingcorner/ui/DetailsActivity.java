package com.example.bakingcorner.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.R;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity implements Serializable{

    public static FragmentManager manager;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        bundle = new Bundle();
        bundle.putSerializable("cake_bundle", (getIntent().getSerializableExtra("cake")));


        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);

        manager = getSupportFragmentManager();

        manager.beginTransaction()
                .add(R.id.container, detailsFragment)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){

            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(bundle);

            manager.beginTransaction().replace(R.id.container, detailsFragment)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
}
