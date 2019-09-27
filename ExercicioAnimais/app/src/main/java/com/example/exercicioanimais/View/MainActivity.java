package com.example.exercicioanimais.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.exercicioanimais.Interfaces.Comunicador;
import com.example.exercicioanimais.Model.Animal;
import com.example.exercicioanimais.R;

public class MainActivity extends AppCompatActivity  implements Comunicador {

    public static final String ANIMAL_KEY = "animal";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recarrecarFragment (R.id.containerButton, new ButtonFragment());

    }
    private void recarrecarFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    @Override
    public void recebeAnimal(Animal animal) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);

        Fragment animalFragment = new AnimalFragment();
        animalFragment.setArguments(bundle);

        recarrecarFragment(R.id.container1, animalFragment);
    }
}
