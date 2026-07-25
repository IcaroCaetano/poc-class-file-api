package com.project.poc_class_file_api.examples;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.FieldModel;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example02Fields {

    public static void execute() throws IOException {
        System.out.println("Example 02 - Fields");

        Path classFile = Path.of(
                "build/classes/java/main/com/project/poc_class_file_api/model/Employee.class"
        );

        byte[] bytes = Files.readAllBytes(classFile);

        ClassModel classModel = ClassFile
                .of()
                .parse(bytes);

        System.out.println("Fields encontrados:\n");

        for (FieldModel field : classModel.fields()) {

            System.out.println("Nome : " + field.fieldName().stringValue());

            System.out.println("Tipo : "
                    + field.fieldType().stringValue());

            System.out.println("------------------------------");
        }

    }

}