package com.example.behappy;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends Activity {
	
	public static final int MENU1 = Menu.FIRST; 
	public static final int MENU2 = Menu.FIRST + 1;
	public static final int MENU3 = Menu.FIRST + 3;
	public static final int MENU4 = Menu.FIRST + 4;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ImageButton educacional = (ImageButton) findViewById(R.id.ibtnEducacional);		
		educacional.setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
				chamaEducacional();
			}
		});
	
		ImageButton jogos = (ImageButton) findViewById(R.id.ibtnGame);		
		jogos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaJogos();
			}
		});
	
		Button diagnostico = (Button) findViewById(R.id.btnDiagnostico);		
		diagnostico.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaDiagnostico();
			}
		});
	}
	
	public void chamaEducacional(){
		Intent entra = new Intent(this, Educacional.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaJogos(){
		Intent entra = new Intent(this, Jogos.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaDiagnostico(){
		Intent entra = new Intent(this, Diagnostico.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public boolean onCreateOptionsMenu(Menu options) {
		options.add(0, MENU1, 0, "Dependente");
		options.add(0, MENU2, 0, "Configuração");
		options.add(0, MENU3, 0, "Informações");
		options.add(0, MENU4, 0, "Sair");
			
		return super.onCreateOptionsMenu(options);
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
				
		case MENU1:
			Intent mudarDeTela = new Intent(this, Dependente.class);
			startActivity(mudarDeTela);
			return true;

		case MENU2:
			Intent mudarDeTela2 = new Intent(this, Cores.class);
			startActivity(mudarDeTela2);
			return true;

		case MENU3:
			siteBeHappy();
			return true;
				
		case MENU4:
			finish();
			return true;
		}
			return false;
	}

	void siteBeHappy() {
		String end = "https://code.google.com/p/be-happy/";
		Uri uri = Uri.parse(end);
		Intent it = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(it);
	}
}
