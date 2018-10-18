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
public class WelcomeFragment extends Fragment implements View.OnClickListener {

    public Button button;
    public Button button1;



    public onFragmentInteractionListener onFragmentInteractionListener;



    public WelcomeFragment() {
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

       View viewroot =  inflater.inflate(R.layout.fragment_welcome, container, false);

        button = viewroot.findViewById(R.id.si);
        button1 = viewroot.findViewById(R.id.no);


        button.setOnClickListener(this);
        button1.setOnClickListener(this);

        return viewroot;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.si:

                break;
            case R.id.no:
                onFragmentInteractionListener.onFragmentChange(MainActivity.FRAGMENT_BOOK);
                break;
        }

    }
}
