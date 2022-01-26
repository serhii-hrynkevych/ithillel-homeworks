package hrynkevych.serhii;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String pack = "hrynkevych.serhii";
        String path = "out\\production\\lesson29_ex39\\" + pack.replace('.', '\\');

        FindFiles findFiles = findFiles(path);
        List<String> listFoundNamesClasses = findNameClasses(pack, findFiles);
        ListClassInfo listClassInfo = generateListClassInfo(listFoundNamesClasses);

        System.out.println(listClassInfo + "\n");
        listClassInfo.sorted();
        System.out.println(listClassInfo + "\n");

        startMethod(listClassInfo);
    }

    private static FindFiles findFiles(String path) {
        FindFiles findFiles = new FindFiles();
        try {
            Files.walkFileTree(Paths.get(path), findFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findFiles;
    }

    private static List<String> findNameClasses(String pack, FindFiles findFiles) {
        List<String> listFoundNamesClasses = new ArrayList<>();

        List<Path> foundFiles = findFiles.getFoundFiles();
        for (Path file : foundFiles) {
            String[] name = file.toFile().getName().split("\\.");
            String simpleName = name[0];
            listFoundNamesClasses.add(pack + "." + simpleName);
        }
        return listFoundNamesClasses;
    }

    private static ListClassInfo generateListClassInfo(List<String> listFoundNamesClasses) {
        ListClassInfo listClassInfo = new ListClassInfo();

        for (String str : listFoundNamesClasses) {
            Class<?> value = null;
            try {
                value = Class.forName(str);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (value != null && value.isAnnotationPresent(Start.class)) {
                String simpleName = value.getSimpleName();
                String nameClass = value.getName();
                Start start = value.getAnnotation(Start.class);
                int priority = start.priority();
                String method = start.method();
                listClassInfo.addClassInfo(new ClassInfo(simpleName, nameClass, priority, method));
            }
        }
        return listClassInfo;
    }

    private static void startMethod(ListClassInfo listClassInfo) {
        for (int i = 0; i < listClassInfo.size(); i++) {
            String nameClass = listClassInfo.getClassInfo(i).getNameClass();
            String nameMethod = listClassInfo.getClassInfo(i).getMethod();
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
}
