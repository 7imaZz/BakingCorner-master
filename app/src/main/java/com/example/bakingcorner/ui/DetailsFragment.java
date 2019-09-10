package com.example.bakingcorner.ui;


import android.os.Bundle;

import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private TextView ingredientsTextView;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        if (getActivity().getIntent().getSerializableExtra("cake")==null){
            return view;
        }

        CakeModel currentCake = (CakeModel) getActivity().getIntent().getSerializableExtra("cake");

        ingredientsTextView = view.findViewById(R.id.tv_ingredients);

        for (int i=0; i<currentCake.getIngredients().size(); i++){
            ingredientsTextView.append(currentCake.getIngredients().get(i).getQuantity()
                    +" "+currentCake.getIngredients().get(i).getMeasure()+"'s "
                    +currentCake.getIngredients().get(i).getIngredient()+"\n\n");
        }

        return view;

    }

}
