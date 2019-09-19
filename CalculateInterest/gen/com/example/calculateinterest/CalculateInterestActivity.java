package com.example.calculateinterest;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
public class CalculateInterestActivity extends Activity
{
  private EditText ratetxt;
  private EditText deposittxt;
  private EditText yearstxt;
  private TextView accumtxt;
  private Button calcbtn,clearbtn;
 // private Button clearbtn;
  private double rate = 0;
  private double deposit = 0;
  private double years = 0;
  private NumberFormat nf;
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    initControls();
  }
  private void initControls()
  {
    ratetxt= (EditText)findViewById(R.id.ratetxt);
    deposittxt= (EditText)findViewById(R.id.deposittxt);
    yearstxt= (EditText)findViewById(R.id.yearstxt);
    accumtxt=(TextView)findViewById(R.id.accumtxt);
    calcbtn= (Button)findViewById(R.id.calcbtn);
    clearbtn= (Button)findViewById(R.id.clearbtn);
    calcbtn.setOnClickListener(new Button.OnClickListener() { public void onClick (View v){ calculate(); }});
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
}
