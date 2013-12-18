package com.example.behappy;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Jogos extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.jogos);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	ImageButton quebra = (ImageButton) findViewById(R.id.ibtnQuebraCabeca);		
	quebra.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			chamaQuebraCabeca();
		}
	});
	}
	public void chamaQuebraCabeca(){
		Intent entra = new Intent(this, QuebraCabeca.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}

}