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
            ├── model
            │      Employee.java
            │
            ├── examples
            │      Example01ReadClass.java
            │      Example02Fields.java
            │      Example03Methods.java
            │      Example04Interfaces.java
            │      Example05Bytecode.java
            
````

## O problema

### Antes do Java 24, quem precisava manipular bytecode utilizava:

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


## Output


## Example 1

````
========================================
Example 01 - SequencedCollection (List)
========================================

Lista inicial:
[Joao, Maria, Pedro]

getFirst(): Joao
getLast(): Pedro

Apos addFirst() e addLast():
[Carlos, Joao, Maria, Pedro, Ana]

removeFirst(): Carlos
removeLast(): Ana

Lista apos as remocoes:
[Joao, Maria, Pedro]

reversed():
Pedro
Maria
Joao

Apos adicionar 'Jose' na colecao original:
Original : [Joao, Maria, Pedro, Jose]
Reversed: [Jose, Pedro, Maria, Joao]

````
## Example 2

````
========================================
Example 02 - Fields
========================================

Fields encontrados:

Nome : id
Tipo : Ljava/lang/Long;
------------------------------
Nome : name
Tipo : Ljava/lang/String;
------------------------------
Nome : department
Tipo : Ljava/lang/String;
------------------------------
````

## Example 3

````
========================================
Example 03 - Methods
========================================
Metodos encontrados:

