package mx.mobilestudio.eaat.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.mobilestudio.eaat.R;
import mx.mobilestudio.eaat.adapter.MenuResultsAdapter;
import mx.mobilestudio.eaat.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements ValueEventListener {

    private DatabaseReference databaseReference;
    private  Collection<Object> values;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public MenuFragment() {
        // Required empty public constructor
        databaseReference = FirebaseDatabase.getInstance().getReference("customers");

        linearLayoutManager = new LinearLayoutManager(getActivity());
        getMenuList();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewToot=    inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerView = viewToot.findViewById(R.id.listaClientes);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(linearLayoutManager);


        return viewToot;
    }


    public void getMenuList(){


        databaseReference.addValueEventListener(this);
    }


    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        ArrayList<Customer> clientes =  new ArrayList<Customer>();


        for (DataSnapshot child : dataSnapshot.getChildren() ){
            Customer cliente = child.getValue(Customer.class);


            Toast.makeText(getActivity(), "El cliente es "+cliente.getName(), Toast.LENGTH_LONG).show();

            clientes.add(cliente);
        }

        populateRecyclerView(clientes);

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }




    public void populateRecyclerView( ArrayList<Customer> clientes ){

        MenuResultsAdapter menuResultsAdapter = new MenuResultsAdapter(clientes);

        recyclerView.setAdapter(menuResultsAdapter);

    }
}
