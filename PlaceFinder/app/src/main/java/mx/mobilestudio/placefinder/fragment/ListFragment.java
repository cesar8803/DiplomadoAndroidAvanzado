package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.mobilestudio.placefinder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_list, container, false);
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

}
