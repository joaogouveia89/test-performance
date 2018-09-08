package joaogouveia89.github.io.testedeperformance.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import joaogouveia89.github.io.testedeperformance.R;

public class CantDoTestFragment extends Fragment {

    public CantDoTestFragment() {
        // Required empty public constructor
    }
    public static CantDoTestFragment newInstance() {
        CantDoTestFragment fragment = new CantDoTestFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cant_do_test, container, false);
    }
}
