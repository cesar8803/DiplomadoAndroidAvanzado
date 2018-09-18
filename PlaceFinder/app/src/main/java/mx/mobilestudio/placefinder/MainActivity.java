package mx.mobilestudio.placefinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.mobilestudio.placefinder.fragment.ListFragment;
import mx.mobilestudio.placefinder.fragment.MapFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private Button button1;
    private  Button button2;
    private  Button button_buscar;
    private EditText input_busqueda;

    public static final int FRAGMENT_LIST_ID = 1;
    public static final int FRAGMENT_MAP_ID = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button_buscar = findViewById(R.id.button_buscar);
        input_busqueda = findViewById(R.id.editText);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button_buscar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button1:
                Toast.makeText(this, "Button 1", Toast.LENGTH_LONG).show();
                attachFragment(FRAGMENT_LIST_ID);
                break;
            case R.id.button2:
                Toast.makeText(this, "Button 2", Toast.LENGTH_LONG).show();
                attachFragment(FRAGMENT_MAP_ID);

                break;
            case R.id.button_buscar:

                String cadenaSearch = input_busqueda.getText().toString();
                searchinFourSquareApi(cadenaSearch);

                break;
                default:
                    break;
        }
    }


    public void attachFragment(int FRAGMENT_REQUIRED_ID){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (FRAGMENT_REQUIRED_ID){


            case FRAGMENT_LIST_ID:

                Fragment listResultFragment = new ListFragment();

                fragmentTransaction.replace(R.id.main_content_container, listResultFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;

            case FRAGMENT_MAP_ID:


                Fragment mapResultFragment = new MapFragment();

                fragmentTransaction.replace(R.id.main_content_container, mapResultFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;
        }







    }


    public void searchinFourSquareApi(String query){

        Toast.makeText(this,query,Toast.LENGTH_LONG).show();

        /*
         El proposito de este metodo es ejecutar el  request HTTP hacia FourSquare
         */
        //TODO ejecutar request con Volley

    }

}
