package com.unb.agenda2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unb.agenda2.Entidades.Contato;

public class MainActivity extends Activity{
    private ArrayAdapter<Contato> dataAdapter;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout2);
	ListView a =(ListView) findViewById(R.id.list_agenda);
				  Contato c1 = new Contato(0, "Joao","5555555","maluco@123.com");
		  Contato c2 = new Contato(1, "Maria","99999999","maluca@321.com");
		  Contato.agenda.add(c1);
		  Contato.agenda.add(c2);
		
		  dataAdapter = new ArrayAdapter<Contato>(this,android.R.layout.simple_list_item_1, Contato.agenda);
		  a.setAdapter(dataAdapter);
		
		  // Inserting some contacts for test. these are ONLY for tests, 
		  //TODO: Remove this after the persistence be implemented.

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, R.id.contact_new, 0, R.string.contact_new).setIcon(
				android.R.drawable.ic_menu_add);

		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.contact_new:
			// Launch activity to insert a new item
			startActivity(new Intent("com.unb.agenda2.Contact_new"));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
public void onResume(){
	//a.setAdapter(dataAdapter);
}

}
