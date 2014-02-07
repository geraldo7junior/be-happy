package mod.noticias;

import java.util.List;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.behappy.R;

public class Noticias extends Activity {
	
    private Noticias local;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.noticias);
		
		String rssUrl = (String)getIntent().getExtras().get("rss-url");
		
        local = this;
         
        GetRSSDataTask task = new GetRSSDataTask();
         
        task.execute(rssUrl);
		
	}
	

	private class GetRSSDataTask extends AsyncTask<String, Void, List<Item> > {
        @Override
        protected List<Item> doInBackground(String... urls) {
            try {
                RssReader rssReader = new RssReader(urls[0]);
                return rssReader.getItems();
             
            } catch (Exception e) {
                Log.e("RssChannelActivity", e.getMessage());
            }
             
            return null;
        }
         
        @Override
        protected void onPostExecute(List<Item> result) {
             
            ListView itcItems = (ListView) findViewById(R.id.rssChannelListView);
                         
            ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(local,android.R.layout.simple_list_item_1, result);

            itcItems.setAdapter(adapter);

            itcItems.setOnItemClickListener(new ListListener(result, local));
        }
    }
	
}
