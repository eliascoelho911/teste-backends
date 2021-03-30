package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.ProponenteEventoDto

class AtualizarProponente(eventoAtualizarProponente: List<String>, propostas: Propostas) :
  Evento(eventoAtualizarProponente, propostas) {
  override fun executa(): Proposta {
    validar()
    propostas.busca(dto.propostaId).let { proposta ->
      proposta.atualizaProponente(dto)
      return proposta
    }
  }

  override fun ehValido(): Boolean =
    tipo == "proponent" && acao == "updated"

  override val dto: ProponenteEventoDto
    get() = ProponenteEventoDto.criar(eventoValores)

}
