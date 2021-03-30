package test.validacoes

import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSeTempoDePgtoDoEmprestimoEhValido

class ValidaSeTempoDePgtoDoEmprestimoEhValidoTest {
  private val validador = ValidaSeTempoDePgtoDoEmprestimoEhValido()

  @Test
  fun `deve passar quando tempo de pgto e maior que 2 anos e menor que 15 anos`() {
    val proposta = Proposta(parcelasEmMeses = 25)
    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar quando tempo de pgto e menor que 2 anos ou maior que 15 anos`() {
    val proposta1 = Proposta(parcelasEmMeses = 12)
    val proposta2 = Proposta(parcelasEmMeses = (12 * 16))
    assertEquals(false, validador.validar(proposta1))
    assertEquals(false, validador.validar(proposta2))
  }
}
