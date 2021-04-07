package com.cursoandroid.listatarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cursoandroid.listatarefas.model.Tarefa;

import java.util.List;

public class TarefaDao implements ITarefaDao{
    private SQLiteDatabase escreve;
    private SQLiteDatabase leitura;

    public TarefaDao(Context c){
        DbHelper db = new DbHelper(c);
        escreve = db.getWritableDatabase();
        leitura = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv =  new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());
        try{
            escreve.insert(DbHelper.TABELA_TAREFAS,null, cv);
            Log.e("INFO","Sucesso ao cadastrar tarefa!");
        }catch (Exception e){
            Log.e("INFO","Erro ao salvar tarefa "+ e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
