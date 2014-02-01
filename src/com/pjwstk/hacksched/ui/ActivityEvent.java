package com.pjwstk.hacksched.ui;

import java.util.Calendar;
import java.util.TimeZone;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pjwstk.hacksched.R;

public class ActivityEvent extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		Button addToScheduleButton = (Button) findViewById(R.id.addToScheduleButton);
		addToScheduleButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Calendar cal = Calendar.getInstance();
				String eventUriString = "content://com.android.calendar/events";
			    ContentValues eventValues = new ContentValues();

			    eventValues.put("calendar_id", 1); // id, We need to choose from
			                                        // our mobile for primary
			                                        // its 1
			    eventValues.put("title", "TestEVENT");
			    eventValues.put("description", "desc");
			    eventValues.put("eventLocation", "PJWSTK, Warszawa");

			    long endDate = cal.getTimeInMillis() + 1000 * 60 * 60; // For next 1hr

			    eventValues.put("dtstart", cal.getTimeInMillis());
			    eventValues.put("dtend", endDate);
			    eventValues.put("eventTimezone", TimeZone.getDefault().getID());

			    eventValues.put("allDay", 0);

			    Uri eventUri = ActivityEvent.this.getContentResolver().insert(Uri.parse(eventUriString), eventValues);
			    //long eventID = Long.parseLong(eventUri.getLastPathSegment());//Event ID if we want to change it
			    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_SHORT).show();
			}
		});
		
		TextView speakerName = (TextView) findViewById(R.id.personTop);

		speakerName.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		    	showProfile();
		    }
		});
		Button button_profile = (Button) findViewById(R.id.button_profile);
		button_profile.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showProfile();
			}
		});
		
		
	}
	private void showProfile(){
		final Dialog dialog = new Dialog(ActivityEvent.this);
		dialog.setContentView(R.layout.dialog_custom_speaker);
		dialog.setTitle("Matias Duarte");
		TextView text = (TextView) dialog.findViewById(R.id.text);
		text.setText("Chilean computer interface designer, and the Director of Android operating system User Experience at Google. Android 3.0 \"Honeycomb\" was the first release with a major elements of his design influence.\nPrior to moving to Google to work on Android, Duarte had similar roles in Palm’s webOS, the Helio Ocean and the Danger Hiptop (T-Mobile Sidekick).\nDuarte's list of patents includes 28 US Patents and 30 pending US Patent applications");
		ImageView image = (ImageView) dialog.findViewById(R.id.image_profile);
		image.setImageResource(R.drawable.matias_duarte);

		Button googleplus_profile_Button = (Button) dialog.findViewById(R.id.googleplus_profile_Button);
		googleplus_profile_Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/114892667463719782631/posts")));
				dialog.dismiss();
			}
		});
		dialog.show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
