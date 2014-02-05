package mod.diagnostico;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.behappy.R;

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
	
	ArrayList<String> listaResp = new ArrayList<String>();
	ArrayList<String> listaAut = new ArrayList<String>();
	Integer contTotal;
	Integer contChave;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario);
		initializeVars();
		
		//lista que resposta que configuram o autismo				
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("yes");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("not");
		listaAut.add("yes");
		listaAut.add("not");
		listaAut.add("yes");
		listaAut.add("not");
		listaAut.add("yes");
		listaAut.add("not");
		
	
		enviarEmail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
				
				//instanciando radioButton
				final RadioButton rbqy1 = (RadioButton)findViewById(R.id.rbqy1);
				final RadioButton rbqn1 = (RadioButton)findViewById(R.id.rbqn1);
				final RadioButton rbqy2 = (RadioButton)findViewById(R.id.rbqy2);
				final RadioButton rbqn2 = (RadioButton)findViewById(R.id.rbqn2);
				final RadioButton rbqy3 = (RadioButton)findViewById(R.id.rbqy3);
				final RadioButton rbqn3 = (RadioButton)findViewById(R.id.rbqn3);
				final RadioButton rbqy4 = (RadioButton)findViewById(R.id.rbqy4);
				final RadioButton rbqn4 = (RadioButton)findViewById(R.id.rbqn4);
				final RadioButton rbqy5 = (RadioButton)findViewById(R.id.rbqy5);
				final RadioButton rbqn5 = (RadioButton)findViewById(R.id.rbqn5);
				final RadioButton rbqy6 = (RadioButton)findViewById(R.id.rbqy6);
				final RadioButton rbqn6 = (RadioButton)findViewById(R.id.rbqn6);
				final RadioButton rbqy7 = (RadioButton)findViewById(R.id.rbqy7);
				final RadioButton rbqn7 = (RadioButton)findViewById(R.id.rbqn7);
				final RadioButton rbqy8 = (RadioButton)findViewById(R.id.rbqy8);
				final RadioButton rbqn8 = (RadioButton)findViewById(R.id.rbqn8);
				final RadioButton rbqy9 = (RadioButton)findViewById(R.id.rbqy9);
				final RadioButton rbqn9 = (RadioButton)findViewById(R.id.rbqn9);
				final RadioButton rbqy10 = (RadioButton)findViewById(R.id.rbqy10);
				final RadioButton rbqn10 = (RadioButton)findViewById(R.id.rbqn10);
				final RadioButton rbqy11 = (RadioButton)findViewById(R.id.rbqy11);
				final RadioButton rbqn11 = (RadioButton)findViewById(R.id.rbqn11);
				final RadioButton rbqy12 = (RadioButton)findViewById(R.id.rbqy12);
				final RadioButton rbqn12 = (RadioButton)findViewById(R.id.rbqn12);
				final RadioButton rbqy13 = (RadioButton)findViewById(R.id.rbqy13);
				final RadioButton rbqn13 = (RadioButton)findViewById(R.id.rbqn13);
				final RadioButton rbqy14 = (RadioButton)findViewById(R.id.rbqy14);
				final RadioButton rbqn14 = (RadioButton)findViewById(R.id.rbqn14);
				final RadioButton rbqy15 = (RadioButton)findViewById(R.id.rbqy15);
				final RadioButton rbqn15 = (RadioButton)findViewById(R.id.rbqn15);
				final RadioButton rbqy16 = (RadioButton)findViewById(R.id.rbqy16);
				final RadioButton rbqn16 = (RadioButton)findViewById(R.id.rbqn16);
				final RadioButton rbqy17 = (RadioButton)findViewById(R.id.rbqy17);
				final RadioButton rbqn17 = (RadioButton)findViewById(R.id.rbqn17);
				final RadioButton rbqy18 = (RadioButton)findViewById(R.id.rbqy18);
				final RadioButton rbqn18 = (RadioButton)findViewById(R.id.rbqn18);
				final RadioButton rbqy19 = (RadioButton)findViewById(R.id.rbqy19);
				final RadioButton rbqn19 = (RadioButton)findViewById(R.id.rbqn19);
				final RadioButton rbqy20 = (RadioButton)findViewById(R.id.rbqy20);
				final RadioButton rbqn20 = (RadioButton)findViewById(R.id.rbqn20);
				final RadioButton rbqy21 = (RadioButton)findViewById(R.id.rbqy21);
				final RadioButton rbqn21 = (RadioButton)findViewById(R.id.rbqn21);
				final RadioButton rbqy22 = (RadioButton)findViewById(R.id.rbqy22);
				final RadioButton rbqn22 = (RadioButton)findViewById(R.id.rbqn22);
				final RadioButton rbqy23 = (RadioButton)findViewById(R.id.rbqy23);
				final RadioButton rbqn23 = (RadioButton)findViewById(R.id.rbqn23);				
				
				//checando respostas
				checkAnswer(rbqy1,rbqn1);
				checkAnswer(rbqy2,rbqn2);
				checkAnswer(rbqy3,rbqn3);
				checkAnswer(rbqy4,rbqn4);
				checkAnswer(rbqy5,rbqn5);
				checkAnswer(rbqy6,rbqn6);
				checkAnswer(rbqy7,rbqn7);
				checkAnswer(rbqy8,rbqn8);
				checkAnswer(rbqy9,rbqn9);
				checkAnswer(rbqy10,rbqn10);
				checkAnswer(rbqy11,rbqn11);
				checkAnswer(rbqy12,rbqn12);
				checkAnswer(rbqy13,rbqn13);
				checkAnswer(rbqy14,rbqn14);
				checkAnswer(rbqy15,rbqn15);
				checkAnswer(rbqy16,rbqn16);
				checkAnswer(rbqy17,rbqn17);
				checkAnswer(rbqy18,rbqn18);
				checkAnswer(rbqy19,rbqn19);
				checkAnswer(rbqy20,rbqn20);
				checkAnswer(rbqy21,rbqn21);
				checkAnswer(rbqy22,rbqn22);
				checkAnswer(rbqy23,rbqn23);
							
				//zerando contadores
				contTotal = 0;
				contChave = 0;
				
				
				//comparacao das respostas
				for (int i=0; i < listaResp.size(); i++){
					if (listaResp.get(i) == listaAut.get(i)){ //total
						contTotal += 1;
						if ((i==1)||(i==6)||(i==8)||(i==12)||(i==13)||(i==14)){ //chave
							contChave +=1;
						}
					}
				}
								
				convertAnswerToString();
				
				// enviar para cliente de email				
				//testar em dispositivo que tenha cliente de email cadastrado
				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{"mauriokk@gmail.com"});//para	  
				email.putExtra(Intent.EXTRA_SUBJECT, "Formulário de Diagnóstico");
				email.putExtra(Intent.EXTRA_TEXT, "anexar formulário!");
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Escolha um email: "));//de
			}
		});
	}
	

	private void initializeVars() {
		/*
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
		*/
		
		enviarEmail = (Button) findViewById(R.id.bEnviarEmail);
	}
	
	private void  checkAnswer(RadioButton respy, RadioButton respn) {  
		//int resposta = group.getCheckedRadioButtonId();
		// TODO Auto-generated method stub
		if(respy.isChecked()) //Add saida para Y
			listaResp.add("yes"); 
		else if(respn.isChecked()) //add saida para N
			listaResp.add("not");
		//else Toast.makeText(Formulario.this, "nem um nem outro", Toast.LENGTH_LONG).show();
		}
	
	private void  convertAnswerToString() {  
		if ((contTotal > 2) || (contChave > 1)){
			//autista
			Toast.makeText(Formulario.this, "A criança tem tendência autista. Procure um especialista!", Toast.LENGTH_LONG).show();
		}
		else{
			//nao autista
			Toast.makeText(Formulario.this, "A criança NÃO tem tendência autista!", Toast.LENGTH_LONG).show();
		}
	}
	
	/*
	private String  editTextToString(EditText field) {  
		String string = field.getText().toString();
		return string;		
	}
	*/	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}