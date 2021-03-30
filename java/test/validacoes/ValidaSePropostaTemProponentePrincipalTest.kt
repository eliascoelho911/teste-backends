package test.validacoes

import dados.Proponente
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSePropostaTemProponentePrincipal

class ValidaSePropostaTemProponentePrincipalTest {
  private val validador = ValidaSePropostaTemProponentePrincipal()

  @Test
  fun `deve passar quando tem proponente principal`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(), true)
      adicionaProponente(Proponente(), false)
    }
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando nao tem proponente principal`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(), false)
      adicionaProponente(Proponente(), false)
    }
    assertEquals(false, validador.validar(proposta))
  }
}
