package com.academiajedi.androiddveloper.aula02_projetodesala;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by alexsoaresdesiqueira on 27/01/17.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvIdade;
    private Pessoa pessoa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("SecondActivity","onCreate");

        tvNome = (TextView)findViewById(R.id.tvNome);
        tvIdade = (TextView)findViewById(R.id.tvIdade);

        Intent i = getIntent();
        pessoa = i.getParcelableExtra("pessoa");

        if (pessoa != null) {
            tvNome.setText(pessoa.getNome());
            tvIdade.setText(Integer.toString(pessoa.getIdade()));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SecondActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SecondActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SecondActivity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SecondActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SecondActivity","onPause");
    }
}
