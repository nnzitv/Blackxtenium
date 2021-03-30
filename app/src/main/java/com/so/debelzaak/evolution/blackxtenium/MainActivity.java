package com.so.debelzaak.evolution.blackxtenium;

import android.app.*;
import android.os.*;
import android.view.LayoutInflater;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.text.TextWatcher;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.CompoundButton;
import android.view.View.OnClickListener;
import android.text.Editable;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.*;
import android.view.View;
import android.support.v4.app.ActivityCompat;
import android.support.annotation.NonNull;
import android.Manifest;
import android.text.InputType;
import android.view.View.*;
import android.content.*;
import java.util.Timer;
import android.view.MenuItem;
import android.view.Menu;
import java.util.TimerTask;
import android.database.Cursor;
import android.provider.MediaStore;
import java.io.FileOutputStream;
import java.io.File;
import android.view.Window;
import android.net.Uri;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;

import android.content.pm.PackageManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.text.format.DateFormat;

public class MainActivity extends Activity{
	
	CheckBox cb1, cb2, cb3, cb4, cb5;
	Button btnsalvar;
	ImageView mainImageView, mainImageView2, mainImageView3;
	String hipotese, uida;
	TextView mais;
	LinearLayout mainLinearLayout, mainLinearLayout2, mainLinearLayout3, mainLinearLayout4, mainLinearLayout5;
	EditText mainEditText, mainEditText2, mainEditText3, mainEditText4, mainEditText5, mainEditText6, mainEditText7, mainEditText8, mainEditText9;

	private static int LOAD_IMAGE1 = 1;
	private static int LOAD_IMAGE2 = 444;
	private static int LOAD_IMAGE3 = 777;
	SharedPreferences sPreferences = null;
	SharedPreferences checkbox1 = null;
	SharedPreferences checkbox2 = null;
	SharedPreferences checkbox3 = null;
	SharedPreferences checkbox4 = null;
	SharedPreferences checkbox5 = null;
	String observe, experi, interpr;
	
	String EditText1, EditText2, EditText3, EditText4, EditText5, EditText6, EditText7, EditText8, EditText9;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mainImageView3 = findViewById(R.id.mainImageView3);
		mainImageView2 = findViewById(R.id.mainImageView2);
		mainImageView = findViewById(R.id.mainImageView);
		mainLinearLayout = findViewById(R.id.mainLinearLayout);
		mainLinearLayout2 = findViewById(R.id.mainLinearLayout2);
		mainLinearLayout3= findViewById(R.id.mainLinearLayout3);
		mainLinearLayout4= findViewById(R.id.mainLinearLayout4);
		mainLinearLayout5= findViewById(R.id.mainLinearLayout5);
		mais= findViewById(R.id.mais);
		btnsalvar= findViewById(R.id.btnsalvar);
		cb1= findViewById(R.id.checkBox);
		cb2= findViewById(R.id.checkBox2);
		cb3= findViewById(R.id.checkBox3);
		cb4= findViewById(R.id.checkBox4);
		cb5= findViewById(R.id.checkBox5);
		mainEditText = findViewById(R.id.mainEditText);
		mainEditText2 = findViewById(R.id.mainEditText2);
		mainEditText3 = findViewById(R.id.mainEditText3);
		mainEditText4 = findViewById(R.id.mainEditText4);
		mainEditText5 = findViewById(R.id.mainEditText5);
		mainEditText6 = findViewById(R.id.mainEditText6);
		mainEditText7 = findViewById(R.id.mainEditText7);
		mainEditText8 = findViewById(R.id.mainEditText8);
		mainEditText9 = findViewById(R.id.mainEditText9);
		
		sPreferences = getSharedPreferences("firstRun", MODE_PRIVATE);
		checkbox1 = getSharedPreferences("checkbo1", MODE_PRIVATE);
		checkbox2 = getSharedPreferences("checkbo2", MODE_PRIVATE);
		checkbox3 = getSharedPreferences("checkbo3", MODE_PRIVATE);
		checkbox4 = getSharedPreferences("checkbo4", MODE_PRIVATE);
		checkbox5 = getSharedPreferences("checkbo5", MODE_PRIVATE);
		
		SharedPreferences prefs = this.getSharedPreferences("msh", Context.MODE_PRIVATE);
        uida = prefs.getString("tpastas", "");
		SharedPreferences prefs2 = this.getSharedPreferences("editos", Context.MODE_PRIVATE);
		EditText1 = prefs2.getString("mEditText1", "");
		EditText2 = prefs2.getString("mEditText2", "");
		EditText3 = prefs2.getString("mEditText3", "");
		EditText4 = prefs2.getString("mEditText4", "");
		EditText5 = prefs2.getString("mEditText5", "");
		EditText6 = prefs2.getString("mEditText6", "");
		EditText7 = prefs2.getString("mEditText7", "");
		EditText8 = prefs2.getString("mEditText8", "");
	    EditText9 = prefs2.getString("mEditText9", "");
		
	
		if(TextUtils.isEmpty(EditText1)) {
			}else{
			mainEditText.setText(EditText1);
		}
		
