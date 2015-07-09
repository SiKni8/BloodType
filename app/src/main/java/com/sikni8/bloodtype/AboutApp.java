package com.sikni8.bloodtype;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AboutApp extends BaseActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutapp);
        setupActionBar();
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Regular.ttf");
        Typeface typefaceLight = Typeface.createFromAsset(this.getAssets(), "fonts/RobotoCondensed-Light.ttf");

        ((TextView) findViewById(R.id.tvAboutHdr)).setTypeface(typeface);
        ((TextView) findViewById(R.id.tvAboutExplain)).setTypeface(typefaceLight);
        ((TextView) findViewById(R.id.tvVersion)).setTypeface(typeface);
        ((TextView) findViewById(R.id.tvVersionInfo)).setTypeface(typefaceLight);
        ((TextView) findViewById(R.id.tvCopyright)).setTypeface(typeface);
        ((TextView) findViewById(R.id.tvCopyrightInfo)).setTypeface(typefaceLight);
        ((TextView) findViewById(R.id.tvContact)).setTypeface(typeface);
        ((TextView) findViewById(R.id.tvContactExplain)).setTypeface(typefaceLight);
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
			default:
				return super.onOptionsItemSelected(item);
		}
		return true;
	}
}