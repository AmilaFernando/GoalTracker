package com.example.goaltracker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	
	String activityList[] = {"NewGoal","ViewGoals","settings","help","Example2"
			};
	
	String classList[] = {"Add New Goal","View Goals","Settings","Help","Example2"
			};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter <String> (Menu.this, android.R.layout.simple_list_item_1, classList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String pointer = activityList[position];
		try{
			Class temp = Class.forName("com.example.goaltracker." + pointer );
			Intent tempIntent = new Intent(Menu.this,temp);
			startActivity(tempIntent);
		}catch(ClassNotFoundException e){
			
		}
		
	}

	
	
}



