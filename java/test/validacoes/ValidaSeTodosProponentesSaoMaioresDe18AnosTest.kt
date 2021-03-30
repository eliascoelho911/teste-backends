package test.validacoes

import dados.Proponente
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSeTodosProponentesSaoMaioresDe18Anos

class ValidaSeTodosProponentesSaoMaioresDe18AnosTest {
  private val validador = ValidaSeTodosProponentesSaoMaioresDe18Anos()

  @Test
  fun `deve passar quando todos os proponentes sao maiores de 18 anos`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(idade = 20), true)
      adicionaProponente(Proponente(idade = 23), false)
    }

    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando algum dos proponentes for menor de 18 anos`() {
    val proposta = Proposta().apply {
      adicionaProponente(Proponente(idade = 17), true)
      adicionaProponente(Proponente(idade = 23), false)
    }

    assertEquals(false, validador.validar(proposta))
  }
}
