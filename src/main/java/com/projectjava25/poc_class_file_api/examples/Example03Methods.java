package com.projectjava25.poc_class_file_api.examples;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.MethodModel;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example03Methods {

    public static void execute() throws IOException {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Example 03 - Methods");
        System.out.println("========================================");

        Path classFile = Path.of("build/classes/java/main/com/project/poc_class_file_api/dto/Employee.class");

        byte[] bytes = Files.readAllBytes(classFile);

        ClassModel classModel = ClassFile.of().parse(bytes);

        System.out.println("Métodos encontrados:\n");

        for (MethodModel method : classModel.methods()) {

            System.out.println("Nome.......: "
                    + method.methodName().stringValue());

            System.out.println("Descriptor.: "
                    + method.methodType().stringValue());

            System.out.println("--------------------------------");
        }
    }

}