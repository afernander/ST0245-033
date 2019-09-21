#include <iostream>
#include <string>
#include "Pilastr.h"
using namespace std;

NodoPilaStr::NodoPilaStr(string n, NodoPilaStr *sig){
    this->n=n;
    this->sig=sig;
}

void PilaStr::push(NodoPilaStr *nodo){
    nodo->sig = this->cab;
    this->cab = nodo;    
}

NodoPilaStr* PilaStr::pop(){
    NodoPilaStr *item=this->cab;
    if(!item->sig){
        NodoPilaStr *copia=item;
        this->cab=NULL;
        return copia;
    }else{
    while(item->sig->sig){
        item=item->sig;
    }
    NodoPilaStr *copia=item->sig;
    item->sig=NULL;
    return copia;
    }
}

bool PilaStr::esVacia(){
    if(!this->cab){
        return true;
    }
    return false;
}