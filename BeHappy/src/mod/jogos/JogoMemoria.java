package mod.jogos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.behappy.R;

public class JogoMemoria extends Activity {
    private static int ROW_COUNT = -1;
	private static int COL_COUNT = -1;
	private Context context;
	private Drawable backImage;
	private int [] [] cartas;
	private List<Drawable> images;
	private Cartas primeiraCarta;
	private Cartas segundaCarta;
	private ButtonListener buttonListener;
	private static Object lock = new Object();
	int vezes = 0;
	private TableLayout mainTable;
	private AtualizaCartasHandler handler;
	
	int nivel = 1;
	int contAcertos = 0;
	int x = 0,y = 0;
	ArrayList<String> listaTamMatriz = new ArrayList<String>();
	ComplexidadeNivel ComplexidadeNivel = new ComplexidadeNivel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        listaTamMatriz.add("4x4");
        listaTamMatriz.add("4x5");
        listaTamMatriz.add("4x6");
        listaTamMatriz.add("5x6");
        listaTamMatriz.add("6x6");
            
        handler = new AtualizaCartasHandler();
        carregaImagens();
        setContentView(R.layout.memoria);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       
       backImage =  getResources().getDrawable(R.drawable.icon);
       buttonListener = new ButtonListener();
       mainTable = (TableLayout)findViewById(R.id.TableLayout03);
       context  = mainTable.getContext();
        
       	    Spinner s = (Spinner) findViewById(R.id.Spinner01);
	        ArrayAdapter adapter = ArrayAdapter.createFromResource(
	        this, R.array.type, android.R.layout.simple_spinner_item);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        s.setAdapter(adapter);
	        
