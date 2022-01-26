package hrynkevych.serhii;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        ClassList classList = new ClassList();
        Class<?>[] classes = new Class[]{Foo1.class, Foo2.class, Foo3.class, Foo4.class, Foo5.class};

        for (Class<?> value : classes) {
            if (value.isAnnotationPresent(Start.class)) {
                String simpleName = value.getSimpleName();
                String nameClass = value.getName();
                Annotation[] annotations = value.getAnnotations();
                classList.addClassInfo(createClassInfo(simpleName, nameClass, annotations));
            }
        }

        System.out.println(classList);
        System.out.println();
        classList.sorted();
        System.out.println(classList);
        System.out.println();

        for (int i = 0; i < classList.size(); i++) {
            String nameClass = classList.getClassInfo(i).getNameClass();
            String nameMethod = classList.getClassInfo(i).getMethod();
            try {
                Class<?> c = Class.forName(nameClass);
                Constructor<?> cons = c.getConstructor();
                Object object = cons.newInstance();
                Method method = object.getClass().getDeclaredMethod(nameMethod);
                method.invoke(object);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    private static ClassInfo createClassInfo(String simpleName, String nameClass, Annotation[] annotations) {
        int priority = 0;
        String method = null;
        for (Annotation annotation : annotations) {
            if (annotation instanceof Start) {
                Start start = (Start) annotation;
                priority = start.priority();
                method = start.method();
            }
        }
        return new ClassInfo(simpleName, nameClass, priority, method);
    }
}
