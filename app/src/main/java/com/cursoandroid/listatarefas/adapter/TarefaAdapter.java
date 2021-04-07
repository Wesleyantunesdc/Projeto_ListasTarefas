package com.cursoandroid.listatarefas.adapter;

import android.telephony.ims.ImsMmTelManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursoandroid.listatarefas.R;
import com.cursoandroid.listatarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {
    private List<Tarefa> listaTarefa = new ArrayList<>();

    public TarefaAdapter(List<Tarefa> lista){
        this.listaTarefa = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lsita_tarefa_adapter,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tarefa tarefa = listaTarefa.get(position);
        holder.tarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return listaTarefa.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView tarefa;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tarefa = itemView.findViewById(R.id.textTarefa);
        }
    }


}
