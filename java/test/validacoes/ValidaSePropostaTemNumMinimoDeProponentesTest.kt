package test.validacoes

import dados.Proponente
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSePropostaTemNumMinimoDeProponentes

class ValidaSePropostaTemNumMinimoDeProponentesTest {
  private val validador = ValidaSePropostaTemNumMinimoDeProponentes()

  @Test
  fun `deve passar quando o numero de proponentes e maior que 2`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(), true)
      adicionaProponente(Proponente(), false)
    }
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando o numero de proponentes e menor que 2`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(), false)
    }
    assertEquals(false, validador.validar(proposta))
  }
}
