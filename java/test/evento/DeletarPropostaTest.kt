package test.evento

import Propostas
import dados.Proposta
import evento.DeletarProposta
import org.junit.Assert.assertEquals
import org.junit.Test

class DeletarPropostaTest {
  private val eventoDeletarPropostaValido =
    "72ff1d14-756a-4549-9185-e60e326baf1b,proposal,removed,2019-11-11T14:28:01Z,80921e5f-4307-4623-9ddb-5bf826a31dd7"
      .split(",")
  val propostas = Propostas()
  private val deletadorDeProposta = DeletarProposta(eventoDeletarPropostaValido, propostas)

  @Test
  fun `deve deletar uma proposta se o evento for valido`() {
    assertEquals(0, propostas.quantidadePropostas())
    propostas.adiciona(Proposta(id = "80921e5f-4307-4623-9ddb-5bf826a31dd7"))
    assertEquals(1, propostas.quantidadePropostas())
    deletadorDeProposta.executa()
    assertEquals(0, propostas.quantidadePropostas())
  }
}
