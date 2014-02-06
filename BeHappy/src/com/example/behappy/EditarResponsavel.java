package com.example.behappy;

import database.UserDAO;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class EditarResponsavel extends Activity {
	EditText editTextNewPassword, editTextConfirmPassword, editTextUserName, editTextPassword;
	CheckBox checkNewPassword;
	Button btnEditAccount;
	static String user;
	
	//Puxa o nome do usuário que vem da Home, que já veio do Login
	public static void pegarUser(String userName) {
		user = userName;
	}
	
	UserDAO userDAO;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.editresponsavel);
	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	userDAO=new UserDAO(this);
	userDAO=userDAO.open();
	editTextUserName=(EditText)findViewById(R.id.editTextUserName);
	editTextUserName.setText(user);
	editTextPassword=(EditText)findViewById(R.id.editTextPassword);	
	editTextNewPassword=(EditText)findViewById(R.id.editTextNewPassword);
	editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
	checkNewPassword=(CheckBox)findViewById(R.id.checkNewPassword);
	editTextNewPassword.setEnabled(false);
	editTextConfirmPassword.setEnabled(false);
	editTextNewPassword.setVisibility(View.INVISIBLE);
	editTextConfirmPassword.setVisibility(View.INVISIBLE);
	
	checkNewPassword.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			//Checkbox que habilita e desabilita a criação da nova senha
			if (((CheckBox) v).isChecked()) {
				Toast.makeText(EditarResponsavel.this, "Alterar senha atual", Toast.LENGTH_LONG).show();
				editTextNewPassword.setEnabled(true);
				editTextConfirmPassword.setEnabled(true);
				editTextNewPassword.setVisibility(View.VISIBLE);
				editTextConfirmPassword.setVisibility(View.VISIBLE);
			}
			else {
				editTextNewPassword.setEnabled(false);
				editTextConfirmPassword.setEnabled(false);
				editTextNewPassword.setVisibility(View.INVISIBLE);
				editTextConfirmPassword.setVisibility(View.INVISIBLE);
			}
				
		}
	});
	
	btnEditAccount=(Button)findViewById(R.id.btnEditAccount);
	btnEditAccount.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
		
			String userName=editTextUserName.getText().toString();
			String password=editTextPassword.getText().toString();
			String newPass=editTextNewPassword.getText().toString();
			String confirmNew=editTextConfirmPassword.getText().toString();
			
			if(userName.equals("")||password.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Campo vazio!", Toast.LENGTH_LONG).show();
					return;
		}else if (checkNewPassword.isChecked()&&newPass.equals("")) {
			Toast.makeText(getApplicationContext(), "Nova senha vazia!", Toast.LENGTH_LONG).show();
			return;			
		}else if (checkNewPassword.isChecked()&&confirmNew.equals("")) {
			Toast.makeText(getApplicationContext(), "Confirme a nova senha!", Toast.LENGTH_LONG).show();		
		}
	
		if(!newPass.equals(confirmNew)){
			Toast.makeText(getApplicationContext(), "Senhas diferentes!", Toast.LENGTH_LONG).show();
			return;
		
		}else{
			if (!password.equals(userDAO.getSinlgeEntry(user))) {
				Toast.makeText(getApplicationContext(), "Senha incorreta!", Toast.LENGTH_LONG).show();
			}else{
				if (checkNewPassword.isChecked()){
					//Se terminar o cadastro com a checkbox selecionada, transforma a senha na enviada no update
					password=newPass;
				}
			    	userDAO.updateEntry(userName, password);
			    Toast.makeText(getApplicationContext(), "Conta editada com Sucesso!", Toast.LENGTH_LONG).show();
			    chamaHome();
			
		}
	}
}
});
	
	}
	
	public void chamaHome(){
		Intent entra = new Intent(this, Home.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		userDAO.close();
	}
	

}
	
