package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import java.lang.IllegalArgumentException

abstract class Evento(val eventoValores: List<String>, val propostas: Propostas) {
  abstract fun executa() : Proposta?
  abstract fun ehValido(): Boolean
  abstract val dto: EventoDto
  fun validar() {
    if (!ehValido())
      throw IllegalArgumentException("Esse não é um evento válido")
  }
  val tipo: String get() = eventoValores[1]
  val acao: String get() = eventoValores[2]
}
