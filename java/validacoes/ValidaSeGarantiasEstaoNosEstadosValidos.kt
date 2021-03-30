package validacoes

import dados.Proposta

class ValidaSeGarantiasEstaoNosEstadosValidos : Validacao {
//  As garantias de imóvel dos estados PR, SC e RS não são aceitas
  private val estadosInvalidos = listOf("PR", "SC", "RS")
  override fun validar(proposta: Proposta): Boolean =
    !proposta.todasGarantias().any { estadosInvalidos.contains(it.estado) }
}
