package mx.mobilestudio.eaat.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Customer extends RealmObject {

    public String name;
    public String lastName;
    public boolean willSmoke;
    public int numberOfCustomers;

    public  Customer(){

    }

    public Customer(String name, String lastName, boolean willSmoke, int numberOfCustomers) {
        this.name = name;
        this.lastName = lastName;
        this.willSmoke = willSmoke;
        this.numberOfCustomers = numberOfCustomers;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isWillSmoke() {
        return willSmoke;
    }

    public void setWillSmoke(boolean willSmoke) {
        this.willSmoke = willSmoke;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

}
