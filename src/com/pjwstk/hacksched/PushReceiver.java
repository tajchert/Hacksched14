package com.pjwstk.hacksched;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.pjwstk.hacksched.ui.MainActivity;
import com.pjwstk.hacksched.utils.Constants;

public class PushReceiver extends BroadcastReceiver {
	//To call it use ex. {"action":"com.pjwstk.hacksched.UPDATE_STATUS","notif": true,"notiftitle": "Hack A Dice", "notifcontent":"You can win awesome prizes!", "class":"com.pjwstk.hacksched.ui.ActivityEvent"}
	 
	  @Override
	  public void onReceive(Context context, Intent intent) {
	    try {
	    	Log.d(Constants.TAG, "RECEIVED");
	      //String action = intent.getAction();
	      //String channel = intent.getExtras().getString("Channel");
	      JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
	      
	      if(json.getBoolean("notif")){
	    	  makeNotification(json);
	      }else{
	    	  //no notification - do background?
	      }
	      
	      /*
	      //Good for testing purposes
	      Iterator itr = json.keys();
	      while (itr.hasNext()) {
	        String key = (String) itr.next();
	        Log.d(Constants.TAG, key + " => " + json.getString(key));
	      }*/
	    } catch (JSONException e) {
	      Log.d(Constants.TAG, "JSONException: " + e.getMessage());
	    }
	  }
	  
	  
	@SuppressLint("NewApi")
	private void makeNotification(JSONObject json) {
		String title = "Title";
		String content = "Content";
		try {
			title = json.getString("notiftitle");
			content = json.getString("notifcontent");
		} catch (JSONException e) {
			Log.d(Constants.TAG, "JSONException: " + e.getMessage());
		}
		@SuppressWarnings("rawtypes")
		Class classToLaunch;
		classToLaunch = MainActivity.class;
		try {
			classToLaunch = Class.forName(json.getString("class"));
		} catch (JSONException e) {
			Log.d(Constants.TAG, "Class is default one.");
		} catch (ClassNotFoundException e) {
			Log.d(Constants.TAG, "Class is default one.");
		}
		
		long[] vibraPattern = { 0, 500, 250, 500 };

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(GlobalState.context)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle(title)
				.setContentText(content)
				.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
				// SOME EXTRAS
				.setAutoCancel(true).setLights(Color.BLUE, 2500, 2500)
				.setVibrate(vibraPattern)
				;
		
		Intent resultIntent = new Intent(GlobalState.context, classToLaunch);

		TaskStackBuilder stackBuilder = TaskStackBuilder
				.create(GlobalState.context);
		stackBuilder.addParentStack(classToLaunch);
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
				PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) GlobalState.context
				.getSystemService(GlobalState.context.NOTIFICATION_SERVICE);
		// mId allows you to update the notification later on.
		mNotificationManager.notify(Constants.NOTIFICATION_BASE_ID,
				mBuilder.build());
	}

	@SuppressWarnings("deprecation")
	private void makeNotificationOld(JSONObject json) {
		String title = "Title";
		String content = "Content";
		try {
			title = json.getString("notiftitle");
			content = json.getString("notifcontent");
		} catch (JSONException e) {
			Log.d(Constants.TAG, "JSONException: " + e.getMessage());
		}
		
		@SuppressWarnings("rawtypes")
		Class classToLaunch;
		classToLaunch = MainActivity.class;
		try {
			classToLaunch = Class.forName(json.getString("class"));
		} catch (JSONException e) {
			Log.d(Constants.TAG, "Class is default one.");
		} catch (ClassNotFoundException e) {
			Log.d(Constants.TAG, "Class is default one.");
		}
		
		
		NotificationManager nm = (NotificationManager) GlobalState.context
				.getApplicationContext().getSystemService(GlobalState.context.getApplicationContext().NOTIFICATION_SERVICE);
		
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = GlobalState.context.getApplicationContext().getString(R.string.app_name);
		long when = System.currentTimeMillis();
		Intent notificationIntent = new Intent(GlobalState.context.getApplicationContext(), classToLaunch);
		PendingIntent contentIntent = PendingIntent.getActivity(
				GlobalState.context.getApplicationContext(), 0, notificationIntent, 0);

		Notification notification = new Notification(icon, tickerText, when);
		notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.DEFAULT_ALL | Notification.FLAG_ONLY_ALERT_ONCE;

		notification.setLatestEventInfo(GlobalState.context.getApplicationContext(), title, content, contentIntent);

		nm.notify(Constants.NOTIFICATION_BASE_ID, notification);
	}
	}