package com.cursoandroid.listatarefas.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import com.cursoandroid.listatarefas.R;
import com.cursoandroid.listatarefas.adapter.TarefaAdapter;
import com.cursoandroid.listatarefas.helper.DbHelper;
import com.cursoandroid.listatarefas.helper.RecyclerItemClickListener;
import com.cursoandroid.listatarefas.helper.TarefaDao;
import com.cursoandroid.listatarefas.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView componenteLista;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        componenteLista = findViewById(R.id.lista);
        componenteLista.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), componenteLista, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.i("clique","Item Clicado");
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Log.i("clique","Item Selecionado");
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarListaTarefas();
    }



    public void carregarListaTarefas(){
        //Listar Tarefas
        TarefaDao tarefaDao = new TarefaDao(getApplicationContext());
        List<Tarefa> listaTarefa = tarefaDao.listar();

        //Configurar um adapter
        tarefaAdapter = new TarefaAdapter(listaTarefa);
        //Configurar recycleview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        componenteLista.setLayoutManager(layoutManager);
        componenteLista.setHasFixedSize(true);
        componenteLista.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        componenteLista.setAdapter(tarefaAdapter);
//            componenteLista.setAdapter();
    }
}