package evento

import Propostas
import dados.Proposta
import evento.dto.EventoDto
import evento.dto.PropostaEventoDto

class CriarProposta(eventoCriarProposta: List<String>, propostas: Propostas) : Evento(eventoCriarProposta, propostas) {
  override fun executa(): Proposta {
    validar()
    val proposta = Proposta.criar(dto)
    propostas.adiciona(proposta)
    return proposta
  }

  override fun ehValido(): Boolean =
    tipo == "proposal" && acao == "created"

  override val dto: PropostaEventoDto
    get() = PropostaEventoDto.criar(eventoValores)
}
