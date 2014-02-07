package com.example.behappy;


import java.util.concurrent.ExecutionException;

import database.EnterProcess;
import database.UserDAO;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.os.AsyncTask;
import com.example.behappy.Home;

public class MainActivity extends Activity {
	
	Button btnSignIn;
	UserDAO userDAO;
	String userName;
	final EnterProcess startProcess = new EnterProcess(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	     userDAO=new UserDAO(this);
	     userDAO=userDAO.open();
	     
	     btnSignIn=(Button)findViewById(R.id.buttonSignIn);
	     btnSignIn.setOnClickListener(new View.OnClickListener() {
	 		
	 		public void onClick(View v) {
	 			// TODO Auto-generated method stub
	 			final  EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
	 			final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
	 			
	 			userName=editTextUserName.getText().toString();
				String password=editTextPassword.getText().toString();
				
				String storedPassword=userDAO.getSinlgeEntry(userName);
				
				if(password.equals(storedPassword)){
                    
                    Toast.makeText(MainActivity.this, "Bem vindo!", Toast.LENGTH_LONG).show();
                    Home.pegarUser(userName);
                    chamaHome();
	            }
	            else{
	                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos!", Toast.LENGTH_LONG).show();
	            }
				
				//Banco Remoto - Inicio
				//startProcess.execute(editTextUserName,editTextPassword);
				//
				//try {
				//	if (startProcess.get()==1){
				//		Toast.makeText(MainActivity.this, "Bem-vindo!", Toast.LENGTH_SHORT).show();
				//		userName=editTextUserName.getText().toString();
				//		Home.pegarUser(userName);
				//		chamaHome();
				//		
				//	}
				//	else
				//		Toast.makeText(MainActivity.this, "Usuário ou senha inválidos!", Toast.LENGTH_LONG).show();
				//} catch (InterruptedException e) {
				//	// TODO Auto-generated catch block
				//	e.printStackTrace();
				//} catch (ExecutionException e) {
				//	// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
				//Banco Remoto - Fim
				
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
