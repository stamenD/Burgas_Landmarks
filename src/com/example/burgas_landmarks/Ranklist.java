package com.example.burgas_landmarks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Ranklist extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranklist);


		SharedPreferences pref=getSharedPreferences("Ranklist",0);

		/*	Toast t=Toast.makeText(this, pref.getString("atMoment",null),Toast.LENGTH_SHORT);
		t.show();
		t=Toast.makeText(this, pref.getString(String.valueOf(1)+".1",null),Toast.LENGTH_SHORT);
		t.show();
		t=Toast.makeText(this, pref.getString(String.valueOf(1)+".2",null),Toast.LENGTH_SHORT);
		t.show();
		t=Toast.makeText(this, pref.getString(String.valueOf(1)+".3",null),Toast.LENGTH_SHORT);
		t.show();
		 */
		int id=R.id.date1;

		if(Integer.parseInt(pref.getString("Full",null))==1)
		{

			for(int i=1;i<10;i++)
			{	
				TextView date=(TextView) findViewById(id+(i-1)*4);
				TextView name=(TextView) findViewById(id+1+(i-1)*4);
				TextView res=(TextView) findViewById(id+2+(i-1)*4);

				date.setText(pref.getString(String.valueOf(i)+".1",null));
				name.setText(pref.getString(String.valueOf(i)+".2",null));
				res.setText(pref.getString(String.valueOf(i)+".3",null));
			}

		}
		else{


			for(int i=1;i<Integer.parseInt(pref.getString("atMoment",null));i++)
			{	
				TextView date=(TextView) findViewById(id+(i-1)*4);
				TextView name=(TextView) findViewById(id+1+(i-1)*4);
				TextView res=(TextView) findViewById(id+2+(i-1)*4);

				date.setText(pref.getString(String.valueOf(i)+".1",null));
				name.setText(pref.getString(String.valueOf(i)+".2",null));
				res.setText(pref.getString(String.valueOf(i)+".3",null));
			}
				}


		}


		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.ranklist, menu);
			return true;
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
