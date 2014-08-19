package com.example.goaltracker;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

	private EditText  username=null;
	private EditText  password=null;
	//private TextView attempts;
	private Button login;
	int counter = 3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        
        username = (EditText)findViewById(R.id.username_get);
	    password = (EditText)findViewById(R.id.password_get);
	    //attempts = (TextView)findViewById(R.id.textView5);
	    //attempts.setText(Integer.toString(counter));
	    login = (Button)findViewById(R.id.login_button);        
        
    }

    public void login(View view){
 	   if(username.getText().toString().equals("admin") && 
 	      password.getText().toString().equals("admin")){
 		  
 	      //Toast.makeText(getApplicationContext(), "Redirecting...", 
 	      //Toast.LENGTH_SHORT).show();
 	      
 	      Intent LoadMenu = new Intent("com.example.goaltracker.MENU");
 	      startActivity(LoadMenu);
 	   }
 	   
 	   else{
 	      Toast.makeText(getApplicationContext(), "Wrong Credentials",
 	      Toast.LENGTH_SHORT).show();
 	      //attempts.setBackgroundColor(Color.RED);	
 	      counter--;
 	      //attempts.setText(Integer.toString(counter));
 	      if(counter==0){
 	         login.setEnabled(false);
 	      }

 	   }

 	}

	@Override
	protected void onPause() {		//terminate the activity when the activity is paused
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}



	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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

    
    
    
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
            return rootView;
        }
    }
    
    

}
