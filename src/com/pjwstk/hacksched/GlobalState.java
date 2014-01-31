package com.pjwstk.hacksched;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.parse.Parse;

public class GlobalState extends Application {
	private static GlobalState singleton;
	public static Context context;

	
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
		context = getApplicationContext();
		//IMPORTANT!! This is out app key, that is why when compiling we need to use right mouse click on project -> Android Tools -> Export Signed Applica(...)
		Parse.initialize(this, "YUgE2xmaQuWn0aUjaQpRLyu7WTd8NemBe2EC6NkB", "uxaYvHVqLPFOfWFF47YSHnBXbAvfkSuledvttQob");
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