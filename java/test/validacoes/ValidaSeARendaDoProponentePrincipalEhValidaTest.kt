package test.validacoes

import dados.Proponente
import dados.Proposta
import org.junit.Test
import validacoes.ValidaSeARendaDoProponentePrincipalEhValida
import kotlin.test.assertEquals

class ValidaSeARendaDoProponentePrincipalEhValidaTest {
  private val validador = ValidaSeARendaDoProponentePrincipalEhValida()
  private val proposta = Proposta(valorEmprestimo = 100.toBigDecimal(), parcelasEmMeses = 1)

  @Test
  fun `deve passar se a renda do proponente principal com idade entre 18 e 24 anos for valida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 19, rendaMensal = 400.toBigDecimal()), true)
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar se a renda do proponente principal com idade entre 18 e 24 anos for invalida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 19, rendaMensal = 300.toBigDecimal()), true)
    assertEquals(false, validador.validar(proposta))
  }

  @Test
  fun `deve passar se a renda do proponente principal com idade entre 25 e 50 anos for valida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 26, rendaMensal = 300.toBigDecimal()), true)
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar se a renda do proponente principal com idade entre 25 e 50 anos for invalida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 19, rendaMensal = 200.toBigDecimal()), true)
    assertEquals(false, validador.validar(proposta))
  }

  @Test
  fun `deve passar se a renda do proponente principal com idade maior que 50 anos for valida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 51, rendaMensal = 200.toBigDecimal()), true)
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar se a renda do proponente principal com idade maior que 50 anos for invalida`() {
    proposta.adicionaProponente(Proponente(id = "1", idade = 51, rendaMensal = 100.toBigDecimal()), true)
    assertEquals(false, validador.validar(proposta))
  }

}
