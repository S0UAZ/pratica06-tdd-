package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();
        return new ResultadoValidacao(erros);
    }
}
