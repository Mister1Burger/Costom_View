package com.example.kapusta.elements;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ResViewAdapter.OnItemClic {

//    @BindView(R2.id.rv)
    RecyclerView resView;

    private List<Element> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        resView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        resView.setLayoutManager(llm);
        initializeData();

        ResViewAdapter adapter = new ResViewAdapter(elements, this);
        resView.setAdapter(adapter);
    }
    private void initializeData(){
        elements = new ArrayList<>();
        elements.add(new Element("Lithium", "soft, silvery-white alkali metal", 3, R.drawable.lithium));
        elements.add(new Element("Aluminium", "silvery-white, soft, nonmagnetic, ductile metal", 13, R.drawable.aluminium));
        elements.add(new Element("Titanium", "lustrous transition metal with a silver color, low density, and high strength", 22, R.drawable.titanium));
    }

    private void showDialog(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
    public void ontemClick(String info) {
        showDialog(info);
    }
}
