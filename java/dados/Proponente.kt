package dados

import evento.dto.ProponenteEventoDto
import java.math.BigDecimal

data class Proponente(
  var id: String = "",
  var propostaId: String = "",
  var nome: String = "",
  var idade: Int = 0,
  var rendaMensal: BigDecimal = BigDecimal.ZERO
) {
  fun atualiza(proponenteEventoDto: ProponenteEventoDto): Proponente {
    id = proponenteEventoDto.proponenteId
    propostaId = proponenteEventoDto.propostaId
    nome = proponenteEventoDto.nomeProponente ?: ""
    idade = proponenteEventoDto.idade ?: 0
    rendaMensal = proponenteEventoDto.rendaMensal ?: BigDecimal.ZERO
    return this
  }

  companion object {
    fun criar(eventoCriarProponente: ProponenteEventoDto) : Proponente {
      return Proponente().atualiza(eventoCriarProponente)
    }
  }
}
