package test.evento

import Propostas
import dados.Proponente
import dados.Proposta
import evento.CriarProponente
import org.junit.Assert.assertEquals
import org.junit.Test

class CriarProponenteTest {
  private val eventoCriarProponentePrincipalValido =
    "20cee034-cae4-40f3-b313-8913fc075ebb,proponent,added,2019-11-11T14:28:01Z,52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,ba343064-6f41-419d-a455-8cbdcbc807b1,Rory Wuckert,55,365997.74,true"
      .split(",")
  private val eventoCriarProponenteSecundarioValido =
    "20cee034-cae4-40f3-b313-8913fc075ebb,proponent,added,2019-11-11T14:28:01Z,52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6,ba343064-6f41-419d-a455-8cbdcbc807b1,Rory Wuckert,55,365997.74,false"
      .split(",")
  val propostas = Propostas()

  @Test
  fun `deve criar um proponente principal se o evento for valido`() {
    val criadorDeProponente = CriarProponente(eventoCriarProponentePrincipalValido, propostas)
    val proposta = Proposta(id = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6")
    propostas.adiciona(proposta)
    criadorDeProponente.executa()
    val proponenteEsperado = Proponente(
      "ba343064-6f41-419d-a455-8cbdcbc807b1",
      "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6",
      "Rory Wuckert",
      55,
      "365997.74".toBigDecimal()
    )
    assertEquals(proponenteEsperado, proposta.buscaProponente(proponenteEsperado.id))
    assertEquals(proponenteEsperado.id, proposta.proponentePrincipalId)
  }

  @Test
  fun `deve criar um proponente secundario se o evento for valido`() {
    val criadorDeProponente = CriarProponente(eventoCriarProponenteSecundarioValido, propostas)
    val proposta = Proposta(id = "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6")
    propostas.adiciona(proposta)
    criadorDeProponente.executa()
    val proponenteEsperado = Proponente(
      "ba343064-6f41-419d-a455-8cbdcbc807b1",
      "52f0b3f2-f838-4ce2-96ee-9876dd2c0cf6",
      "Rory Wuckert",
      55,
      "365997.74".toBigDecimal()
    )
    assertEquals(proponenteEsperado, proposta.buscaProponente(proponenteEsperado.id))
    assertEquals(null, proposta.proponentePrincipalId)
  }
}
