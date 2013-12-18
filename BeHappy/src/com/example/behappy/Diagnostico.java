package com.example.behappy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Diagnostico extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.diagnostico);
	
	Button formulario = (Button) findViewById(R.id.btnFormulario);		
	formulario.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			chamaFormulario();
		}
	});
	
	
	Button sinais = (Button) findViewById(R.id.btnSinais);		
	sinais.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			chamaSinais();
		}
	});
		

Button unidades = (Button) findViewById(R.id.btnUnidades);		
unidades.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
		chamaUnidades();
	}
});
}

	public void chamaFormulario(){
		Intent entra = new Intent(this, Report.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaSinais(){
		Intent entra = new Intent(this, Sinais.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaUnidades(){
		Intent entra = new Intent(this, UnidadesSaude.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	}

