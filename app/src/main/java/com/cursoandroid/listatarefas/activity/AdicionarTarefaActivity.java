package com.cursoandroid.listatarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cursoandroid.listatarefas.R;
import com.cursoandroid.listatarefas.helper.TarefaDao;
import com.cursoandroid.listatarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {
    private TextInputEditText editTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textTarefa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.itemSalvar:
                //Salvar
                if(!editTarefa.getText().toString().isEmpty()){
                    TarefaDao tarefaDao = new TarefaDao(getApplicationContext());
                    Tarefa t = new Tarefa();
                    t.setNomeTarefa(editTarefa.getText().toString());
                    tarefaDao.salvar(t);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"O campo do nome da tarefa é obrigatorio!",Toast.LENGTH_LONG).show();
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}