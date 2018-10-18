package mx.mobilestudio.eaat.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import mx.mobilestudio.eaat.MainActivity;
import mx.mobilestudio.eaat.R;
import mx.mobilestudio.eaat.interfaces.onFragmentInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaitTimeFragment extends Fragment implements View.OnClickListener {

    public Button button;
    public Button button1;
    public onFragmentInteractionListener onFragmentInteractionListener;



    public WaitTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onFragmentInteractionListener = (onFragmentInteractionListener) context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_wait_time, container, false);

        button = view.findViewById(R.id.si);
        button1 = view.findViewById(R.id.no);

        button1.setOnClickListener(this);
        button.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.si:
                onFragmentInteractionListener.onFragmentChange(MainActivity.FRAGMENT_MENU);
                break;
            case R.id.no:
                break;
        }

    }
}
