// g++ -g -o punto2 ejemploPila.cpp pila.o pilaStr.o

#include <iostream>
#include <string>
#include "Pila.h"
#include "pilaStr.h"

#include <sstream>
using namespace std;

//variable gobal
Pila *pila = new Pila();
PilaStr *operadores = new PilaStr();
Pila *operandos = new Pila();
PilaStr *operadoresImp = new PilaStr();
Pila *operandosImp = new Pila();
int resultado=0;

int op1 = 0;
int op2 = 0;

void analizarExpresion(string expresion){
    stringstream expresionRevisada(expresion); 
    string elemento;  
    // tomar cada elemento por separado (tokenrisar)
    while(getline(expresionRevisada, elemento, ' ')) 
    {   
        if (elemento.compare("+")==0){
           //es suma
           cout << "es suma" << endl;   
           operadores->push(new NodoPilaStr(elemento, NULL));  
           operadoresImp->push(new NodoPilaStr(elemento, NULL)); 
           operandos->push(new NodoPila(operandos->pop()->n+operandos->pop()->n,NULL));
        } else {
           if (elemento.compare("-")==0){
             //es suma
             cout << "es resta" << endl;
            operadores->push(new NodoPilaStr(elemento, NULL));  
           operadoresImp->push(new NodoPilaStr(elemento, NULL));  
           op1=operandos->pop()->n;
             op2=operandos->pop()->n;
             resultado=op2-op1;
             operandos->push(new NodoPila(resultado,NULL));
           }  else {
             if (elemento.compare("*")==0){
                //es suma
                cout << "es multiplicacion" << endl;
                operadores->push(new NodoPilaStr(elemento, NULL));  
                operadoresImp->push(new NodoPilaStr(elemento, NULL)); 
                operandos->push(new NodoPila(operandos->pop()->n*operandos->pop()->n,NULL));
             } else {
                 if (elemento.compare("/")==0){
                     //es suma
                    cout << "es division" << endl; 
                    operadores->push(new NodoPilaStr(elemento, NULL));  
                    operadoresImp->push(new NodoPilaStr(elemento, NULL));  
                   op1=operandos->pop()->n;
                op2=operandos->pop()->n;
                resultado=op2/op1;
                operandos->push(new NodoPila(resultado,NULL));
                 } else {
                if (elemento.compare("#")==0){
                    //es suma
                    cout << "cambio de signo" << endl;
                    operadores->push(new NodoPilaStr(elemento, NULL));  
                    operadoresImp->push(new NodoPilaStr(elemento, NULL)); 
                    operandos->push(new NodoPila(operandos->pop()->n*-1,NULL)); 
                }
                 
                 else {
                     cout << "es numero..." << endl;
                     operandos->push(new NodoPila(stoi(elemento), NULL));
                     operandosImp->push(new NodoPila(stoi(elemento), NULL));
                 }    
             }  
           }   
        } 
    }      
  }
}



int main(){
    //Prueba de las funciones de la pila
    pila->push(new NodoPila(3, NULL));
    pila->push(new NodoPila(4, NULL));
    pila->push(new NodoPila(8, NULL));
    //ver Pila
    cout << "[";
    while (!pila->esVacia()){   
        cout << pila->pop()->n << "]->[";
    }
    cout << "NULL]" << endl;

    //================================

    //ejemplo de la expresión
    //ejemplo  "4 5 6 / + = 5" ;
    //ejemplo de parcial "4 6 2 / + = 7"
    //ejemplo de parcial "4 6 2 # + * = 16"
    char temp[200];
     
    cout<<"ingrese la operecion que desee operar"<<endl;
    gets(temp);
    string expresion(temp);
    analizarExpresion(expresion);
    
    cout << "Lista de operandos: [";
    while (!operandosImp->esVacia()){   
        cout << operandosImp->pop()->n << "]->[";
    }
    cout << "NULL]" << endl;
    
    cout << "Lista de operadores: [";
    while (!operadoresImp->esVacia()){   
        cout << operadoresImp->pop()->n << "]->[";
    }
    cout << "NULL]" << endl;

    
    cout <<"El resultado de la operacion es: " +to_string(operandos->pop()->n)<<endl;


   }