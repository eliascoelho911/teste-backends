package test.evento

import Propostas
import dados.Proposta
import evento.AtualizarProposta
import org.junit.Assert.assertEquals
import org.junit.Test

class AtualizarPropostaTest {
  private val eventoAtualizarPropostaValido =
    "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,updated,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7,1141424.0,240"
      .split(",")
  val propostas = Propostas()
  private val atualizadorDeProposta = AtualizarProposta(eventoAtualizarPropostaValido, propostas)

  @Test
  fun `deve atualizar uma proposta se o evento for valido`() {
    assertEquals(0, propostas.quantidadePropostas())
    val proposta = Proposta(id = "80921e5f-4307-4623-9ddb-5bf826a31dd7")
    propostas.adiciona(proposta)
    atualizadorDeProposta.executa()
    val propostaEsperada = Proposta("80921e5f-4307-4623-9ddb-5bf826a31dd7", "1141424.0".toBigDecimal(), 240)
    assertEquals(propostaEsperada, propostas.busca(proposta.id))
  }

}
