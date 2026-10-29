package com.gqs.aula.tdd;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static final int TAMANHO_MINIMO = 8;
    public static final int MINIMO_DIGITOS = 2;

    public static final String ERRO_TAMANHO = "A senha deve ter pelo menos 8 caracteres";
    public static final String ERRO_DIGITOS = "A senha deve conter pelo menos 2 dígitos";
    public static final String ERRO_MAIUSCULA = "A senha deve conter pelo menos uma letra maiuscula";
    public static final String ERRO_ESPECIAL = "A senha deve conter pelo menos um caractere especial";

    public ResultadoValidacao validar(String senha) {
        String texto = naoNula(senha);
        List<String> erros = new ArrayList<>();
        if (texto.length() < TAMANHO_MINIMO) {
            erros.add(ERRO_TAMANHO);
        }
        if (contarDigitos(texto) < MINIMO_DIGITOS) {
            erros.add(ERRO_DIGITOS);
        }
        if (!temMaiuscula(texto)) {
            erros.add(ERRO_MAIUSCULA);
        }
        if (!temCaractereEspecial(texto)) {
            erros.add(ERRO_ESPECIAL);
        }
        return new ResultadoValidacao(erros);
    }

    private String naoNula(String senha) {
        if (senha == null) {
            return "";
        }
        return senha;
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

    private boolean temMaiuscula(String senha) {
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean temCaractereEspecial(String senha) {
        for (char c : senha.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }
}
