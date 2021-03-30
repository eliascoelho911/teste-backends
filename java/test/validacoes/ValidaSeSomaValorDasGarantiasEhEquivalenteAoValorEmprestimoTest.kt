package test.validacoes

import dados.Garantia
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSeSomaValorDasGarantiasEhEquivalenteAoValorEmprestimo

class ValidaSeSomaValorDasGarantiasEhEquivalenteAoValorEmprestimoTest {
  private val validador = ValidaSeSomaValorDasGarantiasEhEquivalenteAoValorEmprestimo()

  @Test
  fun `deve passar se a soma do valor das garantias for maior que o dobro do valor do emprestimo`() {
    val proposta = Proposta(valorEmprestimo = 100.toBigDecimal()).apply {
      adicionaGarantia(Garantia(valor = 70.toBigDecimal()))
      adicionaGarantia(Garantia(valor = 140.toBigDecimal()))
    }

    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar se a soma do valor das garantias for menor que o dobro do valor do emprestimo`() {
    val proposta = Proposta(valorEmprestimo = 100.toBigDecimal()).apply {
      adicionaGarantia(Garantia(valor = 70.toBigDecimal()))
      adicionaGarantia(Garantia(valor = 70.toBigDecimal()))
    }

    assertEquals(false, validador.validar(proposta))
  }
}
