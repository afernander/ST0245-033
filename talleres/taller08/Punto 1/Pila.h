// para compilar:
//  g++ -g -c pila.cpp

#pragma once
#include <iostream>
#include <string>

using namespace std;

class NodoPila {
   public:
      NodoPila(int n, NodoPila *sig);
      int n;
      NodoPila *sig;
   private:
     //------
};

class Pila{
   public:
     Pila(){this->cab = NULL;}
     NodoPila *cab;
     
     void push(NodoPila *nodo);
     NodoPila* pop();

     bool esVacia();  //retorna true si esta vacia y false si no
   private:
    //----
};