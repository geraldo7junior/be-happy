package com.example.behappy;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Cores extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cores);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		ImageButton amarelo = (ImageButton) findViewById(R.id.ibtnAmarelo);		
		amarelo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaFonte();
			}
		});
		
		ImageButton azul = (ImageButton) findViewById(R.id.ibtnAzul);		
		azul.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaFonte();
			}
		});
		
		ImageButton verde = (ImageButton) findViewById(R.id.ibtnVerde);		
		verde.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaFonte();
			}
		});
		
		ImageButton vermelho = (ImageButton) findViewById(R.id.ibtnVermelho);		
		vermelho.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaFonte();
			}
		});
	}
	
	public void chamaFonte(){
		Intent entra = new Intent(this, Fonte.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

}
