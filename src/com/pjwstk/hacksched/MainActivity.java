package com.pjwstk.hacksched;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.PushService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//IMPORTANT!! This is out app key, that is why when compiling we need to use right mouse click on project -> Android Tools -> Export Signed Applica(...)
		Parse.initialize(this, "9UOTweJKonKjKREuVMHCezDw1Lpm1iJRf1m3P9X8", "XM0i1UWiEZsESeJ7kieX7q7KDmGXlNZmsQIUPRSy");
		
		PushService.setDefaultPushCallback(this, MainActivity.class);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
