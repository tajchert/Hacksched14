package com.pjwstk.hacksched;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import com.pjwstk.hacksched.ui.ActivityEvent;
import com.pjwstk.hacksched.utils.Constants;

public class MainActivity extends Activity {
	protected GlobalState mApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mApplication = ((GlobalState)this.getApplication());
		
		PushService.setDefaultPushCallback(this, MainActivity.class);
		//PushService.subscribe(this, "Channel", MainActivity.class);
		//PushService.subscribe(this, "MAIN", MainActivity.class);
		Log.d(Constants.TAG, "MAIN");
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		Intent eventTest = new Intent(this, ActivityEvent.class);
	    startActivity(eventTest);
	    this.finish();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
