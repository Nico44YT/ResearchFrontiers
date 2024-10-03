package nazario.liby.registry.auto;

import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class LibyRegistryLoader {

    public static void load(String path) {
        Reflections reflections = new Reflections(path);

        // Find all classes annotated with @AutoRegister
        Set<Class<?>> registryClasses = reflections.getTypesAnnotatedWith(LibyAutoRegister.class);

        // List to hold classes and their priorities
        List<ClassWithPriority> classList = new ArrayList<>();

        // Iterate over annotated classes
        for (Class<?> clazz : registryClasses) {
            try {
                // Check if the class has the @AutoRegister annotation
                if (clazz.isAnnotationPresent(LibyAutoRegister.class)) {
                    // Get the annotation instance
                    LibyAutoRegister annotation = clazz.getAnnotation(LibyAutoRegister.class);

                    // Get the priority from the annotation
                    int priority = annotation.priority();
                    String registerMethodName = annotation.register();

                    // Add class and its priority to the list
                    classList.add(new ClassWithPriority(clazz, priority, registerMethodName));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Sort the classes by priority (ascending)
        classList.sort(Comparator.comparingInt(ClassWithPriority::getPriority));

        // Now call the static register method in priority order
        for (ClassWithPriority classWithPriority : classList) {
            Class<?> clazz = classWithPriority.getClazz();
            try {
                // Get and invoke the static register method
                Method registerMethod = clazz.getDeclaredMethod(classWithPriority.getRegisterMethodName());
                if (java.lang.reflect.Modifier.isStatic(registerMethod.getModifiers())) {
                    registerMethod.invoke(null);  // null because it's a static method
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Helper class to store class and its priority
    static class ClassWithPriority {
        private final Class<?> clazz;
        private final int priority;
        private final String registerMethodName;

        public ClassWithPriority(Class<?> clazz, int priority, String registerMethodName) {
            this.clazz = clazz;
            this.priority = priority;
            this.registerMethodName = registerMethodName;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public int getPriority() {
            return priority;
        }

        public String getRegisterMethodName() {
            return registerMethodName;
        }
    }
}
