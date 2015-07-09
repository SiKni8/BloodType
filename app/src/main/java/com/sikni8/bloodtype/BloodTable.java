package com.sikni8.bloodtype;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class BloodTable extends BaseActionBarActivity {
	
	File file;
	ProgressDialog barProgressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bloodtable);
		setupActionBar();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.share, menu);

		return true;
	}
	@Override
	public void onAttachedToWindow() { //ensures smooth gradient
	    super.onAttachedToWindow();
	    Window window = getWindow();
	    window.setFormat(PixelFormat.RGBA_8888);
	}

	@Override
	public void onBackPressed() {
	    /// do something on back.
        finish();
        overridePendingTransition (R.anim.right_slide_in, R.anim.right_slide_out);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home: 
				onBackPressed();
				break;
			case R.id.action_save:
				new SaveImageTask().execute(null, null, null);
				break;
			case R.id.action_share:
				Intent share = new Intent(Intent.ACTION_SEND);
				share.setType("image/png");
		        File folder = new File(Environment.getExternalStorageDirectory() + "/Blood Type");
		        file = new File(folder + "/chart.png");
		        if (!folder.exists()) {
		            folder.mkdir();
		        }
				try {
					if (file.exists()) {
						share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
						startActivityForResult(Intent.createChooser(share, "Share Blood Chart"), 1);
					}
					else {
						new SaveImageTask().execute(null, null, null);
						share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
						startActivityForResult(Intent.createChooser(share, "Share Blood Chart"), 1);
					}
				}
				catch (Exception e) {
				    Log.e("BloodTable", "Error sharing blood chart!", e);
				}
		        return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
	public class SaveImageTask extends AsyncTask<Void, Void, Void> {
	     @Override
	     protected Void doInBackground(Void... params) { //Running in background
	    	saveImage();
			return null;
	     }

	     @Override
	     protected  void onPreExecute() { //Activity is on progress
	    	 barProgressDialog = new ProgressDialog(BloodTable.this);
	    	 barProgressDialog.setTitle("Saving Image");
	    	 barProgressDialog.setMessage("Saving Image in progress ...");
	    	 barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	    	 barProgressDialog.show();
	     }

	     @Override
	     protected void onPostExecute(Void v) { //Activity is done...
	    	 barProgressDialog.dismiss();
	     }
	}
	public void saveImage() {
		if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			Log.d("Blood Type", "No SDCARD");
		}
		else {
			File directory = new File(Environment.getExternalStorageDirectory() + "/Blood Type");
			directory.mkdirs();
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chart);
		    String fileName = "chart.png";
		    File dest = new File(directory, fileName);
		    try {
		        FileOutputStream out;
		        out = new FileOutputStream(dest);
		        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
		        out.flush();
		        out.close();
		    } catch (FileNotFoundException e) {
                Log.e("BloodTable", "Error saving blood chart!", e);
		    } catch (IOException e) {
		        Log.e("BloodTable", "Error saving blood chart!", e);
		    }
		}
	}
}