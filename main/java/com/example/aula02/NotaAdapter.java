package com.example.aula02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {

    Context context;
    ArrayList<String> notas;

    public NotaAdapter(Context context, ArrayList<String> notas) {
        this.context = context;
        this.notas = notas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.nota_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotaAdapter.ViewHolder holder, int position) {
        holder.notasTexto.setText(notas.get(position));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView notasTexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notasTexto = itemView.findViewById(R.id.notasTexto);

        }


    }
}
