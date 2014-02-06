package com.example.behappy;

import database.DependenteDAO;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroDependente extends Activity {
	EditText editTextNome;
	Button btnCadastroDependente;
	
	DependenteDAO userDAO;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrodependente);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		userDAO=new DependenteDAO(this);
		userDAO=userDAO.open();
		
		editTextNome=(EditText)findViewById(R.id.editTextNome);
		
		btnCadastroDependente=(Button)findViewById(R.id.btnCadastroDependente);
		btnCadastroDependente.setOnClickListener(new View.OnClickListener() {
	@Override
			public void onClick(View v) {
				String nome=editTextNome.getText().toString();
				if(nome.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Campo vazio!", Toast.LENGTH_LONG).show();
						return;
				}else {
				userDAO.insertEntry(nome);
				Toast.makeText(getApplicationContext(), "Dependente criado com Sucesso!", Toast.LENGTH_LONG).show();
				chamaConfig();
				}
			}
		});
}
	public void chamaConfig(){
		Intent entra = new Intent(this, Cores.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		userDAO.close();
	}
}
