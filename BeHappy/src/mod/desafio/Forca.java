package mod.desafio;

import com.example.behappy.Desafio;
import com.example.behappy.Diagnostico;
import com.example.behappy.Educacional;
import com.example.behappy.Home;
import com.example.behappy.Jogos;
import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Forca extends Activity implements OnClickListener {
	
	public static final int MENU1 = Menu.FIRST; 
	public static final int MENU2 = Menu.FIRST + 1;
	public static final int MENU3 = Menu.FIRST + 3;
	public static final int MENU4 = Menu.FIRST + 4;
	public static final int MENU5 = Menu.FIRST + 5;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.forca);
	
	Button bForca = (Button) findViewById(R.id.btnForca);
    Button bSair   = (Button) findViewById(R.id.btnSair);
    bForca.setOnClickListener(this);
    bSair.setOnClickListener(this);

	}
	
	public void onClick(View v) {
        Intent i = new Intent(Forca.this, ForcaJogo.class);
        switch (v.getId()) {
        case R.id.btnForca:
            i.putExtra("tipo", "jogador1");
            startActivity(i);
            break;
  
        case R.id.btnSair:
            finish();
        }
    }
	
	public boolean onCreateOptionsMenu(Menu options) {
		options.add(0, MENU1, 0, "Home");
		options.add(0, MENU2, 0, "Jogos");
		options.add(0, MENU3, 0, "Desafios");
		options.add(0, MENU4, 0, "Educativo");
		options.add(0, MENU5, 0, "Diagnůstico");
			
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

