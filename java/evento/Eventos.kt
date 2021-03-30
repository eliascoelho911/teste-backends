package evento

import Propostas

class Eventos {
  private val todosEventosMutavel: MutableList<Evento> = mutableListOf()
  val todosEventos: List<Evento> get() = todosEventosMutavel
  val propostas = Propostas()

  fun criaEvento(eventoValores: List<String>) : Evento {
    EventoFactory(eventoValores, propostas).criar().let { evento ->
      todosEventosMutavel.add(evento)
      return evento
    }
  }

  fun executaTodosOsEventosValidos() {
    eventosValidos().forEach { it.executa() }
  }

  fun eventosValidos(): List<Evento> {
    return todosEventos.distinctBy { it.dto.eventoId }
  }
}
