package mx.mobilestudio.placefinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import mx.mobilestudio.placefinder.fragment.ListFragment;
import mx.mobilestudio.placefinder.fragment.MapFragment;
import mx.mobilestudio.placefinder.model.ApiFourSquareResponse;
import mx.mobilestudio.placefinder.model.Venue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , Response.Listener , Response.ErrorListener{

    private FragmentManager fragmentManager;
    private Button button1;
    private  Button button2;
    private  Button button_buscar;
    private EditText input_busqueda;

    public static final int FRAGMENT_LIST_ID = 1;
    public static final int FRAGMENT_MAP_ID = 2;

    public List<Venue> venues;


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
                ((ListFragment) listResultFragment).setVenues(venues);


                fragmentTransaction.replace(R.id.main_content_container, listResultFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;

            case FRAGMENT_MAP_ID:


                Fragment mapResultFragment = new MapFragment();

                ((MapFragment) mapResultFragment).setVenues(venues);

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

        /*

        ?client_id=HOSIY11XMXHWFADXIPQTF5HRZA3YIWIFGRAOA5NIGXOY3CWI
        &client_secret=OGATJNY0E0JY15PRXYD5MQ2WW3EMFLRAWFHLAOQYSTMVKMHM
        &v=20130815
        &ll=19.433997,-99.146006
        &query=gasolinera
         */


        String location="19.433997"+","+"-99.146006";//HardCode LL for demo

        // Es una fila de requests que nos ayudan  darle orden y prioridad a las peticiones
        RequestQueue queue = Volley.newRequestQueue(this);




        String URL_API = Uri.parse("https://api.foursquare.com/v2/venues/search").buildUpon()
                            .appendQueryParameter("client_id","HOSIY11XMXHWFADXIPQTF5HRZA3YIWIFGRAOA5NIGXOY3CWI")
                            .appendQueryParameter("client_secret","OGATJNY0E0JY15PRXYD5MQ2WW3EMFLRAWFHLAOQYSTMVKMHM")
                            .appendQueryParameter("v","20130815")
                            .appendQueryParameter("ll",location)
                            .appendQueryParameter("query",query).build().toString();


        /* Inicializamos el String Request
        Nos pide El metodo HTTP GET o POST
        La URL destino
        y un Listener (Exito) y por ultimo un ErrorListener (Error)
         */

        StringRequest stringRequest = new StringRequest(Request.Method.GET,URL_API,this,this);

        queue.add(stringRequest);
    }

    @Override
    public void onResponse(Object response) {

        Gson gson = new Gson();

        ApiFourSquareResponse apiFourSquareResponse = gson.fromJson((String) response, ApiFourSquareResponse.class);

         venues = apiFourSquareResponse.response.venues;


        /* Es necesario pasar el listado a los diferentes fragmentos*/
        attachFragment(FRAGMENT_LIST_ID);



    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();


    }
}
