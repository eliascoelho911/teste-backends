package test.evento

import Propostas
import dados.Garantia
import dados.Proposta
import evento.DeletarGarantia
import org.junit.Assert.assertEquals
import org.junit.Test

class DeletarGarantiaTest {
  private val eventoDeletarGarantiaValido =
    "af745f6d-d5c0-41e9-b04f-ee524befa425,warranty,removed,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,31c1dd83-8fb7-44ff-8cb7-947e604f6293"
      .split(",")
  val propostas = Propostas()
  private val deletadorDeGarantia = DeletarGarantia(eventoDeletarGarantiaValido, propostas)

  @Test
  fun `deve deletar uma garantia se o evento for valido`() {
    val proposta = Proposta(id = "80921e5f-4307-4623-9ddb-5bf826a31dd7")
    proposta.adicionaGarantia(
      Garantia(
        propostaId = "80921e5f-4307-4623-9ddb-5bf826a31dd7",
        id = "31c1dd83-8fb7-44ff-8cb7-947e604f6293"
      )
    )
    propostas.adiciona(proposta)
    assertEquals(1, proposta.quantidadeGarantias())
    deletadorDeGarantia.executa()
    assertEquals(0, proposta.quantidadeGarantias())
  }
}