	        s.setOnItemSelectedListener(new OnItemSelectedListener(){
	        	
	    	  @Override
	    	  public void onItemSelected(
	    			  android.widget.AdapterView<?> arg0, 
	    			  View arg1, int pos, long arg3){
	    		  
	    		  ((Spinner) findViewById(R.id.Spinner01)).setSelection(0);
	  			
	  			switch (pos) {
				case 1:
					x=4;y=4;
					novoJogo(x,y);
					break;
				case 2:
					nivel = ComplexidadeNivel.memoriaParaMemoria(nivel, vezes, contAcertos, x, y);
					if (nivel >= 2){
						x=4;y=5;
						novoJogo(x,y);
					}
					else Toast.makeText(JogoMemoria.this, "Nível bloqueado!", Toast.LENGTH_LONG).show();
					break;
				case 3:
					nivel = ComplexidadeNivel.memoriaParaMemoria(nivel, vezes, contAcertos, x, y);
					if (nivel >= 3){
						x=4;y=6;
						novoJogo(x,y);
					}
					else Toast.makeText(JogoMemoria.this, "Nível bloqueado!", Toast.LENGTH_LONG).show();
					break;
				case 4:
					nivel = ComplexidadeNivel.memoriaParaMemoria(nivel, vezes, contAcertos, x, y);
					if (nivel >= 4){
						x=5;y=6;
						novoJogo(x,y);
					}
					else Toast.makeText(JogoMemoria.this, "Nível bloqueado!", Toast.LENGTH_LONG).show();
					break;
				case 5:					
					nivel = ComplexidadeNivel.memoriaParaMemoria(nivel, vezes, contAcertos, x, y);
					if (nivel >= 5){
						x=6;y=6;
						novoJogo(x,y);
					}
					else Toast.makeText(JogoMemoria.this, "Nível bloqueado!", Toast.LENGTH_LONG).show();
					break;
				default:
					return;
				}	
	  		}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

	  	});
    }
    
    private void novoJogo(int c, int r) {
    	contAcertos = 0;
    	ROW_COUNT = r;
    	COL_COUNT = c;
    	cartas = new int [COL_COUNT] [ROW_COUNT];
    	mainTable.removeView(findViewById(R.id.TableRow01));
    	mainTable.removeView(findViewById(R.id.TableRow02));
    	TableRow tr = ((TableRow)findViewById(R.id.TableRow03));
    	tr.removeAllViews();
    	mainTable = new TableLayout(context);
    	tr.addView(mainTable);
    	 for (int y = 0; y < ROW_COUNT; y++) {
    		 mainTable.addView(createRow(y));
          }
    	 
    	 primeiraCarta=null;
    	 carregaCartas();
    	 
    	 vezes=0;
    	 ((TextView)findViewById(R.id.tv1)).setText("Tentativas: "+vezes);		
	}
    
    private void carregaImagens() {
    	images = new ArrayList<Drawable>();
    	
    	images.add(getResources().getDrawable(R.drawable.card1));
    	images.add(getResources().getDrawable(R.drawable.card2));
    	images.add(getResources().getDrawable(R.drawable.card3));
    	images.add(getResources().getDrawable(R.drawable.card4));
    	images.add(getResources().getDrawable(R.drawable.card5));
    	images.add(getResources().getDrawable(R.drawable.card6));
    	images.add(getResources().getDrawable(R.drawable.card7));
    	images.add(getResources().getDrawable(R.drawable.card8));
    	images.add(getResources().getDrawable(R.drawable.card9));
    	images.add(getResources().getDrawable(R.drawable.card10));
    	images.add(getResources().getDrawable(R.drawable.card11));
    	images.add(getResources().getDrawable(R.drawable.card12));
    	images.add(getResources().getDrawable(R.drawable.card13));
    	images.add(getResources().getDrawable(R.drawable.card14));
    	images.add(getResources().getDrawable(R.drawable.card15));
    	images.add(getResources().getDrawable(R.drawable.card16));
    	images.add(getResources().getDrawable(R.drawable.card17));
    	images.add(getResources().getDrawable(R.drawable.card18));
    	images.add(getResources().getDrawable(R.drawable.card19));
    	images.add(getResources().getDrawable(R.drawable.card20));
    	images.add(getResources().getDrawable(R.drawable.card21));
		
	}

	private void carregaCartas(){
		try{
	    	int size = ROW_COUNT*COL_COUNT;
	    	
	    	Log.i("carregaCartas()","size=" + size);
	    	
	    	ArrayList<Integer> list = new ArrayList<Integer>();
	    	
	    	for(int i=0;i<size;i++){
	    		list.add(new Integer(i));
	    	}
	    	Random r = new Random();
	    
	    	for(int i=size-1;i>=0;i--){
	    		int t=0;
	    		
	    		if(i>0){
	    			t = r.nextInt(i);
	    		}
	    		
	    		t=list.remove(t).intValue();
	    		cartas[i%COL_COUNT][i/COL_COUNT]=t%(size/2);
	    		
	    		Log.i("carregaCartas()", "cartas["+(i%COL_COUNT)+
	    				"]["+(i/COL_COUNT)+"]=" + cartas[i%COL_COUNT][i/COL_COUNT]);
	    	}
	    }
		catch (Exception e) {
			Log.e("carregaCartas()", e+"");
		}
		
    }
    
    private TableRow createRow(int y){
    	 TableRow row = new TableRow(context);
    	 row.setHorizontalGravity(Gravity.CENTER);
         
         for (int x = 0; x < COL_COUNT; x++) {
		         row.addView(criaImagemBtn(x,y));
         }
         return row;
    }
    
    private View criaImagemBtn(int x, int y){
    	Button button = new Button(context);
    	button.setBackgroundDrawable(backImage);
    	button.setId(100*x+y);
    	button.setOnClickListener(buttonListener);
    	return button;
    }
    
    class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			
			synchronized (lock) {
				if(primeiraCarta!=null && segundaCarta != null){
					return;
				}
				int id = v.getId();
				int x = id/100;
				int y = id%100;
				viraCarta((Button)v,x,y);
			}
			
		}

		private void viraCarta(Button button,int x, int y) {
			button.setBackgroundDrawable(images.get(cartas[x][y]));
			
			if(primeiraCarta==null){
				primeiraCarta = new Cartas(button,x,y);
			}
			else{ 
				
				if(primeiraCarta.x == x && primeiraCarta.y == y){
					return; 
				}
					
				segundaCarta = new Cartas(button,x,y);
				
				vezes++;
				((TextView)findViewById(R.id.tv1)).setText("Tentativas: "+vezes);
				
			
				TimerTask tt = new TimerTask() {
					
					@Override
					public void run() {
						try{
							synchronized (lock) {
							  handler.sendEmptyMessage(0);
							}
						}
						catch (Exception e) {
							Log.e("E1", e.getMessage());
						}
					}
				};
				
				  Timer t = new Timer(false);
			        t.schedule(tt, 1300);
			}
			
				
		   }
			
		}
    
    class AtualizaCartasHandler extends Handler{
    	
    	@Override
    	public void handleMessage(Message msg) {
    		synchronized (lock) {
    			checaCartas();
    		}
    	}
    	
    	
    	 public void checaCartas(){
    	    	if(cartas[segundaCarta.x][segundaCarta.y] == cartas[primeiraCarta.x][primeiraCarta.y]){
    	    		primeiraCarta.button.setVisibility(View.INVISIBLE);
    	    		segundaCarta.button.setVisibility(View.INVISIBLE);
    	    		contAcertos += 2;
    			}
    			else {
    				segundaCarta.button.setBackgroundDrawable(backImage);
    				primeiraCarta.button.setBackgroundDrawable(backImage);
    			}
    	    	
    	    	primeiraCarta=null;
    			segundaCarta=null;
    	    }
    }
}