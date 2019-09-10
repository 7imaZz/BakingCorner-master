package com.example.bakingcorner.ui;


import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.bakingcorner.Model.Steps;
import com.example.bakingcorner.R;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepsFragment extends Fragment {


    private PlayerView playerView;
    private ReadMoreTextView descriptionTextView;

    private ExoPlayer exoPlayer;

    public StepsFragment() {
        // Required empty public constructor
    }


    @SuppressLint({"SetTextI18n", "SetJavaScriptEnabled"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_steps, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = this.getArguments();

        assert bundle != null;
        Steps currentStep = (Steps) bundle.getSerializable("step");

        playerView = rootView.findViewById(R.id.video);
        descriptionTextView = rootView.findViewById(R.id.tv_desc);

        assert currentStep != null;
        descriptionTextView.setText(currentStep.getShortDescription()+"\n\n"+currentStep.getDescription());

        if (currentStep.getVideoUrl().equals("")){
            playerView.setVisibility(View.GONE);
        }

        LoadControl loadControl = new DefaultLoadControl(new DefaultAllocator(true, 16)
                , 3000,
                5000,
                1500,
                5000,
                -1,
                true);

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

        TrackSelection.Factory factory = new AdaptiveTrackSelection.Factory(bandwidthMeter);

        TrackSelector trackSelector = new DefaultTrackSelector(factory);

        RenderersFactory renderersFactory = new DefaultRenderersFactory(getContext());

        exoPlayer = ExoPlayerFactory.newSimpleInstance(renderersFactory, trackSelector, loadControl);
        play(currentStep.getVideoUrl());


        return rootView;
    }

    public void play(String url){

        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

        DataSource.Factory factory = new DefaultDataSourceFactory(getContext()
                ,Util.getUserAgent(getContext(), getContext().getString(R.string.app_name))
                , bandwidthMeter);

        MediaSource mediaSource = new ExtractorMediaSource.Factory(factory)
                .createMediaSource(Uri.parse(url));

        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(true);
        playerView.setPlayer(exoPlayer);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        exoPlayer.stop();
        exoPlayer.release();
    }
}
