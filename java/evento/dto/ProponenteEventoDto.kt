package evento.dto

import java.math.BigDecimal

class ProponenteEventoDto(
  eventoId: String,
  tipo: String,
  acao: String,
  dataString: String,
  propostaId: String,
  val proponenteId: String,
  val nomeProponente: String?,
  val idade: Int?,
  val rendaMensal: BigDecimal?,
  val ehPrincipal: Boolean?
) : EventoDto(eventoId, tipo, acao, dataString, propostaId) {
  companion object {
    fun criar(eventoProponente: List<String>): ProponenteEventoDto {
      val eventoId = eventoProponente[0]
      val tipo = eventoProponente[1]
      val acao = eventoProponente[2]
      val data = eventoProponente[3]
      val propostaId = eventoProponente[4]
      val proponenteId = eventoProponente[5]
      val nomeProponente = eventoProponente.getOrNull(6)
      val idade = eventoProponente.getOrNull(7)?.toInt()
      val salario = eventoProponente.getOrNull(8)?.toBigDecimal()
      val ehPrincipal = eventoProponente.getOrNull(9)?.toBoolean()
      return ProponenteEventoDto(
        eventoId,
        tipo,
        acao,
        data,
        propostaId,
        proponenteId,
        nomeProponente,
        idade,
        salario,
        ehPrincipal
      )
    }
  }
}
