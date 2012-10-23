package com.unb.agenda2;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
		menu.add(0, R.id.contact_new, 0, R.string.contact_new).setIcon(android.R.drawable.ic_menu_add);

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
	
	
	/*
	 * 
	 * testes de clicar no item da lista
	 * 
	 * 	
	protected void onListItemClick(ListView l, View v, int position, long id) {
	        Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);
	        
	        String action = getIntent().getAction();
	        if (Intent.ACTION_PICK.equals(action) || Intent.ACTION_GET_CONTENT.equals(action)) {
	            // The caller is waiting for us to return a note selected by
	            // the user.  The have clicked on one, so return it now.
	            setResult(RESULT_OK, new Intent().setData(uri));
	        } else {
	            // Launch activity to view/edit the currently selected item
	            startActivity(new Intent("com.unb.agenda2.Contact_edit_del"));
	        }
	    }
	
	*/
	
//public void onResume(){
	//a.setAdapter(dataAdapter);
//}

}
