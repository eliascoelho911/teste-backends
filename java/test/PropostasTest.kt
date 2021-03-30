package test

import Propostas
import dados.Proposta
import org.junit.Assert.assertEquals
import org.junit.Test

class PropostasTest {
  private val proposta = Proposta(id = "22")
  private val propostas = Propostas()

  @Test
  fun `deve adicionar uma proposta`() {
    propostas.adiciona(proposta)
    assertEquals(1, propostas.quantidadePropostas())
    assertEquals(proposta, propostas.todasPropostas[0])
  }

  @Test
  fun `deve buscar uma proposta quando ela existe`() {
    propostas.adiciona(proposta)
    assertEquals(proposta, propostas.busca(proposta.id))
  }

  @Test(expected = IllegalArgumentException::class)
  fun `deve jogar exception quando buscar uma proposta que nao existe`() {
    propostas.busca(proposta.id)
  }

  @Test
  fun `deve deletar uma proposta`() {
    propostas.adiciona(proposta)
    propostas.deleta(proposta.id)
    assertEquals(0, propostas.quantidadePropostas())
  }

  @Test
  fun `deve atualizar uma proposta`() {
    propostas.adiciona(proposta)
    proposta.valorEmprestimo = "200".toBigDecimal()
    propostas.atualiza(proposta)
    assertEquals(proposta, propostas.busca(proposta.id))
  }
}
