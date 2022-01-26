package hrynkevych.serhii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassList {
    private final List<ClassInfo> classInfoList = new ArrayList<>();
    private int size = 0;

    public ClassList() {
    }

    public void addClassInfo(ClassInfo classInfo) {
        classInfoList.add(classInfo);
        size++;
    }

    public void addClassInfo(String simpleName, String nameClass, int priority, String method) {
        ClassInfo classInfo = new ClassInfo(simpleName, nameClass, priority, method);
        classInfoList.add(classInfo);
        size++;
    }

    public ClassInfo getClassInfo(int index) {
        return classInfoList.get(index);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return classInfoList.toString();
    }

    public void sorted() {
        Collections.sort(classInfoList);
    }
}
