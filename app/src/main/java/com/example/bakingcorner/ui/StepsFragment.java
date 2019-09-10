package com.example.bakingcorner.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

import com.example.bakingcorner.Model.CakeModel;
import com.example.bakingcorner.Model.Steps;
import com.example.bakingcorner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepsFragment extends Fragment {

    private ListView listView;

    public StepsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_steps, container, false);

        if (getActivity().getIntent().getSerializableExtra("cake")==null){
            return view;
        }

        final CakeModel currentCake = (CakeModel) getActivity().getIntent().getSerializableExtra("cake");
        listView = view.findViewById(R.id.lv_steps);

        List<Steps> steps = currentCake.getSteps();
        List<String> stepsDesc = new ArrayList<>();


        for (int i=0; i<steps.size(); i++){
            stepsDesc.add(steps.get(i).getShortDescription());
        }

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, stepsDesc);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                DisplayMetrics metrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

                Bundle bundle = new Bundle();
                bundle.putSerializable("step", currentCake.getSteps().get(i));

                VideoFragment fragment = new VideoFragment();
                fragment.setArguments(bundle);

                float yInches= metrics.heightPixels/metrics.ydpi;
                float xInches= metrics.widthPixels/metrics.xdpi;
                double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
                if (diagonalInches>=6.5){
                    // 6.5inch device or bigger
                    VideoFragment.currentStep = currentCake.getSteps().get(i);
                }else{
                    // smaller device
                    DetailsActivity.manager.beginTransaction()
                            .replace(R.id.fragment, fragment)
                            .commit();
                }



            }
        });


        return view;
    }

}
