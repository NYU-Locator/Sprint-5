package com.example.mylocator;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetail extends Activity{
		private ImageButton map1;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.eventdetail);
			
			//receive the value of the bundle
			Bundle bundle = this.getIntent().getExtras();
			//receive name value
			String name = bundle.getString("key_name");
			TextView view1 = (TextView) findViewById(R.id.textView_detail_name);
			view1.setText(name);
			//receive region value
			String region = bundle.getString("key_region");
			TextView view2 = (TextView) findViewById(R.id.textView_detail_region);
			view2.setText(region);
		map1=(ImageButton) findViewById(R.id.imageButton1);
		map1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(EventDetail.this, map.class);
				startActivity(intent);	
			}
		});
		}

		
	
}
