package joaogouveia89.github.io.testedeperformance.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joaogouveia89.github.io.testedeperformance.R;
import joaogouveia89.github.io.testedeperformance.ui.activities.MeasureActivity;

public class StartTestFragment extends Fragment {
    private Button startTest;

    public StartTestFragment() {
        // Required empty public constructor
    }

    public static StartTestFragment newInstance() {
        StartTestFragment fragment = new StartTestFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_start_test, container, false);
        startTest = (Button) view.findViewById(R.id.bt_start_test);

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent measureActivity = new Intent(StartTestFragment.this.getActivity(), MeasureActivity.class);
                startActivity(measureActivity);
            }
        });
        return view;
    }
}
