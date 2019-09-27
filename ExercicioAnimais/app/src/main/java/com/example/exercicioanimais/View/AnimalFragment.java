package com.example.exercicioanimais.View;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exercicioanimais.Model.Animal;
import com.example.exercicioanimais.R;

import static com.example.exercicioanimais.View.MainActivity.ANIMAL_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment {
    private ImageView imagem;
    private TextView nomeAnimal;


    public AnimalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        initViews(view);

        if (!getArguments().isEmpty()) {
            Animal animal = getArguments().getParcelable(ANIMAL_KEY);

            if (animal != null) {
                Drawable drawable = getResources().getDrawable(animal.getImagem());
                imagem.setImageDrawable(drawable);
                nomeAnimal.setText(animal.getNome());
            }
        }
        return view;
    }
    private void initViews(View view) {
        imagem = view.findViewById(R.id.imageView);
        nomeAnimal = view.findViewById(R.id.textViewAnimal);
    }
}
