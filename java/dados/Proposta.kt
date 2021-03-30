package dados

import evento.dto.GarantiaEventoDto
import evento.dto.ProponenteEventoDto
import evento.dto.PropostaEventoDto
import java.math.BigDecimal
import java.math.RoundingMode
import java.math.RoundingMode.HALF_UP

data class Proposta(
  var id: String = "",
  var valorEmprestimo: BigDecimal = BigDecimal.ZERO,
  var parcelasEmMeses: Int = 0,
) {
  private val garantias: MutableList<Garantia> = mutableListOf()
  private val proponentes: MutableList<Proponente> = mutableListOf()
  var proponentePrincipalId: String? = null
    private set
  val valorParcela by lazy {
    valorEmprestimo.divide(parcelasEmMeses.toBigDecimal(), HALF_UP)
  }

  fun atualiza(propostaEventoDto: PropostaEventoDto): Proposta {
    id = propostaEventoDto.propostaId
    valorEmprestimo = propostaEventoDto.valorEmprestimo ?: BigDecimal.ZERO
    parcelasEmMeses = propostaEventoDto.parcelas ?: 0
    return this
  }

  fun adicionaGarantia(garantia: Garantia) {
    garantias.add(garantia)
  }

  fun buscaGarantia(garantiaId: String) =
    garantias.first { it.id == garantiaId }

  fun deletaGarantia(garantiaId: String) {
    garantias.removeIf { it.id == garantiaId }
  }

  fun quantidadeGarantias() = garantias.size

  fun adicionaProponente(proponente: Proponente, ehPrincipal: Boolean): Proponente {
    atualizaProponentePrincipal(proponente, ehPrincipal)
    proponentes.add(proponente)
    return proponente
  }

  fun buscaProponente(proponenteId: String): Proponente =
    proponentes.first { it.id == proponenteId }

  fun deletaProponente(proponenteId: String) {
    proponentes.removeIf { it.id == proponenteId }
    if (proponentePrincipalId == proponenteId)
      proponentePrincipalId = null
  }

  fun atualizaProponente(proponenteEventoDto: ProponenteEventoDto): Proponente {
    val proponente = buscaProponente(proponenteEventoDto.proponenteId)
    proponente.atualiza(proponenteEventoDto)
    atualizaProponentePrincipal(proponente, proponenteEventoDto.ehPrincipal == true)
    return proponente
  }

  private fun atualizaProponentePrincipal(proponente: Proponente, ehPrincipal: Boolean) {
    if (ehPrincipal)
      proponentePrincipalId = proponente.id
  }

  fun atualizaGarantia(garantiaEventoDto: GarantiaEventoDto): Garantia {
    val garantia = buscaGarantia(garantiaEventoDto.garantiaId)
    garantia.atualiza(garantiaEventoDto)
    return garantia
  }

  fun quantidadeProponentes() = proponentes.size

  fun todosProponentes(): List<Proponente> = proponentes

  fun todasGarantias(): List<Garantia> = garantias

  fun buscaProponentePrincipal(): Proponente? =
    proponentes.firstOrNull { it.id == proponentePrincipalId }

  companion object {
    fun criar(propostaEventoDto: PropostaEventoDto): Proposta {
      val proposta = Proposta()
      return proposta.atualiza(propostaEventoDto)
    }
  }
}

