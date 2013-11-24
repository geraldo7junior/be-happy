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
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;

public class Fonte extends Activity {
	public ListView listaFonte;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	super.onCreate(savedInstanceState);
	setContentView(R.layout.fonte);
	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	
	
	
	/*#### LISTA PROJETOS ####*/
	
	initList();

	ListView lv = (ListView) findViewById(R.id.listaFonte);

	SimpleAdapter simpleAdpt = new SimpleAdapter(this, fonteLista, android.R.layout.simple_list_item_1, new String[] {"fonte"}, new int[] {android.R.id.text1});

	lv.setAdapter(simpleAdpt);
	
	lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
				long id) {
			// TODO Auto-generated method stub
		
			Intent novaIntent = null;
			for (int i = 0; i<=fonteLista.size(); i++) {
				if (position == i) {
					novaIntent = new Intent(Fonte.this, Home.class);     
	                startActivity(novaIntent);
					break;
				}
				
			}
		}
	});        
	registerForContextMenu(lv);
	
	
	
	
}


List<Map<String, String>> fonteLista = new ArrayList<Map<String,String>>();

private void initList() {

	fonteLista.add(createFont("fonte", "Arial"));
	fonteLista.add(createFont("fonte", "Time New"));
	fonteLista.add(createFont("fonte", "Calibri"));
	fonteLista.add(createFont("fonte", "Cambria"));
	fonteLista.add(createFont("fonte", "Geraldo Fonts"));
	Log.i("array", "Array"+fonteLista);

}

private HashMap<String, String> createFont(String key, String name) {
	HashMap<String, String> fonte = new HashMap<String, String>();
	fonte.put(key, name);

	return fonte;
}

  @SuppressWarnings("unchecked")
@Override
  public void onCreateContextMenu(ContextMenu menu, View v,
          ContextMenuInfo menuInfo) {

      super.onCreateContextMenu(menu, v, menuInfo);
      AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;

      SimpleAdapter simpleAdpt = new SimpleAdapter(this, fonteLista, android.R.layout.simple_list_item_1, new String[] {"fonte"}, new int[] {android.R.id.text1});;
	HashMap<String, String> map =  ((HashMap<String, String>) simpleAdpt.getItem(aInfo.position));

      menu.setHeaderTitle("Op��es de " + map.get("planet"));
      menu.add(1, 1, 1, "Detalhes");
      menu.add(1, 2, 2, "Excluir");

  }
  

  @Override
  public boolean onContextItemSelected(MenuItem item) {
      int itemId = item.getItemId();
      Toast.makeText(this, "Item "+itemId, Toast.LENGTH_SHORT).show();
      return true;
  }


/*#### LISTA PROJETOS - FIM ####*/

}
