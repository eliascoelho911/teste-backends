package validacoes

import dados.Proposta

class ValidaSeARendaDoProponentePrincipalEhValida : Validacao {
  /*
  A renda do proponente principal deve ser pelo menos:
    4 vezes o valor da parcela do empréstimo, se a idade dele for entre 18 e 24 anos
    3 vezes o valor da parcela do empréstimo, se a idade dele for entre 24 e 50 anos
    2 vezes o valor da parcela do empréstimo, se a idade dele for acima de 50 anos
   */
  override fun validar(proposta: Proposta): Boolean {
    val proponentePrincipal = proposta.buscaProponentePrincipal() ?: return false
    val idade = proponentePrincipal.idade
    val rendaMensal = proponentePrincipal.rendaMensal
    val valorParcela = proposta.valorParcela
    return when {
      idade in 18..24 -> {
        rendaMensal >= valorParcela.multiply(4.toBigDecimal())
      }
      idade in 25..50 -> {
        rendaMensal >= valorParcela.multiply(3.toBigDecimal())
      }
      idade > 50 -> {
        rendaMensal >= valorParcela.multiply(2.toBigDecimal())
      }
      else -> {
        false
      }
    }
  }
}
