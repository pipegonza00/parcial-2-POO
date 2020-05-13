package sistema 

import salon._
import reserva._
import java.util.Calendar

class sistema
{
    /*atributos*/
    var _reservas : List[reserva] = List() //reserva tipo = 0
    var _salones : List[salon] = List()
    var _clases : List[reserva] = List() //reserva tipo = 1
    var _administradores : List[String] = List("pipegonza")
    var _prenderLuz : Int = 55
    var _prenderAire : Int = 50
    var _apagarLuz : Int = 10
    var _apagarAire : Int = 5

    /*metodos*/
    def cambioParametros(pl : Int, pa : Int, al : Int, aa : Int) : Unit = 
    {
        _prenderLuz = pl
        _prenderAire = pa
        _apagarLuz = al
        _apagarAire = aa
    }

    def comprobarHora() : Unit =
    {
        val now = Calendar.getInstance()
        val hora = now.get(Calendar.HOUR_OF_DAY)
        val minuto = now.get(Calendar.MINUTE)

        

        for(i <- this._reservas)
        {
            if(i.horaInicio == hora + 1 )
            {
                if(minuto == this._prenderLuz)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && !(j.estadoLuz))
                        {
                            j.cambiarLuz()
                        }
                    }
                }

                if(minuto == this._prenderAire)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && j.temperatura > 23 && !(j.estadoAire))
                        {

                            j.cambiarAire()
                            j.temperatura = 23

                        }
                    }
                }

                if(minuto == 45)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && !(j.cerradura))
                        {
                            j.cambiarCerradura()
                        }
                    }
                }
            }

            if(i.horaInicio == hora){

                for(j <- _salones)
                {
                    if(i.salonId == j.id && !(j.enUso))
                    {
                        j.cambiarEstadoDeUso()
                    }
                }
            }

            if(i.horaFin == hora)
            { 
                
                for(j <- _salones)
                {
                    if(i.salonId == j.id && j.enUso)
                    {
                        j.cambiarEstadoDeUso()
                    }
                }

                if(minuto == this._apagarAire)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && j.temperatura > 23 && j.estadoAire)
                        {

                            j.cambiarAire()
                            j.temperatura = 30

                        }
                    }
                }

                if(minuto == this._apagarLuz)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && j.estadoLuz)
                        {
                            j.cambiarLuz()
                        }
                    }
                }

            }
        }

        for(i <- this._clases)
        {
            if(i.horaInicio == hora + 1 )
            {
                if(minuto == this._prenderLuz)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && !(j.estadoLuz))
                        {
                            j.cambiarLuz()
                        }
                    }
                }

                if(minuto == this._prenderAire)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && j.temperatura > 23 && !(j.estadoAire))
                        {

                            j.cambiarAire()
                            j.temperatura = 23

                        }
                    }
                }

                if(minuto == 45)
                {
                    for(j <- _salones)
                    {
                        if(i.salonId == j.id && !(j.cerradura))
                        {
                            j.cambiarCerradura()
                        }
                    }
                }
            }

            if(i.horaInicio == hora){

                for(j <- _salones)
                {
                    if(i.salonId == j.id && !(j.enUso))
                    {
                        j.cambiarEstadoDeUso()
                    }
                }
            }

            if(i.horaFin == hora)
            {
                for(j <- _salones)
                {
                    if(i.salonId == j.id && j.enUso && j.cerradura)
                    {
                        j.cambiarEstadoDeUso()
                                               
                        if(minuto == this._apagarAire && j.estadoAire)
                        {
                            j.cambiarAire()
                        }

                        if(minuto == this._apagarLuz && j.estadoLuz)
                        {
                            j.cambiarLuz()
                        }
                    }
                }               
            }
        }
    }

    def existeSalon(salonId : String) : Boolean =
    {

        for(i <- _salones)
        {
            if(i.id == salonId)
            {
                return true
            }

        }

        return false

    }

    def añadirSalon() : String = 
    {
        var s : salon = new salon
        _salones = s::_salones

        return s.id

    }

    def hacerReserva(salonId : String, tipo : Int, hi : Int, hf : Int) : String = 
    {

        if(existeSalon(salonId))
        {
            var r = new reserva(salonId, tipo, hi, hf)
            if(tipo == 1)
            {
                _clases = r::_clases     
            }
            else
            {
                _reservas = r::_reservas
            }
            for(i <- _salones)
            {
                if(i.id == salonId)
                {
                    i._res = r::i._res
                }
            }

            return r.reservaId
            
        }
        else
        {
            return "el salon no existe"
        }

    }

    def consultarSalon(salonId : String) : Unit =
    {
        
        if(existeSalon(salonId))
        {
            for(i <- _salones)
            {
                if(i.id == salonId)
                {
                    i.imprimirSalon()
                }

            }
        }
        else
        {
            println("el salon no existe")
        }
        

    }


}