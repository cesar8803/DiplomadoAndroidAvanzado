package mx.mobilestudio.placefinder.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.mobilestudio.placefinder.R;
import mx.mobilestudio.placefinder.model.Venue;

public class ListResultsAdapter extends RecyclerView.Adapter {



    public List<Venue> venues;

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //En este metodo se decide el template (layout.xml) que vamos a ocupar para la lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_result_item,null);

            MyViewHolder vh = new MyViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            /// position va desde 0 hasta venues.size();

        Venue currentVenue = venues.get(position);
        MyViewHolder currentViewHolder = (MyViewHolder) holder;

        currentViewHolder.name.setText(currentVenue.getName());
        currentViewHolder.distance.setText(currentVenue.getLocation().getDistance().toString());
        currentViewHolder.city.setText(currentVenue.getLocation().getCity());

    }

    @Override
    public int getItemCount() {
        return venues.size();
    }


    public class MyViewHolder  extends  RecyclerView.ViewHolder{
        public TextView name;
        public TextView distance;
        public TextView city;



        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distancia);
            city = itemView.findViewById(R.id.city);

        }

    }


}
