package com.example.behappy;

import mod.educacional.FaleComigo;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Educacional extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.educacional);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	ImageButton fale = (ImageButton) findViewById(R.id.ibtnFaleComigo);		
	fale.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			chamaFaleComigo();
		}
	});
	}
	public void chamaFaleComigo(){
		Intent entra = new Intent(this, FaleComigo.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

}
