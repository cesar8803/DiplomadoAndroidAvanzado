package mx.mobilestudio.eaat.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

import mx.mobilestudio.eaat.R;
import mx.mobilestudio.eaat.model.Customer;

public class MenuResultsAdapter extends RecyclerView.Adapter {

    public ArrayList<Customer> clientes;


    public MenuResultsAdapter(ArrayList<Customer> clientes) {
        this.clientes = clientes;

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.menuresultitem,null);


        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.name.setText(clientes.get(position).getName());
        myViewHolder.lastName.setText(clientes.get(position).getLastName());
        myViewHolder.numberCustomer.setText(String.valueOf(clientes.get(position).getNumberOfCustomers()));
      //  myViewHolder.willSmoke.setText(String.valueOf(clientes.get(position).willSmoke));

    }

    @Override
    public int getItemCount() {
        return clientes.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView lastName;
        public TextView numberCustomer;
        public TextView willSmoke;


        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.customerName);
            lastName = itemView.findViewById(R.id.customerLastName);
            numberCustomer = itemView.findViewById(R.id.numberPersons);
            willSmoke = itemView.findViewById(R.id.willSmoke);

        }
    }





}
