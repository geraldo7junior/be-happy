package mod.diagnostico;

import com.example.behappy.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Sinais extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sinais);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
