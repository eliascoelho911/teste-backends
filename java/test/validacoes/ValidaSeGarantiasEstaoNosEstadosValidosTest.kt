package test.validacoes

import dados.Garantia
import dados.Proposta
import org.junit.Assert.*
import org.junit.Test
import validacoes.ValidaSeGarantiasEstaoNosEstadosValidos

class ValidaSeGarantiasEstaoNosEstadosValidosTest {
  private val validador = ValidaSeGarantiasEstaoNosEstadosValidos()

  @Test
  fun `deve passar se todas as garantias estiverem nos estados permitidos`() {
    val proposta = Proposta().apply {
      adicionaGarantia(Garantia(estado = "SP"))
    }

    assertEquals(true, validador.validar(proposta))
  }

  @Test
  fun `nao deve passar se alguma das garantias estiver em um estados nao permitido`() {
    val proposta = Proposta().apply {
      adicionaGarantia(Garantia(estado = "PR"))
      adicionaGarantia(Garantia(estado = "SP"))
    }

    assertEquals(false, validador.validar(proposta))
  }
}
