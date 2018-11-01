package mx.mobilestudio.eaat;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        setUpRealmConfig();
    }


    private void setUpRealmConfig(){

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().name("eaat.realm").build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
