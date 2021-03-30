package evento

import Propostas
import dados.Proponente
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.ProponenteEventoDto

class CriarProponente(eventoCriarProponente: List<String>, propostas: Propostas) :
  Evento(eventoCriarProponente, propostas) {
  override fun executa(): Proposta {
    validar()
    propostas.busca(dto.propostaId).let { proposta ->
      val proponente = Proponente.criar(dto)
      proposta.adicionaProponente(proponente, dto.ehPrincipal == true)
      return proposta
    }
  }

  override fun ehValido(): Boolean =
    tipo == "proponent" && acao == "added"

  override val dto: ProponenteEventoDto
    get() = ProponenteEventoDto.criar(eventoValores)

}
