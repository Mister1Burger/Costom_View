package com.example.kapusta.elements;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kapusta on 10.09.2017.
 */

public class ResViewAdapter extends  RecyclerView.Adapter<ResViewAdapter.ElementViewHolder> {

    public ResViewAdapter(ArrayList<Object> objects, ElementListner listener) {
    }

    public ResViewAdapter(List<Element> elements) {
    }

    public ResViewAdapter(List<Element> elements, ResViewAdapter resViewAdapter) {
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_name;
        TextView tv_number;
        ImageView iv_symbol;

        ElementViewHolder(View itemView) {
            super(itemView);
            cv =  itemView.findViewById(R.id.cv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            iv_symbol = itemView.findViewById(R.id.iv_symbol);
        }
    }

    List<Element> elements;
    ElementListner listener;

    ResViewAdapter(List<Element> elements, ElementListner listener){
        this.elements = elements;
        this.listener = listener;
    }


    @Override
    public ResViewAdapter.ElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        ElementViewHolder pvh = new ElementViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ElementViewHolder holder, final int position) {
        holder.tv_name.setText(elements.get(position).name);
        holder.tv_number.setText("" +elements.get(position).number);
        holder.iv_symbol.setImageResource(elements.get(position).symbol);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.getElement(elements.get(position).info);
                showDialog(String.valueOf(listener));

            }
        });
    }
    public void add(Element element) {
        elements.add(element);
    }
    private void showDialog(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Info")
                .setMessage(s)
                .setIcon(R.drawable.info)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public int getItemCount() {
        return elements.size();
    }
    
}
