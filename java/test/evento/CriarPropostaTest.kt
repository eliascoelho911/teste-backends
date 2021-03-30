package test.evento

import Propostas
import dados.Proposta
import evento.CriarProposta
import org.junit.Assert.assertEquals
import org.junit.Test

class CriarPropostaTest {
  private val eventoCriarPropostaValido =
    "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,created,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,1141424.0,240"
      .split(",")
  val propostas = Propostas()
  private val criadorDeProposta = CriarProposta(eventoCriarPropostaValido, propostas)

  @Test
  fun `deve criar uma proposta se o evento for valido`() {
    assertEquals(0, propostas.quantidadePropostas())
    criadorDeProposta.executa()
    val propostaEsperada = Proposta("80921e5f-4307-4623-9ddb-5bf826a31dd7", "1141424.0".toBigDecimal(), 240)
    assertEquals(propostaEsperada, propostas.busca(propostaEsperada.id))
  }
}
