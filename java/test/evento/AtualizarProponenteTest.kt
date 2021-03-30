package test.evento

import Propostas
import dados.Proponente
import dados.Proposta
import evento.AtualizarProponente
import org.junit.Assert.assertEquals
import org.junit.Test

class AtualizarProponenteTest {
  private val eventoAtualizarProponentePrincipalValido =
    "20cee034-cae4-40f3-b313-8913fc075ebb,proponent,updated,2019-11-11T14:28:01Z,52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,ba343064-6f41-419d-a455-8cbdcbc807b1,Rory Wuckert,55,365997.74,true"
      .split(",")
  val propostas = Propostas()
  private val atualizadorDeProponente = AtualizarProponente(eventoAtualizarProponentePrincipalValido, propostas)

  @Test
  fun `deve atualizar um proponente se o evento for valido`() {
    val proposta = Proposta(id = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6")
    proposta.adicionaProponente(
      Proponente(
        propostaId = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6",
        id = "ba343064-6f41-419d-a455-8cbdcbc807b1"
      ), true
    )
    propostas.adiciona(proposta)
    atualizadorDeProponente.executa()
    val proponenteEsperado = Proponente(
      "ba343064-6f41-419d-a455-8cbdcbc807b1",
      "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6",
      "Rory Wuckert",
      55,
      "365997.74".toBigDecimal()
    )
    assertEquals(proponenteEsperado, proposta.buscaProponente(proponenteEsperado.id))
  }
}
