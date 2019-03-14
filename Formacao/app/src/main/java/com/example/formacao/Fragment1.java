package com.example.formacao;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

// Ao invés de construir sua interface no onCreate, utilizamos o evento onCreateView do Fragment1.
// O onCreateView é onde você constrói ou infla sua interface, faz conexão com alguma fonte de dados
// e retorna à Activity pai para poder integrá-lo em sua hierarquia de Views.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        return v;
    }
}
