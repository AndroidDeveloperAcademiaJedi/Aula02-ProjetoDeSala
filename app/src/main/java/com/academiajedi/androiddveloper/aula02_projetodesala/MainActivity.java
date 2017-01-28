package com.academiajedi.androiddveloper.aula02_projetodesala;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText etNome;
    private EditText etIdade;

    private ListView lvUsuarios;
    private ArrayList<Pessoa> pessoas;
    private ArrayAdapter<Pessoa> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","onCreate");

        etNome = (EditText)findViewById(R.id.etNome);
        etIdade = (EditText)findViewById(R.id.etIdade);

        if (savedInstanceState != null) {
            pessoas = savedInstanceState.getParcelableArrayList("pessoas");
        } else {
            pessoas = new ArrayList<>();
        }

        lvUsuarios = (ListView) findViewById(R.id.lvUsuarios);
        adapter = new ArrayAdapter<Pessoa>(MainActivity.this, android.R.layout.simple_list_item_1, pessoas);
        lvUsuarios.setAdapter(adapter);

        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pessoa p = (Pessoa) parent.getItemAtPosition(position);

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("pessoa", p);
                startActivity(i);
            }
        });

        btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!etIdade.getText().toString().trim().equals("") && !etNome.getText().toString().trim().equals("")) {
                    Pessoa pessoa = new Pessoa(etNome.getText().toString(), Integer.parseInt(etIdade.getText().toString()));
                    pessoas.add(pessoa);
                    adapter.notifyDataSetChanged();

                    etNome.setText("");
                    etIdade.setText("");
                } else {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Aviso")
                            .setMessage("Por favor, preencha todos os campos")
                            .setNeutralButton("OK", null)
                            .show();
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("pessoas", pessoas);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause");
    }
}
