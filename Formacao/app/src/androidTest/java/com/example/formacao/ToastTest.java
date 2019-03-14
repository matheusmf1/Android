package com.example.formacao;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToastTest {

    @Test
    public void showToast() {
        String retornoEsperado = "Hello World by Toast";
        String retornoFeito = "CHECK HOW TO GET TOAST INFORMATIONS";
        assertEquals(retornoEsperado,retornoFeito);
    }

}