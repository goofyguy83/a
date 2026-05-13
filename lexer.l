%{
#include<stdio.h>
%}

%%
int|float|if|else|while|switch
    { printf("%s -> Keyword\n", yytext); }

[0-9]+
    { printf("%s -> Number\n", yytext); }

[a-zA-Z][a-zA-Z0-9]*
    { printf("%s -> Identifier\n", yytext); }

[+\-*/=]
    { printf("%s -> Operator\n", yytext); }

. ;

%%

int yywrap()
{
    return 1;
}

int main()
{
    printf("Enter statement:\n");
    yylex();
    return 0;
}