Nome.......: <init>
Descriptor.: ()V
--------------------------------
Nome.......: <init>
Descriptor.: (Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V
--------------------------------
Nome.......: getId
Descriptor.: ()Ljava/lang/Long;
--------------------------------
Nome.......: getName
Descriptor.: ()Ljava/lang/String;
--------------------------------
Nome.......: getDepartment
Descriptor.: ()Ljava/lang/String;
--------------------------------
`````

## Example 4

````
========================================
Example 04 - Bytecode
========================================

Method: <init>
LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
Label[context=CodeModel[id=925858445], bci=0]
LineNumber[line=9]
Load[OP=ALOAD_0, slot=0]
Invoke[OP=INVOKESPECIAL, m=java/lang/Object.<init>()V]
LineNumber[line=10]
Return[OP=RETURN]
Label[context=CodeModel[id=925858445], bci=5]

Method: <init>
LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
LocalVariable[name=id, slot=1, type=Ljava/lang/Long;]
LocalVariable[name=name, slot=2, type=Ljava/lang/String;]
LocalVariable[name=department, slot=3, type=Ljava/lang/String;]
Label[context=CodeModel[id=804564176], bci=0]
LineNumber[line=12]
Load[OP=ALOAD_0, slot=0]
Invoke[OP=INVOKESPECIAL, m=java/lang/Object.<init>()V]
LineNumber[line=13]
Load[OP=ALOAD_0, slot=0]
Load[OP=ALOAD_1, slot=1]
Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.id:Ljava/lang/Long;]
LineNumber[line=14]
Load[OP=ALOAD_0, slot=0]
Load[OP=ALOAD_2, slot=2]
Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.name:Ljava/lang/String;]
LineNumber[line=15]
Load[OP=ALOAD_0, slot=0]
Load[OP=ALOAD_3, slot=3]
Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.department:Ljava/lang/String;]
LineNumber[line=16]
Return[OP=RETURN]
Label[context=CodeModel[id=804564176], bci=20]

Method: getId
LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
Label[context=CodeModel[id=1421795058], bci=0]
LineNumber[line=19]
Load[OP=ALOAD_0, slot=0]
Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.id:Ljava/lang/Long;]
Return[OP=ARETURN]
Label[context=CodeModel[id=1421795058], bci=5]

Method: getName
LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
Label[context=CodeModel[id=1555009629], bci=0]
LineNumber[line=23]
Load[OP=ALOAD_0, slot=0]
Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.name:Ljava/lang/String;]
Return[OP=ARETURN]
Label[context=CodeModel[id=1555009629], bci=5]

Method: getDepartment
LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
Label[context=CodeModel[id=41359092], bci=0]
LineNumber[line=27]
Load[OP=ALOAD_0, slot=0]
Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.department:Ljava/lang/String;]
Return[OP=ARETURN]
Label[context=CodeModel[id=41359092], bci=5]

````
## Example 5

````plantuml
========================================
Example 05 - Code Elements
========================================

----------------------------------------
Method: <init>
----------------------------------------
BoundLocalVariable -> LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
LabelImpl -> Label[context=CodeModel[id=1160460865], bci=0]
LineNumberImpl -> LineNumber[line=9]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
BoundInvokeInstruction -> Invoke[OP=INVOKESPECIAL, m=java/lang/Object.<init>()V]
LineNumberImpl -> LineNumber[line=10]
UnboundReturnInstruction -> Return[OP=RETURN]
LabelImpl -> Label[context=CodeModel[id=1160460865], bci=5]

----------------------------------------
Method: <init>
----------------------------------------
BoundLocalVariable -> LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
BoundLocalVariable -> LocalVariable[name=id, slot=1, type=Ljava/lang/Long;]
BoundLocalVariable -> LocalVariable[name=name, slot=2, type=Ljava/lang/String;]
BoundLocalVariable -> LocalVariable[name=department, slot=3, type=Ljava/lang/String;]
LabelImpl -> Label[context=CodeModel[id=1247233941], bci=0]
LineNumberImpl -> LineNumber[line=12]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
BoundInvokeInstruction -> Invoke[OP=INVOKESPECIAL, m=java/lang/Object.<init>()V]
LineNumberImpl -> LineNumber[line=13]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
UnboundLoadInstruction -> Load[OP=ALOAD_1, slot=1]
BoundFieldInstruction -> Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.id:Ljava/lang/Long;]
LineNumberImpl -> LineNumber[line=14]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
UnboundLoadInstruction -> Load[OP=ALOAD_2, slot=2]
BoundFieldInstruction -> Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.name:Ljava/lang/String;]
LineNumberImpl -> LineNumber[line=15]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
UnboundLoadInstruction -> Load[OP=ALOAD_3, slot=3]
BoundFieldInstruction -> Field[OP=PUTFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.department:Ljava/lang/String;]
LineNumberImpl -> LineNumber[line=16]
UnboundReturnInstruction -> Return[OP=RETURN]
LabelImpl -> Label[context=CodeModel[id=1247233941], bci=20]

----------------------------------------
Method: getId
----------------------------------------
BoundLocalVariable -> LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
LabelImpl -> Label[context=CodeModel[id=258952499], bci=0]
LineNumberImpl -> LineNumber[line=19]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
BoundFieldInstruction -> Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.id:Ljava/lang/Long;]
UnboundReturnInstruction -> Return[OP=ARETURN]
LabelImpl -> Label[context=CodeModel[id=258952499], bci=5]

----------------------------------------
Method: getName
----------------------------------------
BoundLocalVariable -> LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
LabelImpl -> Label[context=CodeModel[id=603742814], bci=0]
LineNumberImpl -> LineNumber[line=23]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
BoundFieldInstruction -> Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.name:Ljava/lang/String;]
UnboundReturnInstruction -> Return[OP=ARETURN]
LabelImpl -> Label[context=CodeModel[id=603742814], bci=5]

----------------------------------------
Method: getDepartment
----------------------------------------
BoundLocalVariable -> LocalVariable[name=this, slot=0, type=Lcom/projectjava25/poc_class_file_api/model/Employee;]
LabelImpl -> Label[context=CodeModel[id=1067040082], bci=0]
LineNumberImpl -> LineNumber[line=27]
UnboundLoadInstruction -> Load[OP=ALOAD_0, slot=0]
BoundFieldInstruction -> Field[OP=GETFIELD, field=com/projectjava25/poc_class_file_api/model/Employee.department:Ljava/lang/String;]
UnboundReturnInstruction -> Return[OP=ARETURN]
LabelImpl -> Label[context=CodeModel[id=1067040082], bci=5]
````