package mod.noticias;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.behappy.R;

@SuppressWarnings("deprecation")
public class Tabs extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tabs);
		

		TabHost tabHost = getTabHost();

		Intent umIntent = new Intent().setClass(this, Noticias.class);

		umIntent.putExtra("rss-url",
				"http://feeds.feedburner.com/AutismoAmorTuAmas");

		String umTabName = getResources().getString(R.string.tab_um);
		TabSpec umTabSpec = tabHost
				.newTabSpec(umTabName)
				.setIndicator(umTabName,
						getResources().getDrawable(R.drawable.tab_um))
				.setContent(umIntent);

		tabHost.addTab(umTabSpec);

		Intent doisIntent = new Intent().setClass(this, Noticias.class);

		doisIntent.putExtra("rss-url",
				"http://www.estouautista.com.br/index.php/feed/");

		String doisTabName = getResources().getString(R.string.tab_dois);
		TabSpec doisTabSpec = tabHost
				.newTabSpec(doisTabName)
				.setIndicator(doisTabName,
						getResources().getDrawable(R.drawable.tab_dois))
				.setContent(doisIntent);

		tabHost.addTab(doisTabSpec);

		Intent tresIntent = new Intent().setClass(this, Noticias.class);

		tresIntent.putExtra("rss-url",
				"http://feeds.feedburner.com/autismspeaks/science-news");

		String tresTabName = getResources().getString(R.string.tab_tres);
		TabSpec tresTabSpec = tabHost
				.newTabSpec(tresTabName)
				.setIndicator(tresTabName,
						getResources().getDrawable(R.drawable.tab_tres))
				.setContent(tresIntent);

		tabHost.addTab(tresTabSpec);

		tabHost.setCurrentTab(1);
		
	}

}
