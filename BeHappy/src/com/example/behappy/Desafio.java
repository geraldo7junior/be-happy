package com.example.behappy;

import mod.desafio.Forca;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Desafio extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.desafio);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	ImageButton forca = (ImageButton) findViewById(R.id.ibtnForca);		
	forca.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			chamaForca();
		}
	});
	}
	public void chamaForca(){
		Intent entra = new Intent(this, Forca.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

}