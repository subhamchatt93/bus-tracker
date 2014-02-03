package info.pesit.googlemapsv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class Homepage extends Activity {
	private Spinner spinner1, spinner2,spinner3;
	  private Button btnSubmit;
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homepage);
	 
		//addItemsOnSpinner2();
		addListenerOnButton();
		//addListenerOnSpinnerItemSelection();
	  }
	  /*public void addItemsOnSpinner2() {
		  
			spinner2 = (Spinner) findViewById(R.id.spinner2);
			List<String> list = new ArrayList<String>();
			list.add("list 1");
			list.add("list 2");
			list.add("list 3");
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinner2.setAdapter(dataAdapter);
		  }
		 
		  public void addListenerOnSpinnerItemSelection() {
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		  }
		 */
		  // get the selected dropdown list value
		  public void addListenerOnButton() {
		 
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner2 = (Spinner) findViewById(R.id.spinner2);
			spinner3 = (Spinner) findViewById(R.id.spinner3);
			btnSubmit = (Button) findViewById(R.id.button1);
		 
			btnSubmit.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
				  submitButtonAction();
			  }
		 
			});
		  }
		  void submitButtonAction()
		    {
		    	Intent next= new Intent(Homepage.this,MainActivity.class);
		    	startActivity(next);
		    }
		}
