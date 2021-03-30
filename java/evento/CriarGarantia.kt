package evento

import Propostas
import dados.Garantia
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.GarantiaEventoDto

class CriarGarantia(eventoCriarGarantia: List<String>, propostas: Propostas) : Evento(eventoCriarGarantia, propostas) {
  override fun executa(): Proposta {
    validar()
    val garantia = Garantia.criar(dto)
    propostas.busca(garantia.propostaId).let { proposta ->
      proposta.adicionaGarantia(garantia)
      return proposta
    }
  }

  override fun ehValido(): Boolean =
    tipo == "warranty" && acao == "added"

  override val dto: GarantiaEventoDto
    get() = GarantiaEventoDto.criar(eventoValores)
}
