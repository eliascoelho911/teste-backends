package evento

import org.junit.Assert.*
import org.junit.Test

class EventosTest {
  private val eventos = Eventos()
  private val eventoCriarProposta = "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,created,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,1141424.0,240"
    .split(",")

  @Test
  fun `deve criar um evento quando for valido`() {
    eventos.criaEvento(eventoCriarProposta)
    assertEquals(1, eventos.todosEventos.size)
  }

  @Test
  fun `deve retornar apenas eventos validos na funcao eventosValidos()`() {
    val evento = eventos.criaEvento(eventoCriarProposta)
    eventos.criaEvento(eventoCriarProposta.toMutableList().apply { set(2, "updated") })
    assertEquals(listOf(evento), eventos.eventosValidos())
  }
}
