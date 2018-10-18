package mx.mobilestudio.eaat.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mx.mobilestudio.eaat.R;
import mx.mobilestudio.eaat.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements ValueEventListener {

    private DatabaseReference databaseReference;

    public MenuFragment() {
        // Required empty public constructor
        databaseReference = FirebaseDatabase.getInstance().getReference("customers");
        getMenuList();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewToot=    inflater.inflate(R.layout.fragment_menu, container, false);

        return viewToot;
    }


    public void getMenuList(){


        databaseReference.addValueEventListener(this);
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        for (DataSnapshot child : dataSnapshot.getChildren() ){
            Customer cliente = child.getValue(Customer.class);

            Object object = child.getValue();

            Toast.makeText(getActivity(), "El cliente es "+object.toString(), Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
