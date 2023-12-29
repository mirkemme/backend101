package org.example.backend101.utils;

/* Verifica se il carattere in input è una lettera */
public class StringUtils {
    private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z]+$";

    public static boolean isAlphanumeric(final Character input) {
        return input.toString().matches(ALPHANUMERIC_PATTERN);
    }
}
