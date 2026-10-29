package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultadoValidacao {

    private final List<String> erros;

    public ResultadoValidacao(List<String> erros) {
        this.erros = new ArrayList<>(erros);
    }

    public boolean isValida() {
        return erros.isEmpty();
    }

    public List<String> getErros() {
        return Collections.unmodifiableList(erros);
    }
}
