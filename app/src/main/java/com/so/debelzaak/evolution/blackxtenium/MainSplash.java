package com.so.debelzaak.evolution.blackxtenium;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View;
import android.view.View.*;
import android.content.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.view.LayoutInflater;
import android.text.TextUtils;
import java.io.FileOutputStream;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.AdapterView.OnItemClickListener;



public class MainSplash extends Activity{
	
	Button novo, existe;;
	ListView fpasta;
	private ArrayAdapter<String> itensAdapter2;
	SharedPreferences sPreferences = null;
	String beforePasta;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
		
		existe = findViewById(R.id.existe);
		novo = findViewById(R.id.novo);
		fpasta = findViewById(R.id.fpasta);
		
        sPreferences = getSharedPreferences("firstRun", MODE_PRIVATE);
		sPreferences.edit().putBoolean("firstRun", true).apply();
		
		final String sdcard = Environment.getExternalStorageDirectory().getPath();
		File dir = new File(sdcard + "/BlackXtenium_PJ");
		
		if (!dir.exists()) {
			File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/");
			wallpaperDirectory.mkdirs();
		}
		
		File[] directories = dir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					return pathname.isDirectory();
				}
			});
		String[] theNamesOfFiles = new String[directories.length];
		for (int i = 0; i < theNamesOfFiles.length; i++) {
			theNamesOfFiles[i] = directories[i].getName();
		}
		itensAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theNamesOfFiles);
		fpasta.setAdapter(itensAdapter2); 
		
		fpasta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
					beforePasta = itensAdapter2.getItem(position);
					
					Intent intent = new Intent(MainSplash.this, MainScreen.class);
		intent.putExtra("fpassta", beforePasta);
		startActivity(intent);
					
				}
			});
		
		novo.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					
					AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainSplash.this);
					LayoutInflater inflater = MainSplash.this.getLayoutInflater();
					final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
					dialogBuilder.setView(dialogView);

					final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

					dialogBuilder.setTitle("Novo Projeto");
					dialogBuilder.setMessage("Dê um nome pequeno a sua pesquisa.");
					dialogBuilder.setPositiveButton("Vamos lá!", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								String titlu = edt.getText().toString();
								if(TextUtils.isEmpty(titlu)) {
									Toast.makeText(getApplicationContext(), "Não pode ficar vazio!", Toast.LENGTH_LONG).show();
								}else{

									String path = Environment.getExternalStorageDirectory().getPath();
									String fileName = titlu + ".html";
									File file = new File(path +"/BlackXtenium_PJ/" + titlu, fileName);

									if (!file.exists()) {
										File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + titlu + "/");
										wallpaperDirectory.mkdirs();
									}

									String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + titlu + "</title></head><body><p >...</p></body></html>";

									try {
										FileOutputStream out = new FileOutputStream(file);
										byte[] data = html.getBytes();
										out.write(data);
										out.close();
										SharedPreferences msharedpref = getSharedPreferences("msh", MODE_PRIVATE);
										SharedPreferences.Editor editor = msharedpref.edit();
										editor.putString("tpastas",titlu);
										editor.apply();
										sPreferences.edit().putBoolean("firstRun", false).apply();
										Intent inter = new Intent(MainSplash.this, MainActivity.class);
										startActivity(inter);
										finish();
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									} catch (IOException e) {

									}
								}
							}
						});
					dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								dialog.dismiss();
							}
						});
					dialogBuilder.setCancelable(false);
					AlertDialog b = dialogBuilder.create();
					b.show();
					
				}
			});
			
		existe.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					fpasta.setVisibility(View.VISIBLE);
					existe.setText("Projetos");
				}
			});
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.splash_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item:
				AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
				builder1.setTitle("LIBERTAR - Mais Ciência!");
				builder1.setMessage("Tenha em suas mãos um aplicativo que reúne postagens de diversas áreas da ciência.");
				builder1.setCancelable(false);

				builder1.setPositiveButton(
					"Saiba Mais",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
							Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.so.debelzaak.evolution.libertar"));
							startActivity(browserIntent);
						}
					});
					
				builder1.setNegativeButton(
					"Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
						}
					});

				AlertDialog alert11 = builder1.create();
				alert11.show();
				break;
            default:
                return super.onOptionsItemSelected(item);
        }
		return true;
	}
}
