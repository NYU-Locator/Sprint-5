package com.example.mylocator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eventlist);

	}

	public void event1(View v) {

		Intent intent = new Intent();
		intent.setClass(ListActivity.this, EventDetail.class);
      	Bundle bundle= new Bundle();
    	TextView name = (TextView) findViewById(R.id.event_name1);
    	TextView region = (TextView) findViewById(R.id.event_region1);
//           	TextView m = (TextView) rootView.findViewById(R.id.event_m1);

    	bundle.putString("key_name", name.getText().toString());
    	bundle.putString("key_region", region.getText().toString());
//    	bundle.putString("key_m", m.getText().toString());

    	intent.putExtras(bundle);
		startActivity(intent);

	}

	public void event2(View v) {

		Intent intent = new Intent();
		intent.setClass(ListActivity.this, EventDetail.class);
		startActivity(intent);

	}
}
