package pe.saludpublica.model;

public final class ValidacionUtil {
    private ValidacionUtil() {}

    // Para validar objetos de cualquier tipo
    public static <T> T requireNonNull(T value, String field) {
        if (value == null) {
            throw new IllegalArgumentException("El campo '" + field + "' es obligatorio");
        }
        return value;
    }
}
