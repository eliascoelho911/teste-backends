package validacoes

import dados.Proposta

class ValidaSeSomaValorDasGarantiasEhEquivalenteAoValorEmprestimo : Validacao {
  //A soma do valor das garantias deve ser maior ou igual ao dobro do valor do empréstimo
  override fun validar(proposta: Proposta): Boolean =
    proposta.todasGarantias().sumOf { it.valor } >= (proposta.valorEmprestimo.multiply(2.toBigDecimal()))
}
