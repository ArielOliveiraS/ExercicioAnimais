package com.example.exercicioanimais.View;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.exercicioanimais.Interfaces.Comunicador;
import com.example.exercicioanimais.Model.Animal;
import com.example.exercicioanimais.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {
    private Button buttonCat;
    private Button buttonDog;
    private Comunicador comunicador;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            comunicador = (Comunicador) context;
        }catch (Exception ex){
            ex.getStackTrace();
        }

    }

    public ButtonFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_button, container, false);
        initView(view);


        buttonCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Animal gato = new Animal(R.drawable.cat, "Gato");
                comunicador.recebeAnimal(gato);
            }
        });

        buttonDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal cachorro = new Animal(R.drawable.dog, "Cachorro");
                comunicador.recebeAnimal(cachorro);
            }
        });
        return view;
    }

    private void initView(View view) {
        buttonDog.findViewById(R.id.buttonCachorro);
        buttonCat.findViewById(R.id.buttonGato);
    }

}
