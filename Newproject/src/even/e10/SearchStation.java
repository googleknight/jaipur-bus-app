package even.e10;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;  
import android.widget.Adapter;
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;  
import android.widget.Spinner;  
import android.widget.TextView;  
  


public class SearchStation extends Activity implements AdapterView.OnItemSelectedListener {
	
	Spinner spin1;
	Spinner spin2;
	DataBaseHelper db;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchstation);
		spin1 = (Spinner) findViewById(R.id.spinner1);
		spin2 = (Spinner) findViewById(R.id.spinner2); 
		loadSpinnerData(spin1);
		loadSpinnerData(spin2);
	}
	  private void loadSpinnerData(Spinner spin) {  
		         db = new DataBaseHelper(getApplicationContext()); 
		        try {
					db.createDataBase();
				} catch (IOException ioe) {
					throw new Error("Unable to create database");
				}
				try {
					db.openDataBase();
				} catch (SQLException sqle) {
					throw sqle;
				}
		          List<String> labels = db.getAllLabelsorderby("stations","bstop");
		     
		          // Creating adapter for spinner  
		          ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, labels);  
		     
		          // Drop down layout style - list view with radio button  
		          dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		     
		          // attaching data adapter to spinner  
		          spin.setAdapter(dataAdapter);  
		      }  

	

	public void clickme(View v) {
		Intent i = new Intent(this,AllRoutes.class);
		i.putExtra("from", ""+spin1.getSelectedItem());  
		i.putExtra("to",""+spin2.getSelectedItem());
		startActivityForResult(i,10);
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

}


