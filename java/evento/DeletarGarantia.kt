package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.GarantiaEventoDto

class DeletarGarantia(eventoDeletarGarantia: List<String>, propostas: Propostas) :
  Evento(eventoDeletarGarantia, propostas) {
  override fun executa(): Proposta {
    validar()
    val proposta = propostas.busca(dto.propostaId)
    proposta.run {
      deletaGarantia(dto.garantiaId)
      return this
    }
  }

  override fun ehValido(): Boolean =
    tipo == "warranty" && acao == "removed"

  override val dto: GarantiaEventoDto
    get() = GarantiaEventoDto.criar(eventoValores)

}
