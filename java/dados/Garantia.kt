package dados

import evento.dto.GarantiaEventoDto
import java.math.BigDecimal

data class Garantia(
  var propostaId: String = "",
  var id: String = "",
  var valor: BigDecimal = BigDecimal.ZERO,
  var estado: String = ""
) {
  fun atualiza(garantiaEventoDto: GarantiaEventoDto): Garantia {
    propostaId = garantiaEventoDto.propostaId
    id = garantiaEventoDto.garantiaId
    valor = garantiaEventoDto.valor ?: BigDecimal.ZERO
    estado = garantiaEventoDto.estado ?: ""
    return this
  }
  companion object {
    fun criar(eventoCriarGarantia: GarantiaEventoDto) : Garantia {
      return Garantia().atualiza(eventoCriarGarantia)
    }
  }
}
