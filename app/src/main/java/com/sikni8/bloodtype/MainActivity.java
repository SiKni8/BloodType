package com.sikni8.bloodtype;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.widget.Toast;

import com.sikni8.bloodtype.ui.DrawerItem;
import com.sikni8.bloodtype.ui.DrawerItemAction;
import com.sikni8.bloodtype.ui.DrawerItemAdapter;
import com.sikni8.bloodtype.ui.DrawerItemType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseNavDrawerActivity {
	
	protected Button bA, bB, bC, bD, bE, bF, bG, bH;
	protected Animation animAlpha;
	protected Button btnMenu, btnLogo;
	private SharedPreferences prefs;
	private SharedPreferences.Editor editor;
	private TextView tvInfo;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private ActionBarDrawerToggle drawerToggle;
    private ListView leftDrawerList;
    private DrawerItemAdapter navigationDrawerAdapter;
    private List<DrawerItem> leftSliderData;
    private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        setupActionBar();

        initDrawer();
		
		bA = (Button) findViewById(R.id.btnA);
		bA.setOnClickListener(pressA);
		
		bB = (Button) findViewById(R.id.btnB);
		bB.setOnClickListener(pressB);
		
		bC = (Button) findViewById(R.id.btnC);
		bC.setOnClickListener(pressC);
		
		bD = (Button) findViewById(R.id.btnD);
		bD.setOnClickListener(pressD);
		
		bE = (Button) findViewById(R.id.btnE);
		bE.setOnClickListener(pressE);
		
		bF = (Button) findViewById(R.id.btnF);
		bF.setOnClickListener(pressF);
		
		bG = (Button) findViewById(R.id.btnG);
		bG.setOnClickListener(pressG);
		
		bH = (Button) findViewById(R.id.btnH);
		bH.setOnClickListener(pressH);
		
		animAlpha = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alphabtn);
		
		tvInfo = (TextView) findViewById(R.id.textView1);
		
		tvInfo.setTypeface(Typeface.createFromAsset(MainActivity.this.getAssets(), "fonts/Roboto-Black.ttf"));
		
		// Set up our Prefs and Editor
		prefs = this.getSharedPreferences("BloodType", Context.MODE_PRIVATE);
		editor = prefs.edit();
	}

    @Override
    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		// Inflate the menu; this adds items to the action bar if it is present.
        // Not used ATM
		// getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
	}
	
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}
	
	View.OnClickListener pressA = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "0");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressB = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "1");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressC = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "2");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressD = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "3");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressE = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "4");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressF = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "5");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressG = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "6");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	View.OnClickListener pressH = new View.OnClickListener() {
		public void onClick(final View v) {
			animAlpha.setAnimationListener(new AnimationListener() { //changed to fade4
	            public void onAnimationStart(Animation animation) {}
	            public void onAnimationRepeat(Animation animation) {}
	            public void onAnimationEnd(Animation animation) {
	            	editor.putString("BloodVal", "7");
					editor.commit();
	    			Intent myIntent = new Intent(MainActivity.this, BloodType.class);
	    			startActivityForResult(myIntent, 0);
	    			overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
	            }
	        });
			v.startAnimation(animAlpha);
		}
	};
	@Override
	public void onAttachedToWindow() { //ensures smooth gradient
	    super.onAttachedToWindow();
	    Window window = getWindow();
	    window.setFormat(PixelFormat.RGBA_8888);
	}

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void initDrawer() {
        leftSliderData = new ArrayList<DrawerItem>();
        leftSliderData.add(new DrawerItem(getResources().getString(R.string.menu_table), R.drawable.ic_assignment_grey600_24dp, DrawerItemType.MENU, DrawerItemAction.BLOOD_CHART));
        leftSliderData.add(new DrawerItem(getResources().getString(R.string.menu_about), R.drawable.ic_info_outline_grey600_24dp, DrawerItemType.MENU, DrawerItemAction.ABOUT));
        leftSliderData.add(new DrawerItem(getResources().getString(R.string.menu_help), R.drawable.ic_help_grey600_24dp, DrawerItemType.MENU, DrawerItemAction.HELP));
        leftSliderData.add(new DrawerItem(getResources().getString(R.string.menu_rate), R.drawable.ic_favorite_outline_grey600_24dp, DrawerItemType.MENU, DrawerItemAction.RATE));

        leftDrawerList = (ListView) findViewById(R.id.left_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerView = findViewById(R.id.left_drawer_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationDrawerAdapter = new DrawerItemAdapter(MainActivity.this, leftSliderData);
        leftDrawerList.setAdapter(navigationDrawerAdapter);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        // Set the list's click listener
        leftDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void selectItem(int position, long id) {
        switch(leftSliderData.get(position).getAction())
        {
            case ABOUT:
                startActivityForResult(new Intent(this, AboutApp.class), 0);
                overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                break;
            case BLOOD_CHART:
                startActivityForResult(new Intent(this, BloodTable.class), 0);
                overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                break;
            case HELP:
                startActivityForResult(new Intent(this, ShowHelp.class), 0);
                overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                break;
            case RATE:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //Try Google play
                intent.setData(Uri.parse("market://details?id=com.sikni8.bloodtype"));
                if (MyStartActivity(intent) == false) {
                    //Market (Google play) app seems not installed, let's try to open a web browser
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?com.sikni8.bloodtype"));
                    if (MyStartActivity(intent) == false) {
                        //Well if this also fails, we have run out of options, inform the user.
                        //let the user know nothing was successful
                    }
                }
                break;
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            leftDrawerList.setItemChecked(position, true);
            selectItem(position, id);
            drawerLayout.closeDrawers();
        }
    }
}