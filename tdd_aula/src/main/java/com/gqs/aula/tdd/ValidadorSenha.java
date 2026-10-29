package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();
        if (senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }
        if (contarDigitos(senha) < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }
        return new ResultadoValidacao(erros);
    }

    private int contarDigitos(String senha) {
        int digitos = 0;
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) {
                digitos++;
            }
        }
        return digitos;
    }
}
