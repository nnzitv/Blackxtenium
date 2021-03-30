package com.so.debelzaak.evolution.blackxtenium;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.content.*;
import java.io.File;
import android.webkit.*;

public class MainPreview extends Activity{
	
	WebView txt2;
	String ttpasta;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
		
		txt2 = findViewById(R.id.web_view2);
		
		Intent intent = getIntent();
		ttpasta = intent.getExtras().getString("paster");
		
		WebSettings webSettings = txt2.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(false);
		webSettings.setAllowFileAccess(true);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setSavePassword(false);
		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		
		
		File sdcard = Environment.getExternalStorageDirectory();
		
		File filex = new File(sdcard + "/BlackXtenium_PJ/" + ttpasta, ttpasta + ".html");

		txt2.loadUrl("file://"+filex);
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		finish();
	}
}
