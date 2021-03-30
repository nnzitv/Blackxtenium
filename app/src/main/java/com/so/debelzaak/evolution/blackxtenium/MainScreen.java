package com.so.debelzaak.evolution.blackxtenium;

import android.app.*;
import android.os.*;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.view.View.OnClickListener;
import android.text.Editable;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.*;
import android.view.View;
import android.text.InputType;
import android.view.View.*;
import android.content.*;
import android.database.Cursor;
import android.provider.MediaStore;
import java.io.FileOutputStream;
import java.io.File;
import android.Manifest;
import android.view.Window;
import android.net.Uri;
import android.graphics.BitmapFactory;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import android.text.format.DateFormat;
import android.webkit.*;

public class MainScreen extends Activity{
	
	
	WebView txt;
	String ttpasta;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);
		
		Intent intent = getIntent();
		ttpasta = intent.getExtras().getString("fpassta");
		
		txt = findViewById(R.id.web_view);
		
		WebSettings webSettings = txt.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setSupportZoom(false);
		webSettings.setAllowFileAccess(true);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setSavePassword(false);
		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		
		
		File sdcard = Environment.getExternalStorageDirectory();
		
		File filex = new File(sdcard + "/BlackXtenium_PJ" + "/" + ttpasta,ttpasta + ".html");

		txt.loadUrl("file://"+filex);
	}
	
	
}
