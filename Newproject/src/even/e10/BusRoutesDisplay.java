package even.e10;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BusRoutesDisplay extends Activity {
	public String getname(String s1) {
		if (s1.equals("1"))
			return "one";
		else if (s1.equals("1A"))
			return "onea";
		else if (s1.equals("2"))
			return "two";
		else if (s1.equals("3"))
			return "three";
		else if (s1.equals("3A"))
			return "threea";
		else if (s1.equals("3B"))
			return "threeb";
		else if (s1.equals("3C"))
			return "threec";
		else if (s1.equals("3D"))
			return "threed";
		else if (s1.equals("4"))
			return "four";
		else if (s1.equals("4A"))
			return "foura";
		else if (s1.equals("5"))
			return "five";
		else if (s1.equals("6"))
			return "six";
		else if (s1.equals("6A"))
			return "sixa";
		else if (s1.equals("7"))
			return "seven";
		else if (s1.equals("8"))
			return "eight";
		else if (s1.equals("9"))
			return "nine";
		else if (s1.equals("9A"))
			return "ninea";
		else if (s1.equals("10"))
			return "ten";
		else if (s1.equals("AC1"))
			return "acone";
		else
			return "actwo";
	}

	ListView list1;
	TextView tv;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dispbusroutes);
		Bundle b = getIntent().getExtras();
		String st1 = b.getString("mykey1");
		String tablename = getname(st1);
		DataBaseHelper myDbHelper = new DataBaseHelper(this);
		try {

			myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}

		try {

			myDbHelper.openDataBase();

		} catch (SQLException sqle) {

			throw sqle;

		}

		List<String> labels = myDbHelper.getAllLabels(tablename);
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, labels);
		list1 = (ListView) findViewById(R.id.listView1);
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText("Route of bus "+st1+":");
		list1.setAdapter(dataAdapter);
	}
@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
}
}
