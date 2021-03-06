package mx.mobilestudio.eaat.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import mx.mobilestudio.eaat.MainActivity;
import mx.mobilestudio.eaat.R;
import mx.mobilestudio.eaat.interfaces.onFragmentInteractionListener;
import mx.mobilestudio.eaat.model.Customer;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment implements View.OnClickListener, OnSuccessListener , OnFailureListener {

    private Button lessButton;
    private Button moreButon;
    private Button accept_button;
    private EditText editText;
    private EditText editTextName;
    private EditText editTextLastName;
    private Switch switch1;

    private DatabaseReference databaseReference;

    public onFragmentInteractionListener onFragmentInteractionListener;


    public BookFragment() {
        // Required empty public constructor
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        databaseReference = FirebaseDatabase.getInstance().getReference();
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

        View viewRoot =         inflater.inflate(R.layout.fragment_book, container, false);
        lessButton =  viewRoot.findViewById(R.id.less_button);
        moreButon = viewRoot.findViewById(R.id.right_button);
        accept_button = viewRoot.findViewById(R.id.accept_button);
        editText = viewRoot.findViewById(R.id.editText);

        switch1 = viewRoot.findViewById(R.id.switch1);
        editText.setText("1");

        editTextName = viewRoot.findViewById(R.id.name);
        editTextLastName = viewRoot.findViewById(R.id.lastname);


        lessButton.setOnClickListener(this);
        moreButon.setOnClickListener(this);
        accept_button.setOnClickListener(this);

        return viewRoot;
    }

    @Override
    public void onClick(View view) {
        String stringValue =  editText.getText().toString();
        Integer intValue = new Integer(stringValue);
        switch (view.getId()){
            case R.id.less_button:

                intValue--;
                break;
            case R.id.right_button:
                intValue++;

                break;

            case R.id.accept_button:
                if(validateForm().isEmpty()){
                    createNewCustomer();
                }

                break;
        }

        editText.setText(intValue.toString());
    }


    public String validateForm(){

        String errorMessage= "";

        if(editTextName.getText().toString().isEmpty()){
            errorMessage = "Introduce un nombre valido\n";
        }

        Integer intValue = new Integer(editText.getText().toString());


        if(intValue<=0){
            errorMessage = errorMessage+"Introduce un nombre de personas valido";
        }

        return errorMessage;

    }

    public void createNewCustomer(){

        Customer customer = new Customer();

        customer.setLastName(editTextLastName.getText().toString());

        customer.setName(editTextName.getText().toString());

        Integer intValue = new Integer(editText.getText().toString());

        customer.setNumberOfCustomers(intValue);


        boolean ischeck=  switch1.isChecked();
        customer.setWillSmoke(ischeck);

        String customerId = databaseReference.push().getKey();



        databaseReference.child("customers").child(customerId).setValue(customer).addOnSuccessListener(this).addOnFailureListener(this);

        saveLocalCustomer(customer);
    }



    public void  saveLocalCustomer(Customer customer){

        Realm  realm = Realm.getDefaultInstance();


        realm.beginTransaction();

        // Todas las actualizaciones que se ejecuten son en este bloque de codigo.
         Customer localCustomer = realm.copyToRealm(customer);


        realm.commitTransaction();


        getAllSmokeCustomers();

    }



    public void getAllCustomers(){

        Realm  realm = Realm.getDefaultInstance();

        RealmResults<Customer> results  = realm.where(Customer.class).findAll();

        for(Customer currentCustomer : results){
            Toast.makeText(getActivity(), "Name: "+currentCustomer.getName(),Toast.LENGTH_LONG).show();

        }

    }



    public void getAllSmokeCustomers(){

        Realm  realm = Realm.getDefaultInstance();

        RealmResults<Customer> results  = realm.where(Customer.class).equalTo("willSmoke",true).findAll();

        for(Customer currentCustomer : results){
            Toast.makeText(getActivity(), "Name: "+currentCustomer.getName(),Toast.LENGTH_LONG).show();

        }

    }



    @Override
    public void onFailure(@NonNull Exception e) {


        Toast.makeText(getActivity(),"Sucedio un error, verifica tu conexión",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSuccess(Object o) {

        Toast.makeText(getActivity(),"CLiente creado exitosamente!!",Toast.LENGTH_LONG).show();

        onFragmentInteractionListener.onFragmentChange(MainActivity.FRAGMENT_WAIT);

    }
}
