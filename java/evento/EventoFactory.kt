package evento

import Propostas

class EventoFactory(eventoValores: List<String>, propostas: Propostas) {
  private val eventos = listOf(
    CriarProposta(eventoValores, propostas),
    AtualizarProposta(eventoValores, propostas),
    DeletarProposta(eventoValores, propostas),
    CriarGarantia(eventoValores, propostas),
    AtualizarGarantia(eventoValores, propostas),
    DeletarGarantia(eventoValores, propostas),
    CriarProponente(eventoValores, propostas),
    AtualizarProponente(eventoValores, propostas),
    DeletarProponente(eventoValores, propostas)
  )

  fun criar(): Evento {
    eventos.forEach { evento ->
      if (evento.ehValido())
        return evento
    }
    throw IllegalArgumentException("Esse evento ainda não foi mapeado")
  }
}
