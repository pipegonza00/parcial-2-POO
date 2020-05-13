package salon 

import reserva._
import scala.util.Random

class salon
{
    var _id : String = this.generarId()
    var _estadoLuz : Boolean = false
    var _estadoAire : Boolean = false
    var _temperatura : Double = 30 
    var _res : List[reserva] = List()
    var _enUso : Boolean = false
    var _cerradura : Boolean = true

    /*getters*/
    def id = _id
    def temperatura = _temperatura
    def enUso = _enUso
    def estadoLuz = _estadoLuz
    def estadoAire = _estadoAire
    def res = _res
    def cerradura = _cerradura

    /*setters*/
    def temperatura_= (temp : Double) = _temperatura = temp
    

    /*metodos*/
    def generarId() : String = 
    {
        var salonId : String = Random.alphanumeric.take(5).mkString("")
        return salonId
    }

    def cambiarLuz()
    {
        if(this.estadoLuz)
        {
            _estadoLuz = false
        }

        else
        {
            _estadoLuz = true
        }
    }

    def cambiarAire()
    {
        if(this.estadoAire)
        {
            _estadoAire = false
        }
        
        else
        {
            _estadoAire = true
        }
    }

    def cambiarEstadoDeUso()
    {
        if(this.enUso)
        {
            _enUso = false
        }
        
        else
        {
            _enUso = true
        }
    }

    def cambiarCerradura()
    {
        if(this.cerradura)
        {
            _cerradura = false
        }
        
        else
        {
            _cerradura = true
        }
    }

    def imprimirSalon() : Unit =
    {
        println("id " + this.id)
        
        if(enUso)
        {
            println("el salon esta en uso")
        }
        else
        {
            println("el salon no esta en uso")
        }

        println("Temperatura actual " + this.temperatura)

        if(this.res.isEmpty)
        {
            println("no hay reservas")
        }
        else
        {
            for(i <- this.res)
            {
                println("reserva: " + i.reservaId)
                println("hora inicial: " + i.horaInicio + "      hora final: " + i.horaFin)
            }
        }

    }

}