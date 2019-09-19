package com.example.calculateinterest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
public class MainActivity extends Activity
{
  private EditText ratetxt;
  private EditText deposittxt;
  private EditText yearstxt;
  private TextView accumtxt;
  private Button calcbtn,clearbtn;
  private double rate = 0;
  private double deposit = 0;
  private double years = 0;
  private NumberFormat nf;
  /** Called when the activity is first created. */
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MediaPlayer mySong = MediaPlayer.create(MainActivity.this,R.raw.sleepaway);
    mySong.start();
    initControls();
  }
  private void initControls()
  {
    ratetxt= (EditText)findViewById(R.id.ratetxt1);
    deposittxt= (EditText)findViewById(R.id.deposittxt1);
    yearstxt= (EditText)findViewById(R.id.yearstxt1);
    accumtxt=(TextView)findViewById(R.id.accumtxt1);
    calcbtn= (Button)findViewById(R.id.calcbtn1);
    clearbtn= (Button)findViewById(R.id.clearbtn1);
    calcbtn.setOnClickListener(new Button.OnClickListener() { public       void onClick (View v){ calculate(); }});
    clearbtn.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ clear(); }});
    nf = NumberFormat.getCurrencyInstance();
  }
  private void calculate()
  {
    rate =Double.parseDouble(ratetxt.getText().toString());
    deposit =Double.parseDouble(deposittxt.getText().toString());
    years =Double.parseDouble(yearstxt.getText().toString());
    for (int i = 1; i <= years; i++)
	  deposit += deposit * rate/100;
    accumtxt.setText(nf.format(deposit));
  }
  private void clear()
  {
    ratetxt.setText("");
    deposittxt.setText("");
    yearstxt.setText("");
    accumtxt.setText("");
  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}

