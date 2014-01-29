package com.pjwstk.hacksched;

import com.parse.Parse;

import android.app.Application;
import android.content.res.Configuration;

public class GlobalState extends Application {
	private static GlobalState singleton;
	
	public GlobalState getInstance(){
		return singleton;
	}
	
	 
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
 
	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		//IMPORTANT!! This is out app key, that is why when compiling we need to use right mouse click on project -> Android Tools -> Export Signed Applica(...)
		Parse.initialize(this, "9UOTweJKonKjKREuVMHCezDw1Lpm1iJRf1m3P9X8", "XM0i1UWiEZsESeJ7kieX7q7KDmGXlNZmsQIUPRSy");
	}
 
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
 
	@Override
	public void onTerminate() {
		super.onTerminate();
	}
 
}