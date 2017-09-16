package com.example.kapusta.elements;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by java on 13.09.2017.
 */

public class FirstFragment extends Fragment{
    private List<Element> elements;
    RecyclerView resView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        resView = (RecyclerView) view.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        resView.setLayoutManager(llm);


        ResViewAdapter adapter = new ResViewAdapter(elements, new ResViewAdapter(new ArrayList<Element>(), (ElementListner) info -> {
            Log.d("TAG", String.valueOf(info));
            showDialog(info);
        }));
        resView.setAdapter(adapter);



            elements = new ArrayList<>();
        Observable.just(elements)
                .doOnNext(elements -> elements.add(new Element("Lithium", "soft, silvery-white alkali metal", 3, R.drawable.lithium)))
                .doOnNext(elements -> elements.add(new Element("Aluminium", "silvery-white, soft, nonmagnetic, ductile metal", 13, R.drawable.aluminium)))
                .doOnNext(elements -> elements.add(new Element("Titanium", "lustrous transition metal with a silver color, low density, and high strength", 22, R.drawable.titanium)))
                .flatMap(Observable::fromIterable)
                .doOnNext(adapter::add)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(elements -> Log.d("TAG", String.valueOf(elements)),throwable -> Log.i("TAG", "exeption") );


        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    private void showDialog(String s){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
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
}
