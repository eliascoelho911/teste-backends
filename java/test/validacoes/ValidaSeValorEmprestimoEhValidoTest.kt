package test.validacoes

import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSeValorEmprestimoEhValido

class ValidaSeValorEmprestimoEhValidoTest {
  private val validador = ValidaSeValorEmprestimoEhValido()

  @Test
  fun `deve passar quando valor do emprestimo for maior que R$30000 e menor que R$3000000`() {
    val proposta = Proposta(valorEmprestimo = "30000".toBigDecimal())
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando valor do emprestimo for menor que R$30000 ou maior que R$3000000`() {
    val proposta1 = Proposta(valorEmprestimo = "29000".toBigDecimal())
    val proposta2 = Proposta(valorEmprestimo = "3000001".toBigDecimal())
    assertEquals(false, validador.validar(proposta1))
    assertEquals(false, validador.validar(proposta2))
  }
}
