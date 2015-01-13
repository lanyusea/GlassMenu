package info.androidhive.glassmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * Opening menu on tapping on D-pad
	 * */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
			openOptionsMenu();
			return true;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Taking appropriate action on selecting menu item
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.action_about:
			// About menu item selected
			Intent ia = new Intent(MainActivity.this, AboutActivity.class);
			startActivity(ia);
			return true;
		case R.id.action_settings:
			// Settings menu item selected
			Intent is = new Intent(MainActivity.this, SettingsActivity.class);
			startActivity(is);
			return true;
		case R.id.action_quit:
			// Quit menu item selected
			// we'll simply close the app
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
//http://www.androidhive.info/2014/10/how-to-create-google-glass-options-menu/
}
