package com.example.burgas_landmarks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FinalScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_screen);


		final Intent i=getIntent();
		TextView tv=(TextView) findViewById(R.id.ResultBlank);
		tv.setText(new String(i.getStringExtra("Result")));
		/*	final Intent i=getIntent();
	TextView tv=(TextView) findViewById(R.id.ResultBlank);
	tv.setText(new String(i.getStringExtra("Result")));

	final EditText addName=(EditText) findViewById(R.id.NameBlank);


	Button addRank=(Button) findViewById(R.id.RankBtn);
	addRank.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
			String date = df.format(Calendar.getInstance().getTime());


		    SharedPreferences pref=getSharedPreferences("Ranklist",0);
		    SharedPreferences.Editor edit=pref.edit();

		    edit.putString("atMoment", "1");
		    edit.commit();

		    edit.putString(pref.getString("atMoment",null)+".1", date);
		    edit.putString(pref.getString("atMoment",null)+".2", addName.getText().toString());
		    edit.putString(pref.getString("atMoment",null)+".3", new String(i.getStringExtra("Result")));
		    edit.commit();

		    int count=1+Integer.parseInt(pref.getString("atMoment",null));
		    edit.putString("atMoment",String.valueOf(count));
		    edit.commit();

		Toast t=Toast.makeText(FinalScreen.this, pref.getString("atMoment",null),Toast.LENGTH_SHORT);
			t.show();
			 t=Toast.makeText(FinalScreen.this, date,Toast.LENGTH_SHORT);
				t.show();
				 t=Toast.makeText(FinalScreen.this, addName.getText().toString(),Toast.LENGTH_SHORT);
					t.show();
					 t=Toast.makeText(FinalScreen.this, new String(i.getStringExtra("Result")),Toast.LENGTH_SHORT);
						t.show();
		}
	});*/

	}

	public void  goSave(View v){

		Button pressB=(Button) findViewById(R.id.RankBtn);
	
		final Intent i=getIntent();
		TextView tv=(TextView) findViewById(R.id.ResultBlank);
		tv.setText(new String(i.getStringExtra("Result")));

		final EditText addName=(EditText) findViewById(R.id.NameBlank);


		SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
		String date = df.format(Calendar.getInstance().getTime());


		SharedPreferences pref=getSharedPreferences("Ranklist",0);
		SharedPreferences.Editor edit=pref.edit();

		edit.putString(pref.getString("atMoment",null)+".1", date);
		edit.putString(pref.getString("atMoment",null)+".2", addName.getText().toString());
		edit.putString(pref.getString("atMoment",null)+".3", new String(i.getStringExtra("Result")));
		edit.commit();

		int count=1+Integer.parseInt(pref.getString("atMoment",null));
		if(count==10)
		{ 	
			edit.putString("atMoment","1");			
			edit.putString("Full", "1");
			edit.putString(pref.getString("atMoment",null)+".1", date);
			edit.putString(pref.getString("atMoment",null)+".2", addName.getText().toString());
			edit.putString(pref.getString("atMoment",null)+".3", new String(i.getStringExtra("Result")));
			edit.commit();
 		
		
		}  
		else{				
			edit.putString("atMoment",String.valueOf(count));			
			edit.commit();
		}
		pressB.setEnabled(false);
		addName.setEnabled(false);
		Toast t=Toast.makeText(FinalScreen.this, "Резултата е записан",Toast.LENGTH_SHORT);
		t.show();

	}


	public void  goRank(View v){	
		Intent i = new Intent(this,Ranklist.class);
		startActivity(i);
	}


	public void  toEnd(View v){
		Intent intent = new Intent(this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("EXIT", true);
		startActivity(intent);

	}

	public void  tryAgain(View v){
		Intent intent = new Intent(this, List.class);
		startActivity(intent);

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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.final_screen, menu);
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

