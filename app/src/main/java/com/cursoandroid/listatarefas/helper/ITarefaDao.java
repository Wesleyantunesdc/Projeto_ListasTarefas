package com.cursoandroid.listatarefas.helper;

import com.cursoandroid.listatarefas.model.Tarefa;

import java.util.List;

public interface ITarefaDao {

    public boolean salvar(Tarefa tarefa);
    public  boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
