package test.evento

import Propostas
import dados.Garantia
import dados.Proposta
import evento.CriarGarantia
import evento.CriarProposta
import org.junit.Assert.assertEquals
import org.junit.Test

class CriarGarantiaTest {
  private val eventoCriarGarantiaValido =
    "af745f6d-d5c0-41e9-b04f-ee524befa425,warranty,added,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,31c1dd83-8fb7-44ff-8cb7-947e604f6293,3245356.0,DF"
      .split(",")
  val propostas = Propostas()
  private val criadorDeGarantia = CriarGarantia(eventoCriarGarantiaValido, propostas)

  @Test
  fun `deve criar uma garantia se o evento for valido`() {
    val proposta = Proposta(id = "80921e5f-4307-4623-9ddb-5bf826a31dd7")
    propostas.adiciona(proposta)
    criadorDeGarantia.executa()
    val garantiaEsperada = Garantia(
      "80921e5f-4307-4623-9ddb-5bf826a31dd7",
      "31c1dd83-8fb7-44ff-8cb7-947e604f6293",
      "3245356.0".toBigDecimal(),
      "DF"
    )
    assertEquals(garantiaEsperada, proposta.buscaGarantia(garantiaEsperada.id))
  }
}
