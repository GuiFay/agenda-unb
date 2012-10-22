package com.unb.agenda2;


import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

      
    
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
   
    }
	
  public boolean onCreateOptionsMenu(Menu menu) {
	  super.onCreateOptionsMenu(menu);
	  menu.add(0, R.id.contact_new, 0, R.string.contact_new)
      .setIcon(android.R.drawable.ic_menu_add);
        
        
        Intent intent = new Intent(null, getIntent().getData());
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                new ComponentName(this, MainActivity.class), null, intent, 0, null);

        return true;
        
        
    }
    
  
  public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.contact_new:
          // Launch activity to insert a new item
          startActivity(new Intent(this, Contact_new.class ));
          return true;
      }
      return super.onOptionsItemSelected(item);
  }
  
  
  public boolean onPrepareOptionsMenu(Menu menu) {
      super.onPrepareOptionsMenu(menu);
      final boolean haveItems = getListAdapter().getCount() > 0;

      // If there are any notes in the list (which implies that one of
      // them is selected), then we need to generate the actions that
      // can be performed on the current selection.  This will be a combination
      // of our own specific actions along with any extensions that can be
      // found.
      if (haveItems) {
          // This is the selected item.
          Uri uri = ContentUris.withAppendedId(getIntent().getData(), getSelectedItemId());

          // Build menu...  always starts with the EDIT action...
          Intent[] specifics = new Intent[1];
          specifics[0] = new Intent(Intent.ACTION_EDIT, uri);
          MenuItem[] items = new MenuItem[1];

          // ... is followed by whatever other actions are available...
          Intent intent = new Intent(null, uri);
          intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
          menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0, null, specifics, intent, 0,
                  items);

          // Give a shortcut to the edit action.
          if (items[0] != null) {
              items[0].setShortcut('1', 'e');
          }
      } else {
          menu.removeGroup(Menu.CATEGORY_ALTERNATIVE);
      }

      return true;
  }

  
  
  
  
    
}
