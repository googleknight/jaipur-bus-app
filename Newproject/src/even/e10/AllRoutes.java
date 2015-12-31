package even.e10;

import java.io.IOException;
import java.util.ArrayList;
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

public class AllRoutes extends Activity {
	String [] buslist={"1","1A","2","3","3A","3B","3C","3D","4","4A","5","6","6A","7","8","9","9A","10","AC1","AC2"};
	ListView list1;
	TextView tv;
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

	public ArrayList<String> search(String from,String to,DataBaseHelper myDbHelper){
		int count=1;

		
		int fromflag=0,toflag=0;
		
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<buslist.length;i++)
		{
			List<String> labels = myDbHelper.getAllLabels(getname(buslist[i]));
			fromflag=0;toflag=0;
			for(int j=0;j<labels.size();j++)
			{
				if(from.equalsIgnoreCase(""+labels.get(j)))
						fromflag=1;
				if(to.equalsIgnoreCase(""+labels.get(j)))
						toflag=1;		
			}
			if(fromflag==1 && toflag!=1)
			{
				for(int k=0;k<buslist.length;k++)
				{
					int flag=0;
					List<String> others = myDbHelper.getAllLabels(getname(buslist[k]));
					for(int j=0;j<others.size();j++)
					{
						if(to.equalsIgnoreCase(""+others.get(j)))
							{flag=1;break;}
					}
					if(flag==1)
					{
						for(int j=0;j<others.size();j++)
						{
							for(int l=0;l<labels.size();l++)
							{
								if((""+labels.get(l)).equalsIgnoreCase(""+others.get(j)))
								{
									list.add("Route "+count+":\nTake bus "+buslist[i]+" from "+from+" to "+others.get(j)+" then take bus "+buslist[k]+" to "+to);
									count++;flag=0;break;
								}
								
							}
							if(flag==0)break;
						}
					}
									
				}
			}	
			if(fromflag==1 && toflag==1)
			{
				
				list.add("Route "+count+":\nTake bus "+buslist[i]+" from "+from+" to "+to);
				count++;
			}
			
		}
		if(count==1)
			list.add("No buses available between these stops");
		return list; 
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dispallroutes);
		Bundle b = getIntent().getExtras();
		String from = b.getString("from");
		String to=b.getString("to");
		DataBaseHelper myDbHelper = new DataBaseHelper(this);
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, search(from,to,myDbHelper));
		list1 = (ListView) findViewById(R.id.listView1);
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText("From "+from+" to "+to);
		list1.setAdapter(dataAdapter);
	}
@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
}

}
