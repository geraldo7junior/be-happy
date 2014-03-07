package mod.educacional;

import com.example.behappy.Desafio;
import com.example.behappy.Diagnostico;
import com.example.behappy.Educacional;
import com.example.behappy.Home;
import com.example.behappy.Jogos;
import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class FaleComigo extends Activity {
	
	public static final int MENU1 = Menu.FIRST; 
	public static final int MENU2 = Menu.FIRST + 1;
	public static final int MENU3 = Menu.FIRST + 3;
	public static final int MENU4 = Menu.FIRST + 4;
	public static final int MENU5 = Menu.FIRST + 5;
	
	private MediaPlayer media = null;
	
	public void startMusic(int musica){
		if (media != null){
			if (media.isPlaying()){
				media.stop();
			}
			media = MediaPlayer.create(this,musica);
			media.start();			
		}
		else{
			media = MediaPlayer.create(this,musica);
			media.start();			
		}	
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fale_comigo);
	
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	    ImageButton fome = (ImageButton) findViewById(R.id.ibtnFome);		
		fome.setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
				startMusic(R.raw.falecomigo_estoucomfome);
				chamaFome();
			}
		});
	
		ImageButton sede = (ImageButton) findViewById(R.id.ibtnSede);		
		sede.setOnClickListener(new View.OnClickListener() {
		@Override
			public void onClick(View v) {
				startMusic(R.raw.falecomigo_estoucomsede);
				chamaSede();
			}
		});
	
		ImageButton sono = (ImageButton) findViewById(R.id.ibtnSono);		
		sono.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startMusic(R.raw.falecomigo_estoucomsono);
				chamaSono();
			}
		});
	
		ImageButton banho = (ImageButton) findViewById(R.id.ibtnBanho);		
		banho.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startMusic(R.raw.falecomigo_querotomarbanho);
				chamaBanho();
			}
		});
	
		ImageButton banheiro = (ImageButton) findViewById(R.id.ibtnBanheiro);		
		banheiro.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startMusic(R.raw.falecomigo_queroiraobanheiro);
				chamaBanheiro();
			}
		});
	}
	
	public void chamaFome(){
		Intent entra = new Intent(this, Fome.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaSede(){
		Intent entra = new Intent(this, Sede.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaSono(){
		Intent entra = new Intent(this, Sono.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaBanho(){
		Intent entra = new Intent(this, Banho.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	public void chamaBanheiro(){
		Intent entra = new Intent(this, Banheiro.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
	
	 public boolean onCreateOptionsMenu(Menu options) {
			options.add(0, MENU1, 0, "Home");
			options.add(0, MENU2, 0, "Jogos");
			options.add(0, MENU3, 0, "Desafios");
			options.add(0, MENU4, 0, "Educativo");
			options.add(0, MENU5, 0, "Diagnóstico");
				
			return super.onCreateOptionsMenu(options);
		}

		public boolean onOptionsItemSelected(MenuItem item) {

			switch (item.getItemId()) {
					
			case MENU1:
				Intent mudarDeTela = new Intent(this, Home.class);
				startActivity(mudarDeTela);
				return true;

			case MENU2:
				Intent mudarDeTela2 = new Intent(this, Jogos.class);
				startActivity(mudarDeTela2);
				return true;

			case MENU3:
				Intent mudarDeTela3 = new Intent(this, Desafio.class);
				startActivity(mudarDeTela3);
				return true;

			case MENU4:
				Intent mudarDeTela4 = new Intent(this, Educacional.class);
				startActivity(mudarDeTela4);
				return true;
					
			case MENU5:
				Intent mudarDeTela5 = new Intent(this, Diagnostico.class);
				startActivity(mudarDeTela5);
				return true;
			}
				return false;
		}		
}
