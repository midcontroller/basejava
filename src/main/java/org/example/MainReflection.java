package org.example;

import org.example.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    static void main(String[] args) {
        Resume resume = new Resume();

        extractToString(resume);
    }

    private static void extractToString(Resume resume) {
        try {
            Method toStrigMethod = resume.getClass().getMethod("toString");
            String str = (String) toStrigMethod.invoke(resume);
            System.out.println(str);

        } catch (ReflectiveOperationException err) {
            Throwable cause = (err instanceof InvocationTargetException exc) ? exc.getCause() : err;
            System.out.println("Failed " + cause);
        }
    }
}
