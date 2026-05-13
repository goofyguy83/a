# SPCC Lab ESE Programs

This repository contains simplified SPCC (System Programming and Compiler Construction) lab programs implemented in Java and Lex.

---

# Programs Included

1. Left Recursion Removal
2. FIRST and FOLLOW
3. LL(1) Parser
4. LR(1) Parser
5. Intermediate Code Generation
   - Infix to Postfix
   - Infix to Prefix
   - Quadruples
   - Triples
6. Assembler
7. Macro Processor
8. Loader / Linker
9. Lexical Analyzer (Java)
10. Lexical Analyzer (Lex Tool)

---

# Java Program Compilation and Execution

## Step 1: Compile

```bash
javac FileName.java
```

Example:

```bash
javac LeftRecursion.java
```

---

## Step 2: Run

```bash
java FileName
```

Example:

```bash
java LeftRecursion
```

---

# Program-wise Execution

---

# 1. Left Recursion Removal

## Compile

```bash
javac LeftRecursion.java
```

## Run

```bash
java LeftRecursion
```

## Sample Input

```text
3
E->E+T|E-T|T
T->T*F|F
F->(E)|id
```

---

# 2. FIRST and FOLLOW

## Compile

```bash
javac FirstFollow.java
```

## Run

```bash
java FirstFollow
```

## Sample Input

```text
3
E->TR
R->+TR
T->i|a
```

---

# 3. LL(1) Parser

## Compile

```bash
javac LL1Parser.java
```

## Run

```bash
java LL1Parser
```

## Sample Input

```text
i+i+i
```

---

# 4. LR(1) Parser

## Compile

```bash
javac LRParser.java
```

## Run

```bash
java LRParser
```

## Sample Input

```text
cdd
```

---

# 5. Intermediate Code Generation

## Features

- Infix to Postfix
- Infix to Prefix
- Quadruples
- Triples

## Compile

```bash
javac IntermediateCode.java
```

## Run

```bash
java IntermediateCode
```

## Sample Input

```text
a+b*c
```

---

# 6. Assembler

## Compile

```bash
javac Assembler.java
```

## Run

```bash
java Assembler
```

## Sample Input

```text
4
COPY START 1000
FIRST LDA ALPHA
ALPHA RESW 1
- END FIRST
```

---

# 7. Macro Processor

## Compile

```bash
javac MacroProcessor.java
```

## Run

```bash
java MacroProcessor
```

## Sample Input

```text
6
MACRO
INCR &ARG
LDA &ARG
ADD =1
STA &ARG
MEND
```

---

# 8. Loader / Linker

## Compile

```bash
javac LoaderLinker.java
```

## Run

```bash
java LoaderLinker
```

## Sample Input

```text
8
PG1 START 0000
EXTDEF A,B
EXTREF C,D
ADD ABC
A SUB PQR
ADD ABC1
B MUL ABC
END
```

---

# 9. Lexical Analyzer using Java

## Compile

```bash
javac LexicalAnalyzer.java
```

## Run

```bash
java LexicalAnalyzer
```

## Sample Input

```text
int a = 10
```

---

# 10. Lexical Analyzer using Lex Tool

## Requirements

- WinFlexBison (Windows)
- GCC / MinGW

---

# Install WinFlexBison

Download:

https://github.com/lexxmark/winflexbison

Add folder containing:

```text
win_flex.exe
win_bison.exe
```

to PATH.

---

# Commands to Run Lex Program

## Generate C File

```bash
win_flex lexer.l
```

This creates:

```text
lex.yy.c
```

---

## Compile

```bash
gcc lex.yy.c -o lexer.exe
```

If required:

```bash
gcc lex.yy.c -o lexer.exe -lfl
```

---

## Run

```bash
lexer.exe
```

---

# GitHub Commands

## Initialize Repository

```bash
git init
```

## Add Files

```bash
git add .
```

## Commit

```bash
git commit -m "Added SPCC lab programs"
```

## Add Remote Repository

```bash
git remote add origin <repository-url>
```

## Push to GitHub

```bash
git push -u origin main
```

---

# Important Notes

- Most programs are simplified for SPCC lab ESE.
- Programs are grammar-specific where required.
- Logic is kept beginner-friendly and easy to understand.
- The