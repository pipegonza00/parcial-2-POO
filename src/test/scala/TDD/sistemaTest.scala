import org.scalatest.FunSuite
import sistema._
import salon._
import reserva._

class sistemasTest extends FunSuite
{

    test("se agrega un salon al la lista de salones")
    {
        var s : sistema = new sistema
        s.añadirSalon()
        assert(s._salones.length > 0)

    }

    test("se hace una reserva de tipo clase")
    {
        var s : sistema = new sistema
        s.añadirSalon()
        for(i <- s._salones)
        {
            s.hacerReserva(i.id, 1, 7, 9)
            //s.consultarSalon(i.id)
        }

        assert(s._clases.length > 0)
    }
    
    test("se prende el aire de un salon")
    {
        var s : sistema = new sistema
        s.añadirSalon()
        for(i <- s._salones)
        {
            s.hacerReserva(i.id, 1, 20, 21)
            s.comprobarHora()
            assert(i.estadoLuz)
        }
        
    }

    test("se paga la luz de un salon")
    {
        var s : sistema = new sistema
        s.añadirSalon()
        for(i <- s._salones)
        {
            s.hacerReserva(i.id, 0, 0, 19)
            println(i.estadoLuz)
            i._estadoLuz = true
            println(i.estadoLuz)
            s.comprobarHora()
            println(i.estadoLuz)
            assert(i.estadoLuz)
        }

    }

}