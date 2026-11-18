package pe.saludpublica.model;

public final class ValidacionUtil {
    private ValidacionUtil() {}

    public static void requireNonNull(String value, String field) {
        if (value == null) {
            throw new IllegalArgumentException("El campo '" + field + "' es obligatorio");
        }
    }
}
