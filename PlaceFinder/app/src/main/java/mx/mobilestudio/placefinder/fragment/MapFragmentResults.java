package mx.mobilestudio.placefinder.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragmentResults extends Fragment implements OnMapReadyCallback {

    private GoogleMap googleMap;

    private List<Venue> venues;


    public MapFragmentResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mapFragmentView = inflater.inflate(R.layout.fragment_map, container, false);

        MapFragment mapFragment1 = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment1.getMapAsync(this);

        return mapFragmentView;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        // El mapa se inicializo correctamente y es visible para el usuario.

        this.googleMap = googleMap;

        // CameraUpdate  es una actualización al enfoque de la parte visible del mapa

        LatLng latLng = new LatLng(19.395209,-99.1544203);


        CameraUpdate cameraUpdate =  CameraUpdateFactory.newLatLngZoom(latLng, 14f);

        MarkerOptions markerOptions  = new MarkerOptions();

        markerOptions.position(latLng);
        markerOptions.title("MobileStudio");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


        this.googleMap.moveCamera(cameraUpdate);

        this.googleMap.addMarker(markerOptions);

    }

    public void paintFourSquareMarketsinMap(List<Venue> venues){
        // Metodo encargado de pintar los marcadores de los venues en el mapa

        for(Venue currentVenue : venues){

        }


    }


}
