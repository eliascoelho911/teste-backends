package test.validacoes

import dados.Garantia
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSePropostaTemNoMinimoUmaGarantia

class ValidaSePropostaTemNoMinimoUmaGarantiaTest {
  private val validador = ValidaSePropostaTemNoMinimoUmaGarantia()

  @Test
  fun `deve passar quando a proposta tem no minimo uma garantia`() {
    val proposta = Proposta().apply {
      adicionaGarantia(Garantia())
    }
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando a proposta nao tem garantia`() {
    val proposta = Proposta()
    assertEquals(false, validador.validar(proposta))
  }
}
