package com.unb.agenda2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unb.agenda2.Entidades.Contato;

public class Contact_new extends Activity {
	
	
	 public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.adicionar_contato);
			Button add = (Button) findViewById(R.id.button1);
			add.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					TextView nome = (TextView) findViewById(R.id.nome_text);
					TextView telefone = (TextView) findViewById(R.id.telefone_text);
					TextView email = (TextView) findViewById(R.id.email_text);
					
					Contato novo = new Contato(1,nome.getText().toString(),telefone.getText().toString(),email.getText().toString());
					Contato.agenda.add(novo);
					finish();
				}
			});
			
	    }
}
