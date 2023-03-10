package com.example.netflix

class SP {
    var nombre=""
    var descripcion=""
    var capitulos= mutableListOf<Capitulo>()
    constructor(nombre:String){
        this.nombre=nombre
    }
    class Capitulo{
        var nombre_c=""
        var descripcion=""
        constructor(nombre_c:String,descripcion:String){
            this.nombre_c=nombre_c
            this.descripcion=descripcion
        }
    }
}