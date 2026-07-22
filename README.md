# Poc Class File Api


## Structure

````plantuml
src
└── main
    └── java
        └── com.project.poc_class_file_api
            │
            ├── Main.java
            │
            ├── dto
            │      Employee.java
            │
            ├── examples
            │      Example01ReadClass.java
            │      Example02Fields.java
            │      Example03Methods.java
            │      Example04Interfaces.java
            │      Example05Bytecode.java
            │      Example06GenerateClass.java
            │      Example07TransformClass.java
            │
            └── util
                   ClassPrinter.java
````

## O problema

Antes do Java 24, quem precisava manipular bytecode utilizava:

- ASM
- BCEL
- Javassist
- ByteBuddy (internamente usa ASM)

Cada biblioteca possuía sua própria API.

## O que o Java trouxe

Uma API oficial para:

- ler arquivos .class
- gerar bytecode
- transformar classes


## Antes de começar

A Class-File API não foi criada para substituir Reflection.

Ela trabalha em um nível mais baixo.

A arquitetura é mais ou menos esta:

````plantuml
                    Código Java
                         │
                         ▼
                     javac
                         │
                         ▼
                   Employee.class
                         │
                         ▼
                 ClassFile API
                         │
        ┌────────────────┼────────────────┐
        ▼                ▼                ▼
   ClassModel      MethodModel      FieldModel
        │                │                │
        ▼                ▼                ▼
  Constant Pool     Bytecode        Attributes
````