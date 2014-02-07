package mod.desafio;

import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Forca extends Activity implements OnClickListener {
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
}

