package reserva
import scala.util.Random

class reserva
{
    var _salonId : String = _
    var _reservaId : String = _
    var _tipo : Int = _
    var _horaInicio : Int = _
    var _horaFin : Int = _

    /*constructor auxiliar*/
    def this(s : String, t : Int, hi : Int, hf : Int) =
    {
        this()
        _salonId = s
        _reservaId = Random.alphanumeric.take(5).mkString("")
        _tipo = t
        _horaInicio = hi
        _horaFin = hf

    }


    /*getters*/
    def salonId = _salonId
    def reservaId = _reservaId
    def tipo = _tipo
    def horaInicio = _horaInicio
    def horaFin = _horaFin

    /*setters*/



}