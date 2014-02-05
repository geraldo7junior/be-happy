package com.example.behappy;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroDependente extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrodependente);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Button cadastroDependente = (Button) findViewById(R.id.btnCadastroDependente);	
		
		cadastroDependente.setOnClickListener(new View.OnClickListener() {
	@Override
			public void onClick(View v) {
				chamaConfig();
			}
		});
}
	public void chamaConfig(){
		Intent entra = new Intent(this, Cores.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
}
