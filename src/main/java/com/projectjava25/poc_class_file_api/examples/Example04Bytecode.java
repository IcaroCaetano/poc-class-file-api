package com.projectjava25.poc_class_file_api.examples;

import java.io.IOException;
import java.lang.classfile.*;
import java.lang.classfile.attribute.CodeAttribute;
import java.nio.file.Files;
import java.nio.file.Path;

public class Example04Bytecode {

    public static void execute() throws IOException {

        System.out.println();
        System.out.println("========================================");
        System.out.println("Example 04 - Bytecode");
        System.out.println("========================================");

        Path classFile = Path.of("build/classes/java/main/com/projectjava25/poc_class_file_api/model/Employee.class");

        byte[] bytes = Files.readAllBytes(classFile);

        ClassModel model = ClassFile.of().parse(bytes);

        for (MethodModel method : model.methods()) {

            System.out.println();
            System.out.println("Method: " + method.methodName().stringValue());

            method.findAttribute(Attributes.code())
                    .ifPresent(code -> {

                        for (CodeElement element : code) {
                            System.out.println(element);
                        }

                    });

        }

    }

    private static void printInstructions(CodeModel codeModel) {

        codeModel.forEach(element -> {

            System.out.println("   " + element);

        });

    }

}