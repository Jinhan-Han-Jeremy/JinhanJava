package com.example.calculateinterest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	String classes[] = { "MainActivity","example1"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String mclass = classes[position];
		try{
		Class myClass = Class.forName("com.example.calculateinterest." + mclass);
		Intent myIntent = new Intent(Menu.this,myClass);
		startActivity(myIntent);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}



}
