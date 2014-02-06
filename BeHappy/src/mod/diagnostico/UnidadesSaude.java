package mod.diagnostico;

import com.example.behappy.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnidadesSaude extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.unidadessaude);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Button unidadess = (Button) findViewById(R.id.btnUnidadesSaude);
	    unidadess.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Intent myIntent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://i.imgur.com/1Ye0aqk.jpg?1"));
	    		startActivity(myIntent);
	    	}
	    });

	}
}