		if(TextUtils.isEmpty(EditText2)) {
		}else{
			mainEditText2.setText(EditText2);
		}
		
		if(TextUtils.isEmpty(EditText3)) {
		}else{
			mainEditText3.setText(EditText3);
		}
		
		if(TextUtils.isEmpty(EditText4)) {
		}else{
			mainEditText4.setText(EditText4);
		}
		
		if(TextUtils.isEmpty(EditText5)) {
		}else{
			mainEditText5.setText(EditText5);
		}
		
		if(TextUtils.isEmpty(EditText6)) {
		}else{
			mainEditText6.setText(EditText6);
		}
		
		if(TextUtils.isEmpty(EditText7)) {
		}else{
			mainEditText7.setText(EditText7);
		}
		
		if(TextUtils.isEmpty(EditText8)) {
		}else{
			mainEditText8.setText(EditText8);
		}
		
		if(TextUtils.isEmpty(EditText9)) {
		}else{
			mainEditText9.setText(EditText9);
		}
		
		mainEditText.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
				
				String mEditText1 = s.toString();
				SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor = msharedpref.edit();
				editor.putString("mEditText1",mEditText1);
				editor.apply();
					
				}
			});
			
		mainEditText2.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText2 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText2",mEditText2);
						editor.apply();
				}
			});
			
		mainEditText3.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText3 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText3",mEditText3);
						editor.apply();
				}
			});
			
		mainEditText4.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText4 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText4",mEditText4);
						editor.apply();
				}
			});
			
		mainEditText5.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText5 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText5",mEditText5);
						editor.apply();
					}
			});
			
		mainEditText6.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText6 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText6",mEditText6);
						editor.apply();
	               }
			});
			
		mainEditText7.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText7 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText7",mEditText7);
						editor.apply();
				}
			});
			
		mainEditText8.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText8 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText8",mEditText8);
						editor.apply();
					}
			});
			
		mainEditText9.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {}
				@Override
				public void afterTextChanged(final Editable s) {
					
						String mEditText9 = s.toString();
						SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
						SharedPreferences.Editor editor = msharedpref.edit();
						editor.putString("mEditText9",mEditText9);
						editor.apply();
				}
			});
		
		String sdCardDirectory = Environment.getExternalStorageDirectory().getPath();
		String imageNameForSDCard = "img_observado" + ".jpg";
		File file = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard);

		if (file.exists()) {
			Bitmap bitmap = BitmapFactory.decodeFile(sdCardDirectory +"/BlackXtenium_PJ/" + uida + "/" + imageNameForSDCard);
			mainImageView.setImageBitmap(bitmap);
		}
		
		String imageNameForSDCard2 = "img_experimentos" + ".jpg";
		File file2 = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard2);

		if (file2.exists()) {
			Bitmap bitmap2 = BitmapFactory.decodeFile(sdCardDirectory +"/BlackXtenium_PJ/" + uida + "/" + imageNameForSDCard2);
			mainImageView2.setImageBitmap(bitmap2);
		}
		
		String imageNameForSDCard3 = "img_interpretacao" + ".jpg";
		File file3 = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard3);

		if (file3.exists()) {
			Bitmap bitmap3 = BitmapFactory.decodeFile(sdCardDirectory +"/BlackXtenium_PJ/" + uida + "/" + imageNameForSDCard3);
			mainImageView3.setImageBitmap(bitmap3);
		}
		
		mainImageView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, LOAD_IMAGE1);
				}
			});
			
		mainImageView2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, LOAD_IMAGE2);
				}
			});
			
		mainImageView3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(i, LOAD_IMAGE3);
				}
			});
		
		 mais.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
				 AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
			     builder1.setTitle("M.5.H");
				 builder1.setMessage("Liste até 5 hipóteses e ao final de sua pesquisa marque a mais aceita.");
				 builder1.setCancelable(false);
											
				 builder1.setPositiveButton(
				 "OK",
				 new DialogInterface.OnClickListener() {
				 public void onClick(DialogInterface dialog, int id) {
				 dialog.cancel();
				 }
				});

				AlertDialog alert11 = builder1.create();
				alert11.show();
					}
			});
			
		btnsalvar.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
					builder1.setTitle("Quer mesmo finalizar?");
					builder1.setMessage("Ao finalizar não haverá mais a opção de editar. Para ver como está ficando a sua pesquisa, clique em preview no menu acima!");
					builder1.setCancelable(false);

					builder1.setPositiveButton(
						"Sim, Finalizar",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();
								saveHtmlFile();
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
				}
			});
		
		cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(cb1.isChecked()){
						cb2.setChecked(false);
						cb3.setChecked(false);
						cb4.setChecked(false);
						cb5.setChecked(false);
						mainLinearLayout2.setVisibility(View.GONE);
						mainLinearLayout3.setVisibility(View.GONE);
						mainLinearLayout4.setVisibility(View.GONE);
						mainLinearLayout5.setVisibility(View.GONE);
						mainEditText2.setVisibility(View.GONE);
						mainEditText3.setVisibility(View.GONE);
						mainEditText4.setVisibility(View.GONE);
						mainEditText5.setVisibility(View.GONE);
						checkbox1.edit().putBoolean("checkbo1", true).apply();
						checkbox2.edit().putBoolean("checkbo2", false).apply();
						checkbox3.edit().putBoolean("checkbo3", false).apply();
						checkbox4.edit().putBoolean("checkbo4", false).apply();
						checkbox5.edit().putBoolean("checkbo5", false).apply();
						}else{
						checkbox1.edit().putBoolean("checkbo1", false).apply();
						vertds();
					}
				}
			});
			
		cb2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(cb2.isChecked()){
						cb1.setChecked(false);
						cb3.setChecked(false);
						cb4.setChecked(false);
						cb5.setChecked(false);
						mainLinearLayout.setVisibility(View.GONE);
						mainLinearLayout3.setVisibility(View.GONE);
						mainLinearLayout4.setVisibility(View.GONE);
						mainLinearLayout5.setVisibility(View.GONE);
						mainEditText.setVisibility(View.GONE);
						mainEditText3.setVisibility(View.GONE);
						mainEditText4.setVisibility(View.GONE);
						mainEditText5.setVisibility(View.GONE);
						checkbox1.edit().putBoolean("checkbo1", false).apply();
						checkbox2.edit().putBoolean("checkbo2", true).apply();
						checkbox3.edit().putBoolean("checkbo3", false).apply();
						checkbox4.edit().putBoolean("checkbo4", false).apply();
						checkbox5.edit().putBoolean("checkbo5", false).apply();
					}else{
						checkbox2.edit().putBoolean("checkbo2", false).apply();
						vertds();
					}
				}
			});
			
		cb3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(cb3.isChecked()){
						cb2.setChecked(false);
						cb1.setChecked(false);
						cb4.setChecked(false);
						cb5.setChecked(false);
						mainLinearLayout2.setVisibility(View.GONE);
						mainLinearLayout.setVisibility(View.GONE);
						mainLinearLayout4.setVisibility(View.GONE);
						mainLinearLayout5.setVisibility(View.GONE);
						mainEditText2.setVisibility(View.GONE);
						mainEditText.setVisibility(View.GONE);
						mainEditText4.setVisibility(View.GONE);
						mainEditText5.setVisibility(View.GONE);
						checkbox1.edit().putBoolean("checkbo1", false).apply();
						checkbox2.edit().putBoolean("checkbo2", false).apply();
						checkbox3.edit().putBoolean("checkbo3", true).apply();
						checkbox4.edit().putBoolean("checkbo4", false).apply();
						checkbox5.edit().putBoolean("checkbo5", false).apply();
					}else{
						checkbox3.edit().putBoolean("checkbo3", false).apply();
						vertds();
					}
				}
			});
			
		cb4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(cb4.isChecked()){
						cb2.setChecked(false);
						cb3.setChecked(false);
						cb1.setChecked(false);
						cb5.setChecked(false);
						mainLinearLayout2.setVisibility(View.GONE);
						mainLinearLayout3.setVisibility(View.GONE);
						mainLinearLayout.setVisibility(View.GONE);
						mainLinearLayout5.setVisibility(View.GONE);
						mainEditText2.setVisibility(View.GONE);
						mainEditText3.setVisibility(View.GONE);
						mainEditText.setVisibility(View.GONE);
						mainEditText5.setVisibility(View.GONE);
						checkbox1.edit().putBoolean("checkbo1", false).apply();
						checkbox2.edit().putBoolean("checkbo2", false).apply();
						checkbox3.edit().putBoolean("checkbo3", false).apply();
						checkbox4.edit().putBoolean("checkbo4", true).apply();
						checkbox5.edit().putBoolean("checkbo5", false).apply();
					}else{
						checkbox4.edit().putBoolean("checkbo4", false).apply();
						vertds();
					}
				}
			});
			
		cb5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(cb5.isChecked()){
						cb2.setChecked(false);
						cb3.setChecked(false);
						cb4.setChecked(false);
						cb1.setChecked(false);
						mainLinearLayout2.setVisibility(View.GONE);
						mainLinearLayout3.setVisibility(View.GONE);
						mainLinearLayout4.setVisibility(View.GONE);
						mainLinearLayout.setVisibility(View.GONE);
						mainEditText2.setVisibility(View.GONE);
						mainEditText3.setVisibility(View.GONE);
						mainEditText4.setVisibility(View.GONE);
						mainEditText.setVisibility(View.GONE);
						checkbox1.edit().putBoolean("checkbo1", false).apply();
						checkbox2.edit().putBoolean("checkbo2", false).apply();
						checkbox3.edit().putBoolean("checkbo3", false).apply();
						checkbox4.edit().putBoolean("checkbo4", false).apply();
						checkbox5.edit().putBoolean("checkbo5", true).apply();
					}else{
						checkbox5.edit().putBoolean("checkbo5", false).apply();
						vertds();
					}
				}
			});
			
    }
	
	private void vertds(){
		mainLinearLayout5.setVisibility(View.VISIBLE);
		mainLinearLayout2.setVisibility(View.VISIBLE);
		mainLinearLayout3.setVisibility(View.VISIBLE);
		mainLinearLayout4.setVisibility(View.VISIBLE);
		mainLinearLayout.setVisibility(View.VISIBLE);
		mainEditText2.setVisibility(View.VISIBLE);
		mainEditText3.setVisibility(View.VISIBLE);
		mainEditText4.setVisibility(View.VISIBLE);
		mainEditText5.setVisibility(View.VISIBLE);
		mainEditText.setVisibility(View.VISIBLE);
	}

	private void saveHtmlFile() {
		String obsevei = mainEditText6.getText().toString();
		String experimentos = mainEditText7.getText().toString();
		String interpretacao = mainEditText8.getText().toString();
		String conclusao = mainEditText9.getText().toString();
		
		if(TextUtils.isEmpty(obsevei)) {
			mainEditText6.setError("Não pode ficar vazio!");
		}else{
			if(TextUtils.isEmpty(experimentos)) {
				mainEditText7.setError("Não pode ficar vazio!");
			}else{
				if(TextUtils.isEmpty(interpretacao)) {
					mainEditText8.setError("Não pode ficar vazio!");
				}else{
					if(TextUtils.isEmpty(conclusao)) {
						mainEditText9.setError("Não pode ficar vazio!");
					}else{
						if(cb1.isChecked()){
							hipotese = mainEditText.getText().toString();
							if(TextUtils.isEmpty(hipotese)) {
								mainEditText.setError("Não pode ficar vazio!");
							}else{
								if (mainImageView.getDrawable() == null){
									observe = " ";
								}else{
									observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
								}
								
								if (mainImageView2.getDrawable() == null){
									experi = " ";
								}else{
									experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
								}
								
								if (mainImageView3.getDrawable() == null){
									interpr = " ";
								}else{
									interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
								}
								
							String path = Environment.getExternalStorageDirectory().getPath();
							String fileName = uida + ".html";
								File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);
							
								if (!file.exists()) {
									File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
									wallpaperDirectory.mkdirs();
								}
								
								String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + uida + "</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br ><br >Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";

							try {
								FileOutputStream out = new FileOutputStream(file);
								byte[] data = html.getBytes();
								out.write(data);
								out.close();
								
								SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
								SharedPreferences.Editor editor = msharedpref.edit();
								editor.clear();
								editor.apply();
								checkbox1.edit().putBoolean("checkbo1", false).apply();
								checkbox2.edit().putBoolean("checkbo2", false).apply();
								checkbox3.edit().putBoolean("checkbo3", false).apply();
								checkbox4.edit().putBoolean("checkbo4", false).apply();
								checkbox5.edit().putBoolean("checkbo5", false).apply();
								Intent inter = new Intent(MainActivity.this, MainSplash.class);
								startActivity(inter);
								finish();
								Toast.makeText(getApplication(), "Salvo!", 
											   Toast.LENGTH_LONG).show();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								
							}
							}
						}else{
							if(cb2.isChecked()){
								hipotese = mainEditText2.getText().toString();
								if(TextUtils.isEmpty(hipotese)) {
									mainEditText2.setError("Não pode ficar vazio!");
								}else{
									if (mainImageView.getDrawable() == null){
										observe = " ";
									}else{
										observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
									}

									if (mainImageView2.getDrawable() == null){
										experi = " ";
									}else{
										experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
									}

									if (mainImageView3.getDrawable() == null){
										interpr = " ";
									}else{
										interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
									}

									String path = Environment.getExternalStorageDirectory().getPath();
									String fileName = uida + ".html";
									File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

									if (!file.exists()) {
										File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
										wallpaperDirectory.mkdirs();
									}

									String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + uida + "</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br ><br >Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
									
									try {
										FileOutputStream out = new FileOutputStream(file);
										byte[] data = html.getBytes();
										out.write(data);
										out.close();

										SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
										SharedPreferences.Editor editor = msharedpref.edit();
										editor.clear();
										editor.apply();
										checkbox1.edit().putBoolean("checkbo1", false).apply();
										checkbox2.edit().putBoolean("checkbo2", false).apply();
										checkbox3.edit().putBoolean("checkbo3", false).apply();
										checkbox4.edit().putBoolean("checkbo4", false).apply();
										checkbox5.edit().putBoolean("checkbo5", false).apply();
										Intent inter = new Intent(MainActivity.this, MainSplash.class);
										startActivity(inter);
										finish();
										Toast.makeText(getApplication(), "Salvo!", 
													   Toast.LENGTH_LONG).show();
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									} catch (IOException e) {

									}
								}
							}else{
								if(cb3.isChecked()){
									hipotese = mainEditText3.getText().toString();
									if(TextUtils.isEmpty(hipotese)) {
										mainEditText3.setError("Não pode ficar vazio!");
									}else{
										if (mainImageView.getDrawable() == null){
											observe = " ";
										}else{
											observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
										}

										if (mainImageView2.getDrawable() == null){
											experi = " ";
										}else{
											experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
										}

										if (mainImageView3.getDrawable() == null){
											interpr = " ";
										}else{
											interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
										}

										String path = Environment.getExternalStorageDirectory().getPath();
										String fileName = uida + ".html";
										File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

										if (!file.exists()) {
											File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
											wallpaperDirectory.mkdirs();
										}

										String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + uida + "</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br ><br >Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
										
										try {
											FileOutputStream out = new FileOutputStream(file);
											byte[] data = html.getBytes();
											out.write(data);
											out.close();

											SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
											SharedPreferences.Editor editor = msharedpref.edit();
											editor.clear();
											editor.apply();
											checkbox1.edit().putBoolean("checkbo1", false).apply();
											checkbox2.edit().putBoolean("checkbo2", false).apply();
											checkbox3.edit().putBoolean("checkbo3", false).apply();
											checkbox4.edit().putBoolean("checkbo4", false).apply();
											checkbox5.edit().putBoolean("checkbo5", false).apply();
											Intent inter = new Intent(MainActivity.this, MainSplash.class);
											startActivity(inter);
											finish();
											Toast.makeText(getApplication(), "Salvo!", 
														   Toast.LENGTH_LONG).show();
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {

										}
									}
								}else{
									if(cb4.isChecked()){
										hipotese = mainEditText4.getText().toString();
										if(TextUtils.isEmpty(hipotese)) {
											mainEditText4.setError("Não pode ficar vazio!");
										}else{
											if (mainImageView.getDrawable() == null){
												observe = " ";
											}else{
												observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
											}

											if (mainImageView2.getDrawable() == null){
												experi = " ";
											}else{
												experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
											}

											if (mainImageView3.getDrawable() == null){
												interpr = " ";
											}else{
												interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
											}

											String path = Environment.getExternalStorageDirectory().getPath();
											String fileName = uida + ".html";
											File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

											if (!file.exists()) {
												File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
												wallpaperDirectory.mkdirs();
											}

											String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + uida + "</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br ><br >Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
											
											try {
												FileOutputStream out = new FileOutputStream(file);
												byte[] data = html.getBytes();
												out.write(data);
												out.close();
	
												SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
												SharedPreferences.Editor editor = msharedpref.edit();
												editor.clear();
												editor.apply();
												checkbox1.edit().putBoolean("checkbo1", false).apply();
												checkbox2.edit().putBoolean("checkbo2", false).apply();
												checkbox3.edit().putBoolean("checkbo3", false).apply();
												checkbox4.edit().putBoolean("checkbo4", false).apply();
												checkbox5.edit().putBoolean("checkbo5", false).apply();
												Intent inter = new Intent(MainActivity.this, MainSplash.class);
												startActivity(inter);
												finish();
												Toast.makeText(getApplication(), "Salvo!", 
															   Toast.LENGTH_LONG).show();
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											} catch (IOException e) {

											}
										}
									}else{
										if(cb5.isChecked()){
											hipotese = mainEditText5.getText().toString();
											if(TextUtils.isEmpty(hipotese)) {
												mainEditText5.setError("Não pode ficar vazio!");
											}else{
												if (mainImageView.getDrawable() == null){
													observe = " ";
												}else{
													observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
												}

												if (mainImageView2.getDrawable() == null){
													experi = " ";
												}else{
													experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
												}

												if (mainImageView3.getDrawable() == null){
													interpr = " ";
												}else{
													interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
												}

												String path = Environment.getExternalStorageDirectory().getPath();
												String fileName = uida + ".html";
												File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

												if (!file.exists()) {
													File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
													wallpaperDirectory.mkdirs();
												}

												String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>" + uida + "</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br ><br >Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
												
												try {
													FileOutputStream out = new FileOutputStream(file);
													byte[] data = html.getBytes();
													out.write(data);
													out.close();

													SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
													SharedPreferences.Editor editor = msharedpref.edit();
													editor.clear();
													editor.apply();
													checkbox1.edit().putBoolean("checkbo1", false).apply();
													checkbox2.edit().putBoolean("checkbo2", false).apply();
													checkbox3.edit().putBoolean("checkbo3", false).apply();
													checkbox4.edit().putBoolean("checkbo4", false).apply();
													checkbox5.edit().putBoolean("checkbo5", false).apply();
													Intent inter = new Intent(MainActivity.this, MainSplash.class);
													startActivity(inter);
													finish();
													Toast.makeText(getApplication(), "Salvo!", 
																   Toast.LENGTH_LONG).show();
												} catch (FileNotFoundException e) {
													e.printStackTrace();
												} catch (IOException e) {

												}
											}
										}else{
											Toast.makeText(getApplication(), "Marque a hipótese aceita!", 
						              		   Toast.LENGTH_LONG).show();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == LOAD_IMAGE1 && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
													   filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			ImageView imageView = (ImageView) findViewById(R.id.mainImageView);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


			Bitmap bmp = BitmapFactory.decodeFile(picturePath);

			try
			{
				String sdCardDirectory = Environment.getExternalStorageDirectory().getPath();
				String imageNameForSDCard = "img_observado" + ".jpg";
				File file = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard);

				if (!file.exists()) {
					File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
					wallpaperDirectory.mkdirs();
				}
				
				FileOutputStream outStream;

				outStream = new FileOutputStream(file);
				bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
				outStream.flush();
				outStream.close();

				Toast.makeText(MainActivity.this, "✓", Toast.LENGTH_LONG).show();
			}
			catch (Exception e) 
			{}
		}
		
		if (requestCode == LOAD_IMAGE2 && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
													   filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			ImageView imageView = (ImageView) findViewById(R.id.mainImageView2);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

			Bitmap bmp = BitmapFactory.decodeFile(picturePath);

			try
			{
				String sdCardDirectory = Environment.getExternalStorageDirectory().getPath();
				String imageNameForSDCard = "img_experimentos" + ".jpg";
				File file = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard);

				if (!file.exists()) {
					File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
					wallpaperDirectory.mkdirs();
				}

				FileOutputStream outStream;

				outStream = new FileOutputStream(file);
				bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
				outStream.flush();
				outStream.close();

				Toast.makeText(MainActivity.this, "✓", Toast.LENGTH_LONG).show();
			}
			catch (Exception e) 
			{}
		}
		
		if (requestCode == LOAD_IMAGE3 && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
													   filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			ImageView imageView = (ImageView) findViewById(R.id.mainImageView3);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

			Bitmap bmp = BitmapFactory.decodeFile(picturePath);

			try
			{
				String sdCardDirectory = Environment.getExternalStorageDirectory().getPath();
				String imageNameForSDCard = "img_interpretacao" + ".jpg";
				File file = new File(sdCardDirectory +"/BlackXtenium_PJ/" + uida, imageNameForSDCard);

				if (!file.exists()) {
					File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
					wallpaperDirectory.mkdirs();
				}

				FileOutputStream outStream;

				outStream = new FileOutputStream(file);
				bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
				outStream.flush();
				outStream.close();

				Toast.makeText(MainActivity.this, "✓", Toast.LENGTH_LONG).show();
			}
			catch (Exception e) 
			{}
		}
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
          getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
				String mEditText1 = mainEditText.getText().toString();
				SharedPreferences msharedpref = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor = msharedpref.edit();
				editor.putString("mEditText1",mEditText1);
				editor.apply();

				String mEditText2 = mainEditText2.getText().toString();
			    SharedPreferences msharedpref2 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor2 = msharedpref2.edit();
				editor2.putString("mEditText2",mEditText2);
				editor2.apply();
						
				String mEditText3 = mainEditText3.getText().toString();
				SharedPreferences msharedpref3 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor3 = msharedpref3.edit();
				editor3.putString("mEditText3",mEditText3);
				editor3.apply();
						
				String mEditText4 = mainEditText4.getText().toString();
				SharedPreferences msharedpref4 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor4 = msharedpref4.edit();
				editor4.putString("mEditText4",mEditText4);
				editor4.apply();
						
			    String mEditText5 = mainEditText5.getText().toString();
				SharedPreferences msharedpref5 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor5 = msharedpref5.edit();
				editor5.putString("mEditText5",mEditText5);
			    editor5.apply();
					
				String mEditText6 = mainEditText6.getText().toString();
				SharedPreferences msharedpref6 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor6 = msharedpref6.edit();
				editor6.putString("mEditText6",mEditText6);
				editor6.apply();
						
			    String mEditText7 = mainEditText7.getText().toString();
				SharedPreferences msharedpref7 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor7 = msharedpref7.edit();
				editor7.putString("mEditText7",mEditText7);
				editor7.apply();
						
				String mEditText8 = mainEditText8.getText().toString();
				SharedPreferences msharedpref8 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor8 = msharedpref8.edit();
				editor8.putString("mEditText8",mEditText8);
				editor8.apply();
						
				String mEditText9 = mainEditText9.getText().toString();
				SharedPreferences msharedpref9 = getSharedPreferences("editos", MODE_PRIVATE);
				SharedPreferences.Editor editor9 = msharedpref9.edit();
				editor9.putString("mEditText9",mEditText9);
				editor9.apply();
				break;
            case R.id.item2:
				savePreviewHtml();
				break;
		    case R.id.item3:
				AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
				LayoutInflater inflater = MainActivity.this.getLayoutInflater();
				final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
				dialogBuilder.setView(dialogView);
				final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);
				edt.setText(uida);
				dialogBuilder.setTitle("Renomear Projeto");
				dialogBuilder.setMessage("Dê um nome pequeno a sua pesquisa.");
				dialogBuilder.setPositiveButton("Vamos lá!", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							String titlu = edt.getText().toString();
							if(TextUtils.isEmpty(titlu)) {
								Toast.makeText(getApplicationContext(), "Não pode ficar vazio!", Toast.LENGTH_LONG).show();
							}else{
								File sdcard7 = Environment.getExternalStorageDirectory();
								File file = new File(sdcard7 + "/BlackXtenium_PJ/" + uida, uida + ".html");
								File file2 = new File(sdcard7 + "/BlackXtenium_PJ/" + uida, titlu + ".html");
								file.renameTo(file2);
								File file3 = new File(sdcard7 + "/BlackXtenium_PJ/" + uida);
								File file4 = new File(sdcard7 + "/BlackXtenium_PJ/" + titlu);
								file3.renameTo(file4);
								SharedPreferences msharedpref = getSharedPreferences("msh", MODE_PRIVATE);
								SharedPreferences.Editor editor = msharedpref.edit();
								editor.putString("tpastas",titlu);
								editor.apply();
								finish();
								overridePendingTransition(0, 0);
								startActivity(getIntent());
								overridePendingTransition(0, 0);
								
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
					break;
					case R.id.item5:
				AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
				builder1.setTitle("BlackXtenium");
				builder1.setMessage("Todas as permissões pedidas são necessárias para o funcionamento do app. A {E}DEBELZAAK S.O não apoia práticas que possam roubar dados ou danificar aparelhos.");
				builder1.setCancelable(false);

				builder1.setPositiveButton(
					"OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
						}
					});

				AlertDialog alert11 = builder1.create();
				alert11.show();
				    break;
					case R.id.item4:
				AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
				builder2.setTitle("DIREITOS AUTORAIS");
				builder2.setMessage("©{E}DEBELZAAK S.O | 318 N.E\n" +
							"Todos os direitos reservados");
				builder2.setCancelable(false);
				builder2.setPositiveButton(
					"OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.dismiss();
						}
					});

				AlertDialog alert12 = builder2.create();
				alert12.show();
					break;
					case R.id.part1:
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_TEXT, "Aplicativo BlackXtenium facilita o desenvolvimento de sua pesquisa cientifica. \n" +
				"\n" +
				"https://play.google.com/store/apps/details?id=com.so.debelzaak.evolution.blackxtenium");
				startActivity(Intent.createChooser(intent, "Via..."));
					break;
            default:
                return super.onOptionsItemSelected(item);
        }
		return true;
		}
		
	private void savePreviewHtml() {
		String obsevei = mainEditText6.getText().toString();
		String experimentos = mainEditText7.getText().toString();
		String interpretacao = mainEditText8.getText().toString();
		String conclusao = mainEditText9.getText().toString();

		if(TextUtils.isEmpty(obsevei)) {
			obsevei = "...";
		}
	
		if(TextUtils.isEmpty(experimentos)) {
			experimentos = "...";
		}
	
		if(TextUtils.isEmpty(interpretacao)) {
			interpretacao = "...";
		}
	
		if(TextUtils.isEmpty(conclusao)) {
			conclusao = "...";
		}
	
	if(cb1.isChecked()){
		hipotese = mainEditText.getText().toString();
		if(TextUtils.isEmpty(hipotese)) {
			hipotese = "...";
		}
		if (mainImageView.getDrawable() == null){
			observe = " ";
		}else{
			observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
		}

		if (mainImageView2.getDrawable() == null){
			experi = " ";
		}else{
			experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
		}

		if (mainImageView3.getDrawable() == null){
			interpr = " ";
		}else{
			interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
		}
		
		String path = Environment.getExternalStorageDirectory().getPath();
		String fileName = uida + ".html";
		File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

		if (!file.exists()) {
			File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
			wallpaperDirectory.mkdirs();
		}
		String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>Preview</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br><br>Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";

		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] data = html.getBytes();
			out.write(data);
			out.close();
			Intent inter = new Intent(MainActivity.this, MainPreview.class);
			inter.putExtra("paster",uida);
			startActivity(inter);
			Toast.makeText(getApplication(), "Preview", 
						   Toast.LENGTH_LONG).show();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
		
	}else{
		if(cb2.isChecked()){
			hipotese = mainEditText2.getText().toString();
			if(TextUtils.isEmpty(hipotese)) {
				hipotese = "...";
			}
			
			if (mainImageView.getDrawable() == null){
				observe = " ";
			}else{
				observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
			}

			if (mainImageView2.getDrawable() == null){
				experi = " ";
			}else{
				experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
			}

			if (mainImageView3.getDrawable() == null){
				interpr = " ";
			}else{
				interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
			}
			String path = Environment.getExternalStorageDirectory().getPath();
			String fileName = uida + ".html";
			File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

			if (!file.exists()) {
				File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
				wallpaperDirectory.mkdirs();
			}
			String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>Preview</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br><br>Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
			try {
				FileOutputStream out = new FileOutputStream(file);
				byte[] data = html.getBytes();
				out.write(data);
				out.close();
				Intent inter = new Intent(MainActivity.this, MainPreview.class);
				inter.putExtra("paster",uida);
				startActivity(inter);
				Toast.makeText(getApplication(), "Preview", 
							   Toast.LENGTH_LONG).show();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
			}
			
		}else{
			if(cb3.isChecked()){
				hipotese = mainEditText3.getText().toString();
				if(TextUtils.isEmpty(hipotese)) {
					hipotese = "...";
				}
				
				if (mainImageView.getDrawable() == null){
					observe = " ";
				}else{
					observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
				}

				if (mainImageView2.getDrawable() == null){
					experi = " ";
				}else{
					experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
				}

				if (mainImageView3.getDrawable() == null){
					interpr = " ";
				}else{
					interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
				}
				String path = Environment.getExternalStorageDirectory().getPath();
				String fileName = uida + ".html";
				File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

				if (!file.exists()) {
					File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
					wallpaperDirectory.mkdirs();
				}
				String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>Preview</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br><br>Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
				try {
					FileOutputStream out = new FileOutputStream(file);
					byte[] data = html.getBytes();
					out.write(data);
					out.close();
					Intent inter = new Intent(MainActivity.this, MainPreview.class);
					inter.putExtra("paster",uida);
					startActivity(inter);
					Toast.makeText(getApplication(), "Preview", 
								   Toast.LENGTH_LONG).show();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
				}
				
			}else{
				if(cb4.isChecked()){
					hipotese = mainEditText4.getText().toString();
					if(TextUtils.isEmpty(hipotese)) {
						hipotese = "...";
					}
					
					if (mainImageView.getDrawable() == null){
						observe = " ";
					}else{
						observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
					}

					if (mainImageView2.getDrawable() == null){
						experi = " ";
					}else{
						experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
					}

					if (mainImageView3.getDrawable() == null){
						interpr = " ";
					}else{
						interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
					}
					String path = Environment.getExternalStorageDirectory().getPath();
					String fileName = uida + ".html";
					File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

					if (!file.exists()) {
						File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
						wallpaperDirectory.mkdirs();
					}
					String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>Preview</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br><br>Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
					try {
						FileOutputStream out = new FileOutputStream(file);
						byte[] data = html.getBytes();
						out.write(data);
						out.close();
						Intent inter = new Intent(MainActivity.this, MainPreview.class);
						inter.putExtra("paster",uida);
						startActivity(inter);
						Toast.makeText(getApplication(), "Preview", 
									   Toast.LENGTH_LONG).show();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
					}
					
				}else{
					if(cb5.isChecked()){
						hipotese = mainEditText5.getText().toString();
						if(TextUtils.isEmpty(hipotese)) {
							hipotese = "...";
						}
						
						if (mainImageView.getDrawable() == null){
							observe = " ";
						}else{
							observe = "<img src = \"img_observado.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
						}

						if (mainImageView2.getDrawable() == null){
							experi = " ";
						}else{
							experi = "<img src = \"img_experimentos.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
						}

						if (mainImageView3.getDrawable() == null){
							interpr = " ";
						}else{
							interpr = "<img src = \"img_interpretacao.jpg\"alt=\" Smiley face\" height=\"250\" width=\"100%\" />";
						}
						String path = Environment.getExternalStorageDirectory().getPath();
						String fileName = uida + ".html";
						File file = new File(path +"/BlackXtenium_PJ/" + uida, fileName);

						if (!file.exists()) {
							File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() +"/BlackXtenium_PJ/" + uida + "/");
							wallpaperDirectory.mkdirs();
						}
						String html = "<!DOCTYPE html><html><head><meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\"><title>Preview</title></head><body><h4 >Observação</h4>"+ obsevei + "</p>" + observe + "<h4 ><br ><br >Hipótese aceita</h4><p >" + hipotese + "</p><h4 ><br><br>Experimentos</h4><p >" + experimentos + "</p>" + experi + "<h4 ><br ><br >Interpretação</h4><p >" + interpretacao + "</p>" + interpr + "<h4 ><br ><br >Conclusão</h4><p >" + conclusao + "</p></body></html>";
						try {
							FileOutputStream out = new FileOutputStream(file);
							byte[] data = html.getBytes();
							out.write(data);
							out.close();
							Intent inter = new Intent(MainActivity.this, MainPreview.class);
							inter.putExtra("paster",uida);
							startActivity(inter);
							Toast.makeText(getApplication(), "Preview", 
										   Toast.LENGTH_LONG).show();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
						}
						
					}else{
						Toast.makeText(getApplication(), "Marque a hipótese aceita!", 
									   Toast.LENGTH_LONG).show();
					}
				}
			}
		}
	}
	}

	@Override
	protected void onResume(){
		super.onResume();
		if (sPreferences.getBoolean("firstRun", true)) {
            sPreferences.edit().putBoolean("firstRun", false).apply();
	        Intent inter = new Intent(MainActivity.this, MainSplash.class);
			startActivity(inter);
			finish();
		} else {
            Toast.makeText(getApplicationContext(), "Continue editando✓", Toast.LENGTH_LONG).show();
        }
		
		if (checkbox1.getBoolean("checkbo1", true)) {
			cb1.setChecked(true);
			}
			
		if (checkbox2.getBoolean("checkbo2", true)) {
			cb2.setChecked(true);
		}
		
		if (checkbox3.getBoolean("checkbo3", true)) {
			cb3.setChecked(true);
		}
		
		if (checkbox4.getBoolean("checkbo4", true)) {
			cb4.setChecked(true);
		}
		
		if (checkbox5.getBoolean("checkbo5", true)) {
			cb5.setChecked(true);
		}
	}
}
