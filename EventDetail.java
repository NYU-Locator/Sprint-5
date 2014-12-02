package com.example.mylocator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EventDetail extends Activity{
		private Button but1;
		private TextView name;
		private TextView location;
		private TextView time;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.eventdetail);
		but1=(Button) findViewById(R.id.button1);
		but1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				  File f = new File("/data/data/com.example.mylocator/files/schedule.txt");
				  if (f.exists()) f.exists();
				  else Log.i("file error","cant read the file");
			    	
			    	 name=(TextView)findViewById(R.id.textView_detail_name);
			    	 location=(TextView)findViewById(R.id.textView_detail_region);
			    	 time=(TextView)findViewById(R.id.textView_time);
			    	
			    	 try { 
			    		 FileWriter writer = new FileWriter("/data/data/com.example.mylocator/files/schedule.txt", true);
			    		 writer.write(name.getText().toString());
			    	 writer.write("\r\n");
						writer.write(location.getText().toString());
						writer.write("\r\n");
				    	 writer.write(time.getText().toString());
				    	 writer.write("\r\n");
				  
				    	 writer.close();
				    	 but1.setText("done !");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	 
			    	
			    	return ;
				 
			}
		});
		}

		
	
}