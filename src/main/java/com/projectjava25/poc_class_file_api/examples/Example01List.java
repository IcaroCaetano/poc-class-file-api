package com.project.poc_sequenced_collections.examples;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class Example01List {

    public static void execute() {

        System.out.println("========================================");
        System.out.println("Example 01 - SequencedCollection (List)");
        System.out.println("========================================");

        SequencedCollection<String> developers = new ArrayList<>();

        developers.add("João");
        developers.add("Maria");
        developers.add("Pedro");

        System.out.println("\nLista inicial:");
        System.out.println(developers);

        // Primeiro e último elemento
        System.out.println("\ngetFirst(): " + developers.getFirst());
        System.out.println("getLast(): " + developers.getLast());

        // Adicionando nas extremidades
        developers.addFirst("Carlos");
        developers.addLast("Ana");

        System.out.println("\nApós addFirst() e addLast():");
        System.out.println(developers);

        // Removendo das extremidades
        String first = developers.removeFirst();
        String last = developers.removeLast();

        System.out.println("\nremoveFirst(): " + first);
        System.out.println("removeLast(): " + last);

        System.out.println("\nLista após as remoções:");
        System.out.println(developers);

        // Visão invertida
        System.out.println("\nreversed():");
        developers.reversed()
                  .forEach(System.out::println);

        // A visão reversed acompanha alterações
        developers.addLast("José");

        System.out.println("\nApós adicionar 'José' na coleção original:");
        System.out.println("Original : " + developers);
        System.out.println("Reversed: " + developers.reversed());

        System.out.println();
    }
}