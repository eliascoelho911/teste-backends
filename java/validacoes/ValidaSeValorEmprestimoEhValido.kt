package validacoes

import dados.Proposta

class ValidaSeValorEmprestimoEhValido : Validacao {
  //O valor do empréstimo deve estar entre R$ 30.000,00 e R$ 3.000.000,00
  override fun validar(proposta: Proposta): Boolean {
    val valorEmprestimo = proposta.valorEmprestimo
    return valorEmprestimo >= "30000".toBigDecimal() &&
      valorEmprestimo <= "3000000".toBigDecimal()
  }
}
