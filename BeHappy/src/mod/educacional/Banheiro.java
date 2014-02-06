package mod.educacional;

import com.example.behappy.R;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class Banheiro extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.banheiro);
	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}