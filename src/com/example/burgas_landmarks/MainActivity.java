package com.example.burgas_landmarks;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;



@SuppressWarnings("unused")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


			if (getIntent().getBooleanExtra("EXIT", false)) 
		{	   
			finish();
		}
		 
		SharedPreferences pref=getSharedPreferences("Ranklist",0);
		SharedPreferences.Editor edit=pref.edit();	

/*		Toast t=Toast.makeText(this, pref.getString("atMoment",null),Toast.LENGTH_SHORT);
		t.show();

		t=Toast.makeText(this,"asd",Toast.LENGTH_SHORT);
		t.show();
*/		
		
		if(pref.getString("atMoment",null) == null)
		{

			edit.putString("atMoment","1");
			edit.commit();
		}

//edit.putString("Full", "0");

//	Toast	t=Toast.makeText(this, pref.getString("atMoment",null),Toast.LENGTH_SHORT);
//		t.show();
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startButton(View v)
	{

		Intent i = new Intent(this,IntroTest.class);
		startActivity(i);


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
