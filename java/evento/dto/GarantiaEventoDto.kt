package evento.dto

import java.math.BigDecimal

class GarantiaEventoDto(
  eventoId: String,
  tipo: String,
  acao: String,
  dataString: String,
  propostaId: String,
  val garantiaId: String,
  val valor: BigDecimal?,
  val estado: String?
) : EventoDto(eventoId, tipo, acao, dataString, propostaId) {
  companion object {
    fun criar(eventoProponente: List<String>): GarantiaEventoDto {
      val eventoId = eventoProponente[0]
      val tipo = eventoProponente[1]
      val acao = eventoProponente[2]
      val data = eventoProponente[3]
      val propostaId = eventoProponente[4]
      val garantiaId = eventoProponente[5]
      val valor = eventoProponente.getOrNull(6)?.toBigDecimal()
      val estado = eventoProponente.getOrNull(7)
      return GarantiaEventoDto(eventoId, tipo, acao, data, propostaId, garantiaId, valor, estado)
    }
  }
}
