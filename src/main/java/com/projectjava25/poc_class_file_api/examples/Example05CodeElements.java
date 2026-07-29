package com.projectjava25.poc_class_file_api.examples;

import java.io.IOException;
import java.lang.classfile.Attributes;
import java.lang.classfile.CodeElement;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example05CodeElements {

    public static void execute() throws IOException {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Example 05 - Code Elements");
        System.out.println("========================================");

        Path path = Path.of(
                "build/classes/java/main/com/projectjava25/poc_class_file_api/model/Employee.class");

        byte[] bytes = Files.readAllBytes(path);

        ClassModel classModel = ClassFile.of().parse(bytes);

        for (MethodModel method : classModel.methods()) {

            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Method: " + method.methodName().stringValue());
            System.out.println("----------------------------------------");

            method.findAttribute(Attributes.code())
                    .ifPresent(code -> {

                        for (CodeElement element : code) {

                            System.out.println(element.getClass().getSimpleName()
                                    + " -> " + element);

                        }

                    });

        }

    }

}