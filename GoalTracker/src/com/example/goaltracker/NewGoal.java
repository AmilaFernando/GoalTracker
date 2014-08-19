/**
 * 
 */
package com.example.goaltracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * @author HP
 *
 */
public class NewGoal extends Activity{

	private EditText  GoalName;
	private EditText  Description;
	private DatePicker StartingDate, EndingDate;
	private TimePicker StartingTime, EndingTime;
	private Button Create;
	

	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String Name = "nameKey"; 
	public static final String Desc = "DescKey"; 
	
	public static final String StartDate = "StartDateKey"; 
	public static final String StartTime = "StartTimeKey";  
	
	public static final String EndDate = "EndDateKey"; 
	public static final String EndTime = "EndTimeKey";

	SharedPreferences sharedpreferences;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_goal);	//set View
		
		initialise();		//initialise components
		
	    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	    //retrieve();

	}


	private void initialise() {		//Initializing elements

		GoalName = (EditText)findViewById(R.id.get_goal_name);
		Description = (EditText)findViewById(R.id.get_description);
		Create = (Button)findViewById(R.id.create_button);     
		StartingDate = (DatePicker) findViewById(R.id.starting_datePicker);
		EndingDate = (DatePicker) findViewById(R.id.end_datePicker);
		StartingTime = (TimePicker) findViewById(R.id.starting_timePicker);
		EndingTime = (TimePicker) findViewById(R.id.end_timePicker);
	}
	
	public void create(View view){
		
		String name  = GoalName.getText().toString();		//get goal name and description
	    String des  = Description.getText().toString();

	    int startingYear  = StartingDate.getYear();			//get starting date and time
	    int startingMonth  = StartingDate.getMonth();
	    int startingDay  = StartingDate.getDayOfMonth();
	    String startingDate = startingDay+"/"+startingMonth+"/"+startingDay;
	    
	    String st  = StartingTime.toString();
	    
	    int endingYear  = EndingDate.getYear();				//get ending date and time
	    int endingMonth  = EndingDate.getMonth();
	    int endingDay  = EndingDate.getDayOfMonth();
	    String endingDate = endingDay+"/"+endingMonth+"/"+endingYear;
	    
	    
	    String et  = EndingTime.toString();
	    
	    Editor editor = sharedpreferences.edit();			//create editor for the shared preference
	    
	    editor.putString(Name, name);	//save name to preferences 
	    editor.putString(Desc, des);	//save description to preferences
	    
	    editor.putString(StartDate,startingDate);	//save starting date and time to preferences
	    editor.putString(StartTime, st);
	    
	    editor.putString(EndDate, endingDate);	//save ending date and time to preferences
	    editor.putString(EndTime, et);
	    
	    editor.commit(); 						//commit changes

	}
	
	
}
