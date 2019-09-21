#pragma once
#include <iostream>
#include <string>

using namespace std;

class NodoPilaStr {
   public:
      NodoPilaStr(string n, NodoPilaStr *sig);
      string n;
      NodoPilaStr *sig;
   private:
     //------
};

class PilaStr{
   public:
     PilaStr(){this->cab = NULL;}
     NodoPilaStr *cab;

     void push(NodoPilaStr *nodo);
     NodoPilaStr* pop();

     bool esVacia();  //retorna true si esta vacia y false si no
   private:
    //----
};