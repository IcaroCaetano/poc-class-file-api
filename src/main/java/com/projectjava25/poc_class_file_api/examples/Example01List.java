package com.projectjava25.poc_class_file_api.examples;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class Example01List {

    public static void execute() {

        System.out.println("========================================");
        System.out.println("Example 01 - SequencedCollection (List)");
        System.out.println("========================================");

        SequencedCollection<String> developers = new ArrayList<>();

        developers.add("Joao");
        developers.add("Maria");
        developers.add("Pedro");

        System.out.println("\nLista inicial:");
        System.out.println(developers);

        
        System.out.println("\ngetFirst(): " + developers.getFirst());
        System.out.println("getLast(): " + developers.getLast());

        
        developers.addFirst("Carlos");
        developers.addLast("Ana");

        System.out.println("\nApos addFirst() e addLast():");
        System.out.println(developers);

        
        String first = developers.removeFirst();
        String last = developers.removeLast();

        System.out.println("\nremoveFirst(): " + first);
        System.out.println("removeLast(): " + last);

        System.out.println("\nLista apos as remocoes:");
        System.out.println(developers);

        
        System.out.println("\nreversed():");
        developers.reversed()
                  .forEach(System.out::println);
        
developers.addLast("José");

        System.out.println("\nApos adicionar 'Jose' na coleção original:");
        System.out.println("Original : " + developers);
        System.out.println("Reversed: " + developers.reversed());

        System.out.println();
    }
}