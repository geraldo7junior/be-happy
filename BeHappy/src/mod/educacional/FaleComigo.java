package mod.educacional;

import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FaleComigo extends Activity {
	
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
}
