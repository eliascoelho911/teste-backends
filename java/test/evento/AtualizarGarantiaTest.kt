package test.evento

import Propostas
import dados.Garantia
import dados.Proposta
import evento.AtualizarGarantia
import org.junit.Assert.assertEquals
import org.junit.Test

class AtualizarGarantiaTest {
  private val eventoAtualizarGarantiaValido =
    "af745f6d-d5c0-41e9-b04f-ee524befa425,warranty,updated,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,31c1dd83-8fb7-44ff-8cb7-947e604f6293,3245356.0,DF"
      .split(",")
  val propostas = Propostas()
  private val atualizadorDeGarantia = AtualizarGarantia(eventoAtualizarGarantiaValido, propostas)

  @Test
  fun `deve atualizar uma garantia se o evento for valido`() {
    val proposta = Proposta(id = "80921e5f-4307-4623-9ddb-5bf826a31dd7")
    proposta.adicionaGarantia(
      Garantia(
        propostaId = "80921e5f-4307-4623-9ddb-5bf826a31dd7",
        id = "31c1dd83-8fb7-44ff-8cb7-947e604f6293"
      )
    )
    propostas.adiciona(proposta)
    atualizadorDeGarantia.executa()
    val garantiaEsperada = Garantia(
      "80921e5f-4307-4623-9ddb-5bf826a31dd7",
      "31c1dd83-8fb7-44ff-8cb7-947e604f6293",
      "3245356.0".toBigDecimal(),
      "DF"
    )
    assertEquals(garantiaEsperada, proposta.buscaGarantia(garantiaEsperada.id))
  }
}
