package com.so.debelzaak.evolution.blackxtenium;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.*;
import android.content.*;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.annotation.NonNull;
import android.content.pm.PackageManager;
import android.Manifest;

import android.content.Intent;

public class Splash_screen extends Activity{
	
	private final int SPLASH_DISPLAY_LENGTH = 2000;
	private static int STORAGE_PERMISSION_CODE = 999;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
	
		new Handler().postDelayed(new Runnable(){
				@Override
				public void run() {
					if (android.os.Build.VERSION.SDK_INT > 23 || android.os.Build.VERSION.SDK_INT == 23) {
					requestStoragePermission();
					}else{
						Intent inter = new Intent(Splash_screen.this, MainActivity.class);
						startActivity(inter);
						finish();
					}
				}
			}, SPLASH_DISPLAY_LENGTH);
	}
	
	private void requestStoragePermission(){
		if (ActivityCompat.shouldShowRequestPermissionRationale(this, 
																android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {

        }

        ActivityCompat.requestPermissions(this, 
										  new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
										  STORAGE_PERMISSION_CODE);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, 
										   @NonNull String[] permissions, 
										   @NonNull int[] grantResults) {

		if(requestCode == STORAGE_PERMISSION_CODE){
			if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
				Intent inter = new Intent(Splash_screen.this, MainActivity.class);
				startActivity(inter);
				finish();
			}
			else{
				AlertDialog.Builder builder1 = new AlertDialog.Builder(Splash_screen.this);
				builder1.setTitle("∆!!!");
				builder1.setMessage("O BlackXtenium precisa de acesso ao armazenamento para savar projetos, o aplicativo não irá iniciar se você não permitir!");
				builder1.setCancelable(false);

				builder1.setPositiveButton(
					"Permitir",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							requestStoragePermission();
						}
					});

				AlertDialog alert11 = builder1.create();
				alert11.show(); 
			}
		}
	}
}
