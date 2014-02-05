package com.example.behappy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Dependente extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dependente);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		Button cadastroDep = (Button) findViewById(R.id.btnCadastroDep);	
		
		cadastroDep.setOnClickListener(new View.OnClickListener() {
	@Override
			public void onClick(View v) {
				chamaCadastroDep();
			}
		});
	
		initList();
	
		ListView lv = (ListView) findViewById(R.id.listaDependente);

		SimpleAdapter simpleAdpt = new SimpleAdapter(this, dependenteLista, android.R.layout.simple_list_item_1, new String[] {"dependente"}, new int[] {android.R.id.text1});

		lv.setAdapter(simpleAdpt);
	
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
			Intent novaIntent = null;
			for (int i = 0; i<=dependenteLista.size(); i++) {
				if (position == i) {
					novaIntent = new Intent(Dependente.this, Home.class);     
	                startActivity(novaIntent);
					break;
				}
				
			}
		}
	});        
	registerForContextMenu(lv);
	
}

List<Map<String, String>> dependenteLista = new ArrayList<Map<String,String>>();

private void initList() {

	dependenteLista.add(createFont("dependente", "Carlos"));
	dependenteLista.add(createFont("dependente", "Larissa"));
	dependenteLista.add(createFont("dependente", "Mário"));
	Log.i("array", "Array"+dependenteLista);

}

private HashMap<String, String> createFont(String key, String name) {
	HashMap<String, String> dependente = new HashMap<String, String>();
	dependente.put(key, name);

	return dependente;
}

  @Override
  public boolean onContextItemSelected(MenuItem item) {
      int itemId = item.getItemId();
      Toast.makeText(this, "Item "+itemId, Toast.LENGTH_SHORT).show();
      return true;
	}
  
  public void chamaCadastroDep(){
		Intent entra = new Intent(this, CadastroDependente.class);
		entra.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(entra);
	}
}
