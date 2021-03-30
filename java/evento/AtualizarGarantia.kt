package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.GarantiaEventoDto

class AtualizarGarantia(eventoAtualizarGarantia: List<String>, propostas: Propostas) :
  Evento(eventoAtualizarGarantia, propostas) {
  override fun executa(): Proposta {
    validar()
    propostas.busca(dto.propostaId).let { proposta ->
      proposta.atualizaGarantia(dto)
      return proposta
    }
  }

  override fun ehValido(): Boolean =
    tipo == "warranty" && acao == "updated"

  override val dto: GarantiaEventoDto
    get() = GarantiaEventoDto.criar(eventoValores)

}
