package com.example.burgas_landmarks;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Exam extends Activity {



	final static boolean[]arr=new boolean[3];
	static int count=0;
	static int trueAns=0;
	final static int[]draw=new int[2];
	
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exam);

		  SharedPreferences pref=getSharedPreferences("Questions",0);

		  for(int i=0;i<2;i++)  
		  {  
			  String tv=pref.getString(String.valueOf(i),null);
		    if (tv!=null){
		        draw[i]=Integer.parseInt(tv);

		    }
		  }
		  
//		  Toast drawexam=Toast.makeText(this,String.valueOf( draw[0])+"  "+String.valueOf( draw[1]), Toast.LENGTH_SHORT);
//		  drawexam.show();
		Intent intent=getIntent();
		String mainQ=intent.getStringExtra("MainQ");

		RadioButton one,two,three;
		TextView tv=(TextView) findViewById(R.id.SpaceForQuestion);
		one=(RadioButton) findViewById(R.id.radio0);
		two=(RadioButton) findViewById(R.id.radio1);
		three=(RadioButton) findViewById(R.id.radio2);


		tv.setText(mainQ);
		one.setText(new String(intent.getStringExtra("one")));
		two.setText(new String(intent.getStringExtra("two")));
		three.setText(new String(intent.getStringExtra("three")));
		trueAns=Integer.parseInt(intent.getStringExtra("true").toString());


	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		

		  SharedPreferences pref=getSharedPreferences("Questions",0);
		  for(int i=0;i<2;i++)  
		  {  
			  String tv=pref.getString(String.valueOf(i),null);
		    if (tv!=null){
		        draw[i]=Integer.parseInt(tv);

		    }
		  }
		  
//		  Toast drawexam=Toast.makeText(this,String.valueOf( draw[0])+"  "+String.valueOf( draw[1]), Toast.LENGTH_SHORT);
//		  drawexam.show();
		Intent intent=getIntent();
		String mainQ=intent.getStringExtra("MainQ");

		RadioButton one,two,three;
		TextView tv=(TextView) findViewById(R.id.SpaceForQuestion);
		one=(RadioButton) findViewById(R.id.radio0);
		two=(RadioButton) findViewById(R.id.radio1);
		three=(RadioButton) findViewById(R.id.radio2);


		tv.setText(mainQ);
		one.setText(new String(intent.getStringExtra("one")));
		two.setText(new String(intent.getStringExtra("two")));
		three.setText(new String(intent.getStringExtra("three")));
		trueAns=Integer.parseInt(intent.getStringExtra("true").toString());

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

	public void goCheck(View v){
		RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup1);


		if (rg.getCheckedRadioButtonId()!=-1) 
		{

			for (int i = 0; i < rg.getChildCount(); i++) 
			{
				rg.getChildAt(i).setEnabled(false);
			}
			RadioButton rb1=(RadioButton) findViewById(R.id.radio0);
			RadioButton rb2=(RadioButton) findViewById(R.id.radio1);
			RadioButton rb3=(RadioButton) findViewById(R.id.radio2);
			int myAns=0;


			if(rb1.isChecked())
				myAns=1;
			if(rb2.isChecked())
				myAns=2;
			if(rb3.isChecked())
				myAns=3;

			if(trueAns==myAns) 
			{
				switch (trueAns) {
				case 1:
					rb1.setBackgroundColor(Color.GREEN);
					break;
				case 2:
					rb2.setBackgroundColor(Color.GREEN);
					break;
				case 3:
					rb3.setBackgroundColor(Color.GREEN);
					break;

				default:
					break;
				}

				Toast t=Toast.makeText(this, "Вярно",Toast.LENGTH_SHORT);
				t.show();
			}
			else
			{
				switch (trueAns) {
				case 1:
					rb1.setBackgroundColor(Color.GREEN);
					break;

				case 2:
					rb2.setBackgroundColor(Color.GREEN);
					break;
				case 3:
					rb3.setBackgroundColor(Color.GREEN);
					break;

				default:
					break;
				}
				switch (myAns) {
				case 1:
					rb1.setBackgroundColor(Color.RED);
					break;

				case 2:
					rb2.setBackgroundColor(Color.RED);
					break;
				case 3:
					rb3.setBackgroundColor(Color.RED);
					break;

				default:
					break;
				}
				Toast f=Toast.makeText(this, "Грешно",Toast.LENGTH_SHORT);
				f.show();

			}
		} 

		else 
		{
			Toast t=Toast.makeText(this, "Маркирай отговор!",Toast.LENGTH_SHORT);
			t.show();
		}

	}


	public void goNext(View v){

		RadioGroup rg=(RadioGroup) findViewById(R.id.radioGroup1);

		if(rg.getCheckedRadioButtonId()!=-1)
		{	
			RadioButton rb1=(RadioButton) findViewById(R.id.radio0);
			RadioButton rb2=(RadioButton) findViewById(R.id.radio1);
			RadioButton rb3=(RadioButton) findViewById(R.id.radio2);
			int myAns=0;

			if(rb1.isChecked())
				myAns=1;
			if(rb2.isChecked())
				myAns=2;
			if(rb3.isChecked())
				myAns=3;

			if(trueAns==myAns) {
				arr[count]=true;
				count++;
			}
			else{
				arr[count]=false;
				count++;
			}
			if(count<3)
			{
				Intent i = new Intent(this,Exam.class);
				

				switch (draw[count-1]) {
				case 1:
					i.putExtra("MainQ", "През коя година е битката при Русокастро между Иван-Александър и Андроник III Палеолог? ");
					i.putExtra("one", "1549г");
					i.putExtra("two", "1393г");
					i.putExtra("three", "1332г");
					i.putExtra("true", "3");
					break;
				case 2:
					i.putExtra("MainQ", "Кое от предприятията не е бургаско?");
					i.putExtra("one", "Промет АД");
					i.putExtra("two", "Солвей Соди");
					i.putExtra("three", "Лукойл Нефтохим");
					i.putExtra("true", "2");
					break;
				case 3:
					i.putExtra("MainQ", "Как се казва драматичният театър в Бургас?");
					i.putExtra("one", "Петко Славейков");
					i.putExtra("two", "Петя Дубарова");
					i.putExtra("three", "Адриана Будевска");
					i.putExtra("true", "1");
					break;
				case 4:
					i.putExtra("MainQ", "Кое е най–старото училище в Бургас създадено през далечната 1869 г.?");
					i.putExtra("one", "Немската езикова гимназия „Гьоте“");
					i.putExtra("two", "СОУ „Св. св. Кирил и Методий“");
					i.putExtra("three", "Природо-математическата гимназия „Акад. Н. Обрешков“");
					i.putExtra("true", "2");
					break;
				}				
				startActivity(i);	
			}

			else{

				Intent i = new Intent(this,FinalScreen.class);
				int res=0;
				for (int j = 0; j < arr.length; j++) {
					if(arr[j]==true)
						res++;
				}
				i.putExtra("Result",Integer.toString(res));
				startActivity(i);

			}
		}
		else
		{

			Toast t=Toast.makeText(this, "Маркирай отговор!",Toast.LENGTH_SHORT);
			t.show();
		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.exam, menu);
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

