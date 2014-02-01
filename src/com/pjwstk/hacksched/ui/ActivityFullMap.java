package com.pjwstk.hacksched.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pjwstk.hacksched.R;
import com.pjwstk.hacksched.utils.Constants;


public class ActivityFullMap extends Activity {
	 
	  private GoogleMap map;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_fullmap);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapFull)).getMap();
	    //Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG).title("Hamburg"));
	    Marker hackathonPlace = map.addMarker(new MarkerOptions()
	        .position(Constants.PJWSTK_LOCATION)
	        //.title("PJWSTK")
	        //.snippet("PJWSTK is the best")
	        .icon(BitmapDescriptorFactory
	        .fromResource(R.drawable.ic_launcher)));
	    map.setBuildingsEnabled(true);
	    map.getUiSettings().setRotateGesturesEnabled(true);
	    map.getUiSettings().setZoomControlsEnabled(true);
	    map.getUiSettings().setTiltGesturesEnabled(false);
	    
	    map.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.PJWSTK_LOCATION, 8));
	    map.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
	    
	  }
	  
	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }

	} 