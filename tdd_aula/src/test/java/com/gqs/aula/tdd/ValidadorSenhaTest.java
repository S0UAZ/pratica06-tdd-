package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    // Ciclo 1 - tamanho minimo
    @Test
    void deveRejeitarSenhaComMenosDe8Caracteres() {
        ResultadoValidacao resultado = validador.validar("Ab12!cd");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve ter pelo menos 8 caracteres"), resultado.getErros());
    }

    // Ciclo 2 - pelo menos 2 digitos
    @Test
    void deveRejeitarSenhaComMenosDe2Digitos() {
        ResultadoValidacao resultado = validador.validar("Abcdefg1!");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve conter pelo menos 2 dígitos"), resultado.getErros());
    }

    // Ciclo 3 - pelo menos uma letra maiuscula
    @Test
    void deveRejeitarSenhaSemLetraMaiuscula() {
        ResultadoValidacao resultado = validador.validar("abcdef12!");
        assertFalse(resultado.isValida());
        assertEquals(Arrays.asList("A senha deve conter pelo menos uma letra maiuscula"), resultado.getErros());
    }
}
