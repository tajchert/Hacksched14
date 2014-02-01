package com.pjwstk.hacksched.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pjwstk.hacksched.R;
import com.pjwstk.hacksched.utils.Constants;


public class ActivityContact extends Activity {
	 
	  private GoogleMap map;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_contact);
	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	    //Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
	    Marker hackathonPlace = map.addMarker(new MarkerOptions()
	        .position(Constants.PJWSTK_LOCATION)
	        //.title("PJWSTK")
	        //.snippet("PJWSTK is the best")
	        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
	    map.setBuildingsEnabled(true);
	    map.getUiSettings().setRotateGesturesEnabled(false);
	    map.getUiSettings().setZoomControlsEnabled(false);
	    map.getUiSettings().setTiltGesturesEnabled(false);
	    
	    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.PJWSTK_LOCATION, 9));
	    map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
	    
	    
	    Button buttonMap = (Button) findViewById(R.id.buttonMap);
	    buttonMap.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(ActivityContact.this, ActivityFullMap.class));
			}
		});
	  }

}