package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.adapter.ListResultsAdapter;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {



    private List<Venue> venues;
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager layoutManager;


    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /* Primer metodo ejecutado despues de la operación (replace, add) de FragmentTransaction
         este metodo recibe como parametro el Context del activity que agrego al Fragmento.
        Nota :  En este momento aun no es visible el fragmento
         */

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Segundo metodo ejecutado despues de la operación (replace, add) de FragmentTransaction
         este metodo recibe como parametro el Bundle del activity que agrego al Fragmento, para recuperar
         un estado  en particular del activity.
         Este metodo sirve para inicializar de forma unica algunas variables que el fragmento ocupara
         durante su ejecución
        Nota :  En este momento aun no es visible el fragmento
         */
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /* Tercer metodo ejecutado despues de la operación (replace, add) de FragmentTransaction
         este metodo recibe como parametro un LayoutInflater que sirve para inicializar el Layout del Fragmento.

         En este metodo practicamente se viste con su Layout al fragmento

        Nota :  En este momento aun no es visible el fragmento
         */

        layoutManager = new LinearLayoutManager(getActivity());

      View viiewRoot =   inflater.inflate(R.layout.fragment_list, container, false);
        recyclerview =  viiewRoot.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(layoutManager);

        ListResultsAdapter listResultsAdapter = new ListResultsAdapter();
        listResultsAdapter.setVenues(venues);


        recyclerview.setAdapter(listResultsAdapter);


        return viiewRoot;
    }

    @Override
    public void onStart() {
        /* este metodo marca el inicio de la ejecución del fragmento */

        super.onStart();

    }

    @Override
    public void onResume() {
        /* En este momento es visible el fragmento para el usuario y se ejecutara hasta que
         * se ponga en pausa o se remueva el fragmento */

        super.onResume();
    }


    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

}
