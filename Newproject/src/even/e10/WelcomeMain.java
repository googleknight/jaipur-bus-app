package even.e10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeMain extends Activity {
	
	int rc = 10;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
	
	}

	public void busroute(View v) {
	
		Intent i = new Intent(this, BusRoutes.class);
	
		startActivityForResult(i, rc);
	}
	
	public void searchstations(View v) {
		
		Intent i = new Intent(this, SearchStation.class);
		startActivityForResult(i, rc);
	}
	
}



