package com.example.behappy;

import mod.diagnostico.Formulario;
import mod.diagnostico.Sinais;
import mod.diagnostico.UnidadesSaude;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Diagnostico extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diagnostico);
	
		Button formulario = (Button) findViewById(R.id.btnFormulario);		
		formulario.setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
				Toast.makeText(Diagnostico.this, "Preencha as questões abaixo sobre como seu filho geralmente se comporta, tentando responder a todas as questões. Caso o comportamento na questão seja raro (Só observou uma ou duas vezes), por favor responda como se seu filho não fizesse tal comportamento.", Toast.LENGTH_LONG).show();
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
		Intent entra = new Intent(this, Formulario.class);
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

