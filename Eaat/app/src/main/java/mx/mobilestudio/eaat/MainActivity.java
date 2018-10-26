package mx.mobilestudio.eaat;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import mx.mobilestudio.eaat.fragment.BookFragment;
import mx.mobilestudio.eaat.fragment.MenuFragment;
import mx.mobilestudio.eaat.fragment.WaitTimeFragment;
import mx.mobilestudio.eaat.fragment.WelcomeFragment;
import mx.mobilestudio.eaat.interfaces.onFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements onFragmentInteractionListener {

    private RelativeLayout relativeLayout;
    private FragmentManager fragmentManager;

    public static final int FRAGMENT_WELCOME = 1;
    public static final int FRAGMENT_BOOK = 2;
    public static final int FRAGMENT_WAIT = 3;
    public static final int FRAGMENT_MENU =4;


    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        relativeLayout = findViewById(R.id.main_fragment_container);
        fragmentManager = getFragmentManager();
        attachFragment(FRAGMENT_WELCOME);


        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( MainActivity.this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                token  = FirebaseInstanceId.getInstance().getToken();
                Log.d("FCM_TOKEN",token);
                Toast.makeText(MainActivity.this, token,Toast.LENGTH_LONG).show();
            }
        });


    }




    public void attachFragment(int FRAGMENT_REQUIRED_ID){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (FRAGMENT_REQUIRED_ID){


            case FRAGMENT_WELCOME:

                Fragment welcomeFragment = new WelcomeFragment();

                fragmentTransaction.replace(R.id.main_fragment_container, welcomeFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;

            case FRAGMENT_BOOK:


                Fragment bookFragment = new BookFragment();

                fragmentTransaction.replace(R.id.main_fragment_container, bookFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;
            case FRAGMENT_WAIT:


                Fragment waitFragment = new WaitTimeFragment();

                fragmentTransaction.replace(R.id.main_fragment_container, waitFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;

            case FRAGMENT_MENU:


                Fragment menuFragment = new MenuFragment();

                fragmentTransaction.replace(R.id.main_fragment_container, menuFragment);

                fragmentTransaction.commit();
                //TODO terminar el agregar el fragmento
                break;
        }
    }

    @Override
    public void onFragmentChange(int FRAGMENT_ID) {

        switch (FRAGMENT_ID){

            case FRAGMENT_WELCOME:

                attachFragment(FRAGMENT_WELCOME);

                break;

            case FRAGMENT_BOOK:

                attachFragment(FRAGMENT_BOOK);

                break;

            case FRAGMENT_WAIT:

                attachFragment(FRAGMENT_WAIT);

                break;
            case FRAGMENT_MENU:

                attachFragment(FRAGMENT_MENU);

                break;

        }

    }


}
