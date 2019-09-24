package com.triviaapp.conroller.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.triviaapp.R;
import com.triviaapp.model.DataModel;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Holder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<DataModel> list;

    public HistoryAdapter(Context context, ArrayList<DataModel> list) {
        this.context = context;
        this.list = list;
        inflater  = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.history_adapter,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Log.e("count",""+list.get(position).game);

        holder.txt_count.setText(list.get(position).game+". ");
        holder.txt_date.setText(list.get(position).date+"m");
        holder.txt_user_name.setText(list.get(position).name);
        holder.txt_question_one.setText(list.get(position).questionone);
        holder.txt_question_two.setText(list.get(position).questiontwo);
        holder.txt_answer_one.setText(list.get(position).answerone);
        holder.txt_answer_two.setText(list.get(position).answertwo);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView txt_count,txt_date,txt_user_name,
                txt_question_one,txt_answer_one,txt_question_two,txt_answer_two;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txt_count = itemView.findViewById(R.id.txt_count);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            txt_question_one = itemView.findViewById(R.id.txt_question_one);
            txt_answer_one = itemView.findViewById(R.id.txt_answer_one);
            txt_question_two = itemView.findViewById(R.id.txt_question_two);
            txt_answer_two = itemView.findViewById(R.id.txt_answer_two);
        }
    }
}
