package registry;

import factory.AuthFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AuthFactoryRegistry {
    private static final AuthFactoryRegistry INSTANCE = new AuthFactoryRegistry();
    private final Map<String, Supplier<AuthFactory>> registry = new HashMap<>();

    // 🔒 Constructor privado para evitar instanciación externa
    private AuthFactoryRegistry() {}

    // 🌍 Método estático para obtener la única instancia
    public static AuthFactoryRegistry getInstance() {
        return INSTANCE;
    }

    // 🔹 Registrar nuevas fábricas en tiempo de ejecución
    public void registerFactory(String type, Class<? extends AuthFactory> factoryClass) {
        registry.put(type, () -> {
            try {
                return factoryClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Error al crear la fábrica", e);
            }
        });
    }

    // 🔹 Obtener una fábrica registrada
    public AuthFactory getFactory(String type) {
        Supplier<AuthFactory> supplier = registry.get(type);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("Método de autenticación no válido: " + type);
    }
}
