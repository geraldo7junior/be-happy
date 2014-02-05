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

public class CadastroResponsavel extends Activity  {
	EditText editTextUserName,editTextPassword,editTextConfirmPassword;
	Button btnCreateAccount;
	
	UserDAO userDAO;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastroresponsavel);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		userDAO=new UserDAO(this);
		userDAO=userDAO.open();
		
		editTextUserName=(EditText)findViewById(R.id.editTextUserName);
		editTextPassword=(EditText)findViewById(R.id.editTextPassword);
		editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
		
		btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {
		
			public void onClick(View v) {
			
				String userName=editTextUserName.getText().toString();
				String password=editTextPassword.getText().toString();
				String confirmPassword=editTextConfirmPassword.getText().toString();
				
				if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
				{
						Toast.makeText(getApplicationContext(), "Campo vazio!", Toast.LENGTH_LONG).show();
						return;
			}
		
			if(!password.equals(confirmPassword)){
				Toast.makeText(getApplicationContext(), "Senhas diferentes!", Toast.LENGTH_LONG).show();
				return;
			}
			else{
				
			    userDAO.insertEntry(userName, password);
			    Toast.makeText(getApplicationContext(), "Conta criada com Sucesso!", Toast.LENGTH_LONG).show();
			    chamaLogin();
			}
		}
	});

}
	public void chamaLogin(){
		Intent entra = new Intent(this, MainActivity.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		userDAO.close();
	}
}

