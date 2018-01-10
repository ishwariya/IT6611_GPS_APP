package com.example.gpsapp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements LocationListener{
	LocationManager locationManager;
	Location location;
	Button locButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);
        locButton = (Button) findViewById(R.id.get_loc);
        locButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				String data = "Latitude: "+String.valueOf(location.getLatitude());
				data = data + "\nLongitude: " +String.valueOf(location.getLongitude());
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
			}
		});
    }
    
	@Override
	public void onLocationChanged(Location currentLocation) {
		location = currentLocation;
		String data = String.valueOf(location.getLatitude());
		data = data + "\n" +String.valueOf(location.getLongitude());
		Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderDisabled(String arg0) {
		Toast.makeText(getApplicationContext(), "GPS Disabled", Toast.LENGTH_SHORT).show();		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		Toast.makeText(getApplicationContext(), "GPS Enabled", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}
