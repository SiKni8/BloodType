package com.sikni8.bloodtype;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BloodType extends BaseActionBarActivity {
	
	private SharedPreferences prefs;
	private String strAndroidInfo;
	private int inPrefConv;
	String[] strBloodType = {
		"A+",
		"O+",
		"B+",
		"AB+",
		"A-",
		"O-",
		"B-",
		"AB-"
	};
	private TextView tvB, tvD;
	private TextView tvG, tvR;
	private TextView tvA, tvC;
	protected Button bBack;
	Animation animAnticipateOvershoot, animAnticipateOvershootX;
	
	private Runnable task = new Runnable() { 
        public void run() {
        	//run the animated task
        }
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bloodtype);
        setupActionBar();
        Typeface tfBlack = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Black.ttf");
        Typeface tfBold = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Bold.ttf");
        Typeface tfRegular = Typeface.createFromAsset(this.getAssets(), "fonts/Roboto-Regular.ttf");
		
		prefs = this.getSharedPreferences("BloodType", Context.MODE_PRIVATE);
		
		strAndroidInfo = prefs.getString("BloodVal", "");
		inPrefConv = Integer.parseInt(strAndroidInfo);
		
		tvG = (TextView) findViewById(R.id.tvGiveTo);
        tvG.setTypeface(tfRegular);
		tvR = (TextView) findViewById(R.id.tvReceiveFrom);
        tvR.setTypeface(tfRegular);
		
		tvB = (TextView) findViewById(R.id.tvBloodDetail);
		tvB.setText(strBloodType[inPrefConv]);
        tvB.setTypeface(tfBlack);
		
		tvD = (TextView) findViewById(R.id.tvData);
		tvD.setTypeface(tfBold);
		
		tvA = (TextView) findViewById(R.id.tvGive);
        tvA.setTypeface(tfBold);
		tvC = (TextView) findViewById(R.id.tvReceive);
        tvC.setTypeface(tfBold);

		animAnticipateOvershootX = AnimationUtils.loadAnimation(this, R.anim.overshootx);
		tvC.startAnimation(animAnticipateOvershootX);
		tvA.startAnimation(animAnticipateOvershootX);
		
		//Handler handler = new Handler();
        //handler.postDelayed(task, 1000);
		
		PerformBloodCheck(inPrefConv);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	public void PerformBloodCheck(int varSent) {
		//Toast.makeText(getApplicationContext(), strBloodType[varSent], Toast.LENGTH_SHORT).show();
		if (varSent == 0) {
			tvG.setText("" + strBloodType[varSent] + ", " + strBloodType[4] + "");
			tvR.setText("" + strBloodType[varSent] + ", " + strBloodType[4] + ", " + strBloodType[1] + ", " + strBloodType[5] + "");
		}
		if (varSent == 1) {
			tvG.setText("" + strBloodType[1] + ", " + strBloodType[varSent] + ", " + strBloodType[2] + ", " + strBloodType[3] + "");
			tvR.setText("" + strBloodType[1] + ", " + strBloodType[5] + "");
		}
		if (varSent == 2) {
			tvG.setText("" + strBloodType[2] + ", " + strBloodType[3] + "");
			tvR.setText("" + strBloodType[2] + ", " + strBloodType[6] + ", " + strBloodType[1] + ", " + strBloodType[5] + "");
		}
		if (varSent == 3) {
			tvG.setText("" + strBloodType[3] + "");
			tvR.setText(getResources().getText(R.string.everyone));
		}
		if (varSent == 4) {
			tvG.setText("" + strBloodType[varSent] + ", " + strBloodType[4] + ", " + strBloodType[3] + ", " + strBloodType[7] + "");
			tvR.setText("" + strBloodType[4] + ", " + strBloodType[5] + "");
		}
		if (varSent == 5) {
			tvG.setText(getResources().getText(R.string.everyone));
			tvR.setText("" + strBloodType[5] + "");
		}
		if (varSent == 6) {
			tvG.setText("" + strBloodType[2] + ", " + strBloodType[6] + ", " + strBloodType[3] + ", " + strBloodType[7] + "");
			tvR.setText("" + strBloodType[6] + ", " + strBloodType[5] + "");
		}
		if (varSent == 7) {
			tvG.setText("" + strBloodType[3] + ", " + strBloodType[7] + "");
			tvR.setText("" + strBloodType[7] + ", " + strBloodType[4] + ", " + strBloodType[6] + ", " + strBloodType[5] + "");
		}
	}
    
	@Override
	public void onBackPressed() {
	    /// do something on back.
        finish();
        overridePendingTransition (R.anim.right_slide_in, R.anim.right_slide_out);
	    return;
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.v("RESUME", "ACTIVITY RESUMED");
	}

	@Override
	public void onAttachedToWindow() { //ensures smooth gradient
	    super.onAttachedToWindow();
	    Window window = getWindow();
	    window.setFormat(PixelFormat.RGBA_8888);
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