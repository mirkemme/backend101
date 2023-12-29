package org.example.backend101.utils;

/* Verifica se il carattere in input è una lettera */
public class StringUtils {
    private static final String LETTER_PATTERN = "^[a-zA-Z]+$";

    public static boolean isAlphanumeric(final Character input) {
        return input.toString().matches(LETTER_PATTERN);
    }
}
