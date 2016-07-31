package com.rubach.petagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubach.petagram.Mascota;
import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.R;

import java.util.ArrayList;


public class RecicleViewFragment extends Fragment {

    ArrayList<Mascota> Mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.fragment_recicleview,container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        //para mostrarlo como una lista
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //para verlo como un grid
        //GridLayoutManager glm=new GridLayoutManager(this,2); //2= cantidad de objetos x linea

        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        MascotaAdaptador adaptador=new MascotaAdaptador(Mascotas,getActivity());
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
    }


    public void InicializarListaMascotas(){

        Mascotas=new ArrayList<Mascota>();

        Mascotas.add(new Mascota("Gato",4, R.drawable.pet1));
        Mascotas.add(new Mascota("Perro",5, R.drawable.pet2));
        Mascotas.add(new Mascota("Tom",4, R.drawable.pet3));
        Mascotas.add(new Mascota("Jerry",3, R.drawable.pet4));
        Mascotas.add(new Mascota("Spice",2, R.drawable.pet5));

    }
}
