package even.e10;

import android.app.Activity;
import android.content.Intent;
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
  


public class BusRoutes extends Activity implements AdapterView.OnItemSelectedListener {
	String [] buslist={"1","1A","2","3","3A","3B","3C","3D","4","4A","5","6","6A","7","8","9","9A","10","AC1","AC2"};
	Spinner spin;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.busroutes);
		spin = (Spinner) findViewById(R.id.spinner1);  
		ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,buslist);  
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
		spin.setAdapter(aa);
	}
	
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {  

		   } 

	public void clickme(View v) {
		Intent i = new Intent(this, BusRoutesDisplay.class);
		i.putExtra("mykey1", buslist[spin.getSelectedItemPosition()]);  
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
	public void bye(View v){
		onStop();
	}

}


