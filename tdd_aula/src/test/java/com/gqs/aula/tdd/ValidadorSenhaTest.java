package com.gqs.aula.tdd;

import static com.gqs.aula.tdd.ValidadorSenha.ERRO_DIGITOS;
import static com.gqs.aula.tdd.ValidadorSenha.ERRO_ESPECIAL;
import static com.gqs.aula.tdd.ValidadorSenha.ERRO_MAIUSCULA;
import static com.gqs.aula.tdd.ValidadorSenha.ERRO_TAMANHO;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    private void assertInvalida(String senha, String... errosEsperados) {
        ResultadoValidacao resultado = validador.validar(senha);
        assertFalse(resultado.isValida());
        List<String> esperado = Arrays.asList(errosEsperados);
        assertEquals(esperado, resultado.getErros());
    }

    // Ciclo 1 - tamanho minimo
    @Test
    void deveRejeitarSenhaComMenosDe8Caracteres() {
        assertInvalida("Ab12!cd", ERRO_TAMANHO);
    }

    // Ciclo 2 - pelo menos 2 digitos
    @Test
    void deveRejeitarSenhaComMenosDe2Digitos() {
        assertInvalida("Abcdefg1!", ERRO_DIGITOS);
    }

    // Ciclo 3 - pelo menos uma letra maiuscula
    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        assertInvalida("abcdef12!", ERRO_MAIUSCULA);
    }

    // Ciclo 4 - pelo menos um caractere especial
    @Test
    void deveRejeitarSenhaSemCaractereEspecial() {
        assertInvalida("Abcdef12", ERRO_ESPECIAL);
    }

    // Ciclo 5 - multiplos erros e senha valida
    @Test
    void deveRetornarTodosOsErrosParaMypass() {
        assertInvalida("mypass", ERRO_TAMANHO, ERRO_DIGITOS, ERRO_MAIUSCULA, ERRO_ESPECIAL);
    }

    @Test
    void deveAceitarSenhaValida() {
        ResultadoValidacao resultado = validador.validar("Abcdef12!");
        assertTrue(resultado.isValida());
        assertTrue(resultado.getErros().isEmpty());
    }

    // Ciclo 6 - senha nula
    @Test
    void deveTratarSenhaNulaComoInvalida() {
        assertInvalida(null, ERRO_TAMANHO, ERRO_DIGITOS, ERRO_MAIUSCULA, ERRO_ESPECIAL);
    }
}
