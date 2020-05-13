package sistema

import java.util.Calendar
import scala.io._

object interfaz extends App
{   
    var activo : Boolean = true
    val now = Calendar.getInstance()
    val horaActual = now.get(Calendar.HOUR_OF_DAY)
    private var sistema : sistema = new sistema
   
   // se tiene que estar entre las 7 y las 19 para ingresar a la interfaz
    
    while(horaActual >= 7 && horaActual <= 19 && activo)
    {
        println("Bienvenido al nuevo edificio inteligente.")
        println("¿Qué desea hacer?")
        println("1 -> hacer una reserva \n 2 -> consultar un salon \n 3 -> logearse como administrador \n 4 -> salir")
        println("Seleccione una opción: ")
        var opcion : Int = StdIn.readInt()

        if(opcion == 1)
        {
            reserva()
        }

        if(opcion == 2)
        {
            salon()
        }
        if(opcion == 3)
        {
            admin()
        }

        if(opcion == 4)
        {
           activo = false
        }

        sistema.comprobarHora()
    }
    

    def reserva() : Unit =
    {
        if(sistema._salones.isEmpty)
        {
            println("no hay salones, espere a que un administrador añada uno.")
        }
        else
        {
            println("Ingrese el id del salon: ")
            var id : String = StdIn.readLine()
            var tipo : Int = 0
            println("Ingrese la hora inicial de su reserva: ")
            var horaI : Int = StdIn.readInt()
            println("Ingrese la hora final de su reserva: ")
            var horaF : Int = StdIn.readInt()

            println(sistema.hacerReserva(id, tipo, horaI, horaF))
        }
        
    }

    def salon() : Unit =
    {
        println("Ingrese la id del salon: ")
        var id : String = StdIn.readLine()

        sistema.consultarSalon(id)
    }

    def admin() : Unit = 
    {

        println("Ingrese su usuario: ")
        var usu : String = StdIn.readLine()

        for(i <- sistema._administradores)
        {
            if(i == usu)
            {
                println("bienvenido " + usu)
                interfazAdmin()
            }
            else
            {
                println("No existe ese usuario, intente de nuevo.")
            }
        }

    }

    def interfazAdmin() : Unit = 
    {
        println("¿Qué desea hacer?")
        println("1 -> añadir un salon \n 2 -> añadir una clase \n 3 -> Cambiar parametros de tiempo")
        println("Seleccione una opción: ")
        var opcion : Int = StdIn.readInt()
        if(opcion == 1)
        {
            cSalon()
        }

        if(opcion == 2)
        {
            clase()
        }

        if(opcion == 3)
        {
            parametros()
        }
    }

    def cSalon() : Unit = 
    {
        println("Salon creado con ID: " + sistema.añadirSalon())
    }

    def clase() : Unit =
    {
        println("Ingrese el id del salon: ")
        var id : String = StdIn.readLine()
        var tipo : Int = 1
        println("Ingrese la hora inicial de su reserva: ")
        var horaI : Int = StdIn.readInt()
        println("Ingrese la hora final de su reserva: ")
        var horaF : Int = StdIn.readInt()

        println(sistema.hacerReserva(id, tipo, horaI, horaF))
    }

    def parametros() : Unit =
    {
        println("Ingrese el minuto para prender la luz de los salones: ")
        var prendLuz : Int = StdIn.readInt()

        println("Ingrese el minuto para prender el aire de los salones: ")
        var prendAire : Int = StdIn.readInt()

        println("Ingrese el minuto para apagar la luz de los salones: ")
        var apagLuz : Int = StdIn.readInt()

        println("Ingrese el minuto para apagar el aire de los salones: ")
        var apagAire : Int = StdIn.readInt()

        sistema.cambioParametros(prendLuz, prendAire, apagLuz, apagAire)
        
    }


}