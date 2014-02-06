package mod.educacional;

import com.example.behappy.R;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Banho extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banho);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
