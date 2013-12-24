package com.example.behappy;


import database.UserDAO;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button btnSignIn;
	UserDAO userDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
	
	     userDAO=new UserDAO(this);
	     userDAO=userDAO.open();
	     
	     final  EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
		 final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
	     
	     btnSignIn=(Button)findViewById(R.id.buttonSignIn);
	     btnSignIn.setOnClickListener(new View.OnClickListener() {
	 		
	 		public void onClick(View v) {
	 			// TODO Auto-generated method stub
	 			
	 			String userName=editTextUserName.getText().toString();
				String password=editTextPassword.getText().toString();
				
				String storedPassword=userDAO.getSinlgeEntry(userName);
	 			
	 			
				if(password.equals(storedPassword))
				{
					Toast.makeText(MainActivity.this, "Bem vindo!", Toast.LENGTH_LONG).show();
					chamaHome();
				}
				else
				{
					Toast.makeText(MainActivity.this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		Button cadastro = (Button) findViewById(R.id.btnCadastro);		
		cadastro.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				chamaCadastro();
			}
		});
		
	}
		@Override
		protected void onDestroy() {
			super.onDestroy();
		    // Close The Database
			userDAO.close();
		}
	
	public void chamaHome(){
		Intent entra = new Intent(this, Home.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaCadastro(){
		Intent entra = new Intent(this, CadastroResponsavel.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}


}
