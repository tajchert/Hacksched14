package com.pjwstk.hacksched;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.parse.Parse;
import com.parse.PushService;
import com.pjwstk.hacksched.ui.ActivityEvent;

public class MainActivity extends Activity {
	protected GlobalState mApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mApplication = ((GlobalState)this.getApplication());
		
		PushService.setDefaultPushCallback(this, MainActivity.class);
		
		
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		Intent eventTest = new Intent(this, ActivityEvent.class);
	    startActivity(eventTest);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
