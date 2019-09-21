#include <iostream>
#include <string>
#include "Pila.h"
using namespace std;

NodoPila::NodoPila(int n, NodoPila *sig){
    this->n=n;
    this->sig=sig;
}
void Pila::push(NodoPila *nodo){
    nodo->sig = this->cab;
    this->cab = nodo;
}
NodoPila* Pila::pop(){
    NodoPila *item=this->cab;
    this->cab=this->cab->sig;
    return item;
}
bool Pila::esVacia(){
    if(!this->cab){
        return true;
    }
    return false;
}