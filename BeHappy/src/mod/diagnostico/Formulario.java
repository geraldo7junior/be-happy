package mod.diagnostico;

import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class Formulario extends Activity{

	/**
	 * Declarar variaveis
	 */
	RadioGroup rgq1;
	RadioGroup rgq2;
	RadioGroup rgq3;
	RadioGroup rgq4;
	RadioGroup rgq5;
	RadioGroup rgq6;
	RadioGroup rgq7;
	RadioGroup rgq8;
	RadioGroup rgq9;
	RadioGroup rgq10;
	RadioGroup rgq11;
	RadioGroup rgq12;
	RadioGroup rgq13;
	RadioGroup rgq14;
	RadioGroup rgq15;
	RadioGroup rgq16;
	RadioGroup rgq17;
	RadioGroup rgq18;
	RadioGroup rgq19;
	RadioGroup rgq20;
	RadioGroup rgq21;
	RadioGroup rgq22;
	RadioGroup rgq23;
	EditText fname;
	EditText femail;
	
	String name;
	String destiny;
	Button enviarEmail;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		initializeVars();
	
		enviarEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
				initializeVars();
				// Checa as respostas
				/*checkAnswer(rgq1);
				checkAnswer(rgq2);
				checkAnswer(rgq3);
				checkAnswer(rgq4);
				checkAnswer(rgq5);
				checkAnswer(rgq6);
				checkAnswer(rgq7);
				checkAnswer(rgq8);
				checkAnswer(rgq9);
				checkAnswer(rgq10);
				checkAnswer(rgq11);
				checkAnswer(rgq12);
				checkAnswer(rgq13);
				checkAnswer(rgq14);
				checkAnswer(rgq15);
				checkAnswer(rgq16);
				checkAnswer(rgq17);
				checkAnswer(rgq18);
				checkAnswer(rgq19);
				checkAnswer(rgq20);
				checkAnswer(rgq21);
				checkAnswer(rgq22);
				checkAnswer(rgq23); */
				
				// TO DO - Construir msg
				
				// enviar para ciente de email
				String name = editTextToString(fname);
				String email = editTextToString(femail);
				Intent intent = new Intent(Intent.ACTION_SENDTO);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_SUBJECT, "Diagnóstico via BeHappy do Usuário "+name);
				intent.putExtra(Intent.EXTRA_TEXT, "");
				intent.setData(Uri.parse("mailto:"+email));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);				
			}
		});
	}
	

	private void initializeVars() {
		// TODO Auto-generated method stub
		final RadioGroup q1 = (RadioGroup)findViewById(R.id.rgq1);
		final RadioGroup q2= (RadioGroup)findViewById(R.id.rgq2);
		final RadioGroup q3 = (RadioGroup)findViewById(R.id.rgq3);
		final RadioGroup q4= (RadioGroup)findViewById(R.id.rgq4);
		final RadioGroup q5 = (RadioGroup)findViewById(R.id.rgq5);
		final RadioGroup q6= (RadioGroup)findViewById(R.id.rgq6);
		final RadioGroup q7 = (RadioGroup)findViewById(R.id.rgq7);
		final RadioGroup q8= (RadioGroup)findViewById(R.id.rgq8);
		final RadioGroup q9 = (RadioGroup)findViewById(R.id.rgq9);
		final RadioGroup q10= (RadioGroup)findViewById(R.id.rgq10);
		final RadioGroup q11 = (RadioGroup)findViewById(R.id.rgq11);
		final RadioGroup q12= (RadioGroup)findViewById(R.id.rgq12);
		final RadioGroup q13 = (RadioGroup)findViewById(R.id.rgq13);
		final RadioGroup q14= (RadioGroup)findViewById(R.id.rgq14);
		final RadioGroup q15 = (RadioGroup)findViewById(R.id.rgq15);
		final RadioGroup q16= (RadioGroup)findViewById(R.id.rgq16);
		final RadioGroup q17= (RadioGroup)findViewById(R.id.rgq17);
		final RadioGroup q18= (RadioGroup)findViewById(R.id.rgq18);
		final RadioGroup q19= (RadioGroup)findViewById(R.id.rgq19);
		final RadioGroup q20= (RadioGroup)findViewById(R.id.rgq20);
		final RadioGroup q21= (RadioGroup)findViewById(R.id.rgq21);
		final RadioGroup q22= (RadioGroup)findViewById(R.id.rgq22);
		final RadioGroup q23= (RadioGroup)findViewById(R.id.rgq23);
		final EditText fname= (EditText)findViewById(R.id.fname);
		final EditText femail= (EditText)findViewById(R.id.femail);
		
		enviarEmail = (Button) findViewById(R.id.bEnviarEmail);
	}
	
	private void  checkAnswer(RadioGroup group) {  
		int resposta = group.getCheckedRadioButtonId();
		// TODO Auto-generated method stub
		if(resposta == R.id.rbqy) //Add saida para Y
			; 
		else if(resposta==R.id.rbqn) //add saida para N
			;
		convertAnswerToString();
		}
	
	private void  convertAnswerToString() {  
		// To Do
		}
	
	private String  editTextToString(EditText field) {  
		String string = field.getText().toString();
		return string;
		
		}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}