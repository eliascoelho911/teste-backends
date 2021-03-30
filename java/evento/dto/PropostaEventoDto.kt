package evento.dto

import java.math.BigDecimal

class PropostaEventoDto(
  eventoId: String,
  tipo: String,
  acao: String,
  dataString: String,
  propostaId: String,
  val valorEmprestimo: BigDecimal?,
  val parcelas: Int?
) : EventoDto(eventoId, tipo, acao, dataString, propostaId) {
  companion object {
    fun criar(eventoProposta: List<String>): PropostaEventoDto {
      val eventoId = eventoProposta[0]
      val tipo = eventoProposta[1]
      val acao = eventoProposta[2]
      val data = eventoProposta[3]
      val propostaId = eventoProposta[4]
      val valorEmprestimo = eventoProposta.getOrNull(5)?.toBigDecimal()
      val parcelas = eventoProposta.getOrNull(6)?.toInt()
      return PropostaEventoDto(eventoId, tipo, acao, data, propostaId, valorEmprestimo, parcelas)
    }
  }
}
