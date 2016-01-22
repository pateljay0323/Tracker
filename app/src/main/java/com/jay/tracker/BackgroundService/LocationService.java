package com.jay.tracker.BackgroundService;


import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationListener;

import java.text.DateFormat;
import java.util.Date;

public class LocationService extends Service implements LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location location;
    private double lattitude;
    private double longitude;
    private double altitude;
    private float speed;
    private long time;
    private float accuracy;
    private float bearing;
    private String date;

    @Override
    public void onCreate() {
        Toast.makeText(this,"Location Service Created",Toast.LENGTH_SHORT).show();
        super.onCreate();
        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Location Service Started",Toast.LENGTH_SHORT).show();
        //return super.onStartCommand(intent, flags, startId);
        if (googleApiClient != null && !googleApiClient.isConnected() && !googleApiClient.isConnecting())
            googleApiClient.connect();
        return START_STICKY;
    }

    private void createLocationRequest() {
        Toast.makeText(this,"Creating Location Request",Toast.LENGTH_SHORT).show();
        locationRequest = new LocationRequest()
                .setInterval(5000)
                .setFastestInterval(5000)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this,"Location Changed",Toast.LENGTH_SHORT).show();
        this.location = location;
        toast(location);
    }

    private void toast(Location location){
        lattitude = location.getLatitude();
        longitude = location.getLongitude();
        altitude = location.getAltitude();
        speed = location.getSpeed();
        time = location.getTime();
        accuracy = location.getAccuracy();
        bearing = location.getBearing();
        date = DateFormat.getTimeInstance().format(new Date());
        Toast.makeText(this,"Latitude : "+lattitude+"\nLongitude : "+longitude+"\nAltitude : "+altitude+"\nSpeed : "+speed+"\nTime : "+time+"\nAccuracy : "+accuracy+"\nBearing : "+bearing+"\nDate : "+date,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this,"onConnected() Called",Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        createLocationRequest();
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
