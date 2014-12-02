package com.example.mylocator;

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.util.EncodingUtils;

import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.util.Log;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;  
  
public class ScheduleFragment extends Fragment {  
	
	  private ListView listView;
	  private TextView[] testview;
	  private RelativeLayout[] layout;
	  private View rootView;
	  private ArrayList<Event> myche;
	 
	  private int currentPage=0;
	  
  @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
         rootView = inflater.inflate(R.layout.schedule, container, false);//get the layout file  
       
       
        
     //  RelativeLayout layout=(RelativeLayout)rootView.findViewById(R.id.event_frame3);
      // layout.setVisibility(View.INVISIBLE);
    //   testview.setText(outPutFile());
      // readFileByLines("/data/data/com.example.mylocator/files/schedule.txt");
       myche=readFileByLines("/data/data/com.example.mylocator/files/schedule.txt");
       testview=new TextView[15];
       layout=new RelativeLayout[5];
       testview[0]=(TextView)rootView.findViewById(R.id.schedule1);
       testview[1]=(TextView)rootView.findViewById(R.id.schedule2);
       testview[2]=(TextView)rootView.findViewById(R.id.schedule3);
       testview[3]=(TextView)rootView.findViewById(R.id.schedule4);
       testview[4]=(TextView)rootView.findViewById(R.id.schedule5);
       testview[5]=(TextView)rootView.findViewById(R.id.schedule6);
       testview[6]=(TextView)rootView.findViewById(R.id.schedule7);
       testview[7]=(TextView)rootView.findViewById(R.id.schedule8);
       testview[8]=(TextView)rootView.findViewById(R.id.schedule9);
       testview[9]=(TextView)rootView.findViewById(R.id.schedule10);
       testview[10]=(TextView)rootView.findViewById(R.id.schedule11);
       testview[11]=(TextView)rootView.findViewById(R.id.schedule12);
       testview[12]=(TextView)rootView.findViewById(R.id.schedule13);
       testview[13]=(TextView)rootView.findViewById(R.id.schedule14);
       testview[14]=(TextView)rootView.findViewById(R.id.schedule15);
       layout[0]=(RelativeLayout)rootView.findViewById(R.id.event_frame1);
       layout[1]=(RelativeLayout)rootView.findViewById(R.id.event_frame2);
       layout[2]=(RelativeLayout)rootView.findViewById(R.id.event_frame3);
       layout[3]=(RelativeLayout)rootView.findViewById(R.id.event_frame4);
       layout[4]=(RelativeLayout)rootView.findViewById(R.id.event_frame5);
       
       getData();
       return rootView;  
    }  
  
	 public void getData(){
		 
		 
		 int i=currentPage*5;
		 int j=0;
		 int item=0;
		 while(i<myche.size()){
			 
			 testview[j].setText(myche.get(i).getName());
			 testview[j+1].setText(myche.get(i).getLocation());
			 testview[j+2].setText(myche.get(i).getTime());
			 i+=1;
			 j+=3;
			 item+=1;
			/* testview[3].setText(myche.get(i).getName());
			 testview[4].setText(myche.get(i).getLocation());
			 testview[5].setText(myche.get(i).getTime());
			 testview[6].setText(myche.get(i).getName());
			 testview[7].setText(myche.get(i).getLocation());
			 testview[8].setText(myche.get(i).getTime());
			 testview[9].setText(myche.get(i).getName());
			 testview[10].setText(myche.get(i).getLocation());
			 testview[11].setText(myche.get(i).getTime());
			 testview[12].setText(myche.get(i).getName());
			 testview[13].setText(myche.get(i).getLocation());
			 testview[14].setText(myche.get(i).getTime());
			 */ 
		 }
		 for(int k=5-item, l=1;k>0;k--,l++)
		 {
			 layout[5-l].setVisibility(View.INVISIBLE);
			 Log.i("invisible","in"+k);
		 }
		 
		 
	 }
    
	
	 public void outPutFile() throws IOException
	    {
		 
		
		 /*
	    	 String res=""; 

	         try{ 

	          FileInputStream fin = new FileInputStream("/data/data/com.example.mylocator/files/schedule.txt"); 

	          int length = fin.available(); 

	          byte [] buffer = new byte[length]; 

	          fin.read(buffer);     

	          res = EncodingUtils.getString(buffer, "UTF-8"); 

	          fin.close();     

	         } 

	         catch(Exception e){ 

	          e.printStackTrace(); 

	         } 

	         return res; */
		 
	    }
	  public  ArrayList<Event> readFileByLines(String fileName) {
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        ArrayList<Event> events= new ArrayList<Event>();
	        try {
	            System.out.println("one line per time");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            String str1=null;
	            String str2=null;
	            String str3=null;
	            int line = 0;
	            // 一次读入一行，直到读入null为文件结束
	            Event e;
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	               if(line%3==0) str1=tempString;
	               if(line%3==1) str2=tempString;
	               if(line%3==2) {str3=tempString;
	               events.add(new Event(str1,str2,str3));
	               }
 	                line++;
	                
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return events;
	    }
   
}  
