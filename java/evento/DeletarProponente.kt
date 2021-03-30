package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.ProponenteEventoDto

class DeletarProponente(eventoDeletarProponente: List<String>, propostas: Propostas) :
  Evento(eventoDeletarProponente, propostas) {
  override fun executa(): Proposta {
    validar()
    val proposta = propostas.busca(dto.propostaId)
    proposta.run {
      deletaProponente(dto.proponenteId)
      return this
    }
  }

  override fun ehValido(): Boolean =
    tipo == "proponent" && acao == "removed"

  override val dto: ProponenteEventoDto
    get() = ProponenteEventoDto.criar(eventoValores)

}
