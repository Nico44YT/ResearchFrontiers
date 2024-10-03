package nazario.liby.registry;

import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class LibyRegistryLoader {
    public static void load(String path) {
        Reflections reflections = new Reflections(path);

        Set<Class<? extends LibyRegistry>> registryClasses = reflections.getSubTypesOf(LibyRegistry.class);

        for (Class<? extends LibyRegistry> clazz : registryClasses) {
            try {
                // Get the static register method from the class
                Method registerMethod = clazz.getDeclaredMethod("register");

                // Check if the method is static, then invoke it
                if (java.lang.reflect.Modifier.isStatic(registerMethod.getModifiers())) {
                    registerMethod.invoke(null);  // null because it's a static method
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
