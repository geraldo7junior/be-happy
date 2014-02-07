package database;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

public class EnterProcess extends AsyncTask<EditText, String, Integer> {
		 
        private ProgressDialog progress;
        private Context context;
 
        public EnterProcess(Context context) {
            this.context = context;
        }
 
        @Override
        protected void onPreExecute() {
            //Cria novo um ProgressDialogo e exibe
            progress = new ProgressDialog(context);
            progress.setMessage("Aguarde...");
            progress.show();
        }
 
        @Override
        protected Integer doInBackground(EditText... paramss) {
        	
        	EditText etUsuario,etSenha;
        	etUsuario = paramss[0];
        	etSenha = paramss[1];
        	
        	//Encryption cryp = new Encryption();
        	//String senhaCryp = cryp.Encrypt(etSenha.getText().toString(), "sha1");        	
        	
        	Log.i("logar","entrou no evento -- " + etSenha);
			String urlPost = "http://behappy.robugos.com/login.php" ; //ip remoto e o login eh o arquivo que faz a verificação no BD
			//String urlGet = "http://179.163.149.77/android/login.php?username="+etUsuario.getText().toString()+"&password="+etSenha.getText().toString();
			ArrayList<NameValuePair> parametrosPost = new ArrayList<NameValuePair>();
			parametrosPost.add(new BasicNameValuePair("username",etUsuario.getText().toString()));
			parametrosPost.add(new BasicNameValuePair("password",etSenha.getText().toString()));
			String respostaRetornada = null;
			Log.i("logar","vai entrar no try");
			try{
				Thread.sleep(10);
				respostaRetornada = ConexaoHttpClient.executaHttpPost(urlPost, parametrosPost);
				String resposta = respostaRetornada.toString();
				Log.i("LogarTry","resposta = "+resposta);
				resposta = resposta.replaceAll("\\s+", "");
				if (resposta.equals("1")){
					Log.i("LogarIf","resposta = "+resposta);
					return 1;
				}
					
				else{
					Log.i("LogarElse","resposta = "+resposta);
					return 0;
				}
					
			}
			catch(Exception erro){
				Log.i("erro","erro ="+erro);
				return 0;
			}
        }
 
        @Override
        protected void onPostExecute(Integer result) {
            //Cancela progressDialogo
            progress.dismiss();
        }
    }
