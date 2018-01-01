package com.example.burgas_landmarks;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IntroTest extends Activity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro_test);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);// Bonus button
		
		
		TextView txt2=(TextView) findViewById(R.id.Result1);
		TextView txt1=(TextView) findViewById(R.id.Result2);
		final EditText ans1=(EditText) findViewById(R.id.ans1);
		final EditText ans2=(EditText) findViewById(R.id.ans2);
		Button next=(Button) findViewById(R.id.button1);
		final int a=new Random().nextInt(9)+2;
		final int b=new Random().nextInt(9)+2;

		txt1.setText(Integer.toString(a+b));
		txt2.setText(Integer.toString(a*b));

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(ans1.getText().toString().length()==0 || ans2.getText().toString().length()==0)
				{	Toast ts=Toast.makeText(IntroTest.this,"Въведи отговор!", Toast.LENGTH_SHORT);
				ts.show();
				if(ans1.getText().toString().length()==0)
					ans1.setError("Празно поле!");
				if(ans2.getText().toString().length()==0)
					ans2.setError("Празно поле!");
				}
				else{	int a1,b1;
					a1=Integer.parseInt((ans1.getText().toString()));
					b1=Integer.parseInt((ans2.getText().toString()));
					if((a1==a && b==b1) ||(b1==a && b==a1))
					{					
						Intent i = new Intent(IntroTest.this,List.class);
						startActivity(i);	
					    }	
					else 
					  {
						Toast ts2=Toast.makeText(IntroTest.this,"Опитай пак!", Toast.LENGTH_LONG);
						ts2.show();
					   }	
				}
				}
		});


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
		getMenuInflater().inflate(R.menu.intro_test, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id==android.R.id.home) {
			Intent i = new Intent(this,IntroTest.class);
			startActivity(i);
		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
