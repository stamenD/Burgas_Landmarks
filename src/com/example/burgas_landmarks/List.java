package com.example.burgas_landmarks;

import java.util.ArrayList;
import java.util.Collections;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class List extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		  SharedPreferences pref=getSharedPreferences("Questions",0);		  
		  SharedPreferences.Editor edit=pref.edit();
		    
		    ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=1; i<5; i++) {
	            list.add(i);
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<2; i++) {
	        	 edit.putString(String.valueOf(i),String.valueOf(list.get(i)));
	        	 edit.commit();
	        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id==R.id.more_info) {
			String webpage="http://www.burgas.bg";
			Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(webpage));
			startActivity(intent);
	return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	    if (keyCode == KeyEvent.KEYCODE_BACK) 
	    {
	    	Toast t=Toast.makeText(this, "Няма възможност!",Toast.LENGTH_SHORT);
			t.show();
	    }

	    return false;
	}
	public void INFO(View v)
	{
		
		String webpage="http://www.google.bg";
		Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(webpage));
		startActivity(intent);
		
	}
	public void Category1(View v){
		
	Intent i = new Intent(List.this,Category_one.class);
	startActivity(i);
}
	public void Category2(View v){
		
	Intent i = new Intent(List.this,Category_two.class);
	startActivity(i);
}
	public void Category3(View v){
		
	Intent i = new Intent(List.this,com.example.burgas_landmarks.Category_three.class);
	startActivity(i);
}
	public void Category4(View v){
		
	Intent i = new Intent(List.this,com.example.burgas_landmarks.Category_four.class);
	startActivity(i);
}
}