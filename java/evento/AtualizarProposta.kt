package evento

import Propostas
import dados.Proposta
import evento.dto.PropostaEventoDto

class AtualizarProposta(eventoAtualizarProposta: List<String>, propostas: Propostas) :
  Evento(eventoAtualizarProposta, propostas) {
  override fun executa(): Proposta {
    validar()
    propostas.busca(dto.propostaId).let { proposta ->
      proposta.atualiza(dto)
      propostas.atualiza(proposta)
      return proposta
    }
  }

  override fun ehValido(): Boolean =
    tipo == "proposal" && acao == "updated"

  override val dto: PropostaEventoDto
    get() = PropostaEventoDto.criar(eventoValores)
}
