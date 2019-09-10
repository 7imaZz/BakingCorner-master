package com.example.bakingcorner.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.Model.Ingredients;
import com.example.bakingcorner.Model.Steps;
import com.example.bakingcorner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private TextView ingredientsTextView;
    private RecyclerView recyclerView;
    private NestedScrollView scrollView;

    private List<Steps> steps = new ArrayList<>();
    private CakesAdapter adapter;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        View rootView = inflater.inflate(R.layout.fragment_details, container, false);

        ingredientsTextView = rootView.findViewById(R.id.tv_ingredients);
        recyclerView = rootView.findViewById(R.id.rv_steps);
        scrollView = rootView.findViewById(R.id.scroll);


        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        Bundle bundle = this.getArguments();

        assert bundle != null;
        CakeModel currentCake = (CakeModel) bundle.getSerializable("cake_bundle");

        assert currentCake != null;
        List<Ingredients> ingredients = currentCake.getIngredients();


        steps = currentCake.getSteps();

        for (int i=0; i<ingredients.size(); i++){
            ingredientsTextView.append("- "+ingredients.get(i)
                    .getQuantity()+" "+ingredients.get(i).getMeasure()+"'s Of "+ingredients.get(i).getIngredient()+"\n\n");
        }

        adapter = new CakesAdapter(getContext(), steps, 1);

        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
