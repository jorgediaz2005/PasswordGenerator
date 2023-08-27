
package com.milibreria;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    // Longitud mínima requerida para las contraseñas generadas
    private static final int MINIMUM_LENGTH = 8; // Cambia este valor según tus necesidades
    // Conjuntos de caracteres para construir la contraseña
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        //verifica si la longitud cumple con el minimo requerido
        if (length < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("La longitud de la contraseña es demasiado corta. Debe tener al menos " + MINIMUM_LENGTH + " caracteres.");
        }

        String characters = ""; // Inicializa una cadena vacía para contener los caracteres de la contraseña
        
        // Verifica cada opción y, si es verdadera, agrega el conjunto correspondiente de caracteres a la cadena 'characters'
        if (useLowercase) characters += LOWERCASE; // Agrega letras minúsculas si useLowercase es verdadero
        if (useUppercase) characters += UPPERCASE; // Agrega letras mayúsculas si useUppercase es verdadero
        if (useDigits) characters += DIGITS; // Agrega dígitos si useDigits es verdadero
        if (useSpecialChars) characters += SPECIAL_CHARACTERS; // Agrega caracteres especiales si useSpecialChars es verdadero
        
        // Verifica si se ha seleccionado al menos un tipo de carácter
        if (characters.isEmpty()) {
            throw new IllegalArgumentException("Se debe seleccionar al menos un tipo de carácter.");
        }

        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        
        // Genera cada caracter de la contraseña
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}

