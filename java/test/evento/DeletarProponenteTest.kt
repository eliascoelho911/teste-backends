package test.evento

import Propostas
import dados.Proponente
import dados.Proposta
import evento.AtualizarProponente
import evento.DeletarProponente
import org.junit.Assert.assertEquals
import org.junit.Test

class DeletarProponenteTest {
  private val eventoDeletarProponentePrincipalValido =
    "20cee034-cae4-40f3-b313-8913fc075ebb,proponent,removed,2019-11-11T14:28:01Z,52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,ba343064-6f41-419d-a455-8cbdcbc807b1,Rory Wuckert,55,365997.74,true"
      .split(",")
  val propostas = Propostas()
  private val deletadorDeProponente = DeletarProponente(eventoDeletarProponentePrincipalValido, propostas)

  @Test
  fun `deve deletar um proponente se o evento for valido`() {
    val proposta = Proposta(id = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6")
    proposta.adicionaProponente(
      Proponente(
        propostaId = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6",
        id = "ba343064-6f41-419d-a455-8cbdcbc807b1"
      ), true
    )
    propostas.adiciona(proposta)
    assertEquals(1, proposta.quantidadeProponentes())
    deletadorDeProponente.executa()
    assertEquals(0, proposta.quantidadeProponentes())
  }
}
