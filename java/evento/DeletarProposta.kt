package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.PropostaEventoDto

class DeletarProposta(eventoDeletarProposta: List<String>, propostas: Propostas) : Evento(eventoDeletarProposta, propostas) {
  override fun executa(): Proposta? {
    validar()
    propostas.deleta(dto.propostaId)
    return null
  }

  override fun ehValido(): Boolean =
    tipo == "proposal" && acao == "removed"

  override val dto: PropostaEventoDto
    get() = PropostaEventoDto.criar(eventoValores)
}
