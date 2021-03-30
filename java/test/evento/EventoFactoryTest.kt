package test.evento

import Propostas
import evento.*
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class EventoFactoryTest {
  @Test
  fun `deve criar o evento CriarProposta quando for o correto`() {
    val factory = EventoFactory(listOf("", "proposal", "created"), Propostas())
    assertEquals(true, factory.criar() is CriarProposta)
  }

  @Test
  fun `deve criar o evento AtualizarProposta quando for o correto`() {
    val factory = EventoFactory(listOf("", "proposal", "updated"), Propostas())
    assertEquals(true, factory.criar() is AtualizarProposta)
  }

  @Test
  fun `deve criar o evento DeletarProposta quando for o correto`() {
    val factory = EventoFactory(listOf("", "proposal", "removed"), Propostas())
    assertEquals(true, factory.criar() is DeletarProposta)
  }

  @Test
  fun `deve criar o evento CriarGarantia quando for o correto`() {
    val factory = EventoFactory(listOf("", "warranty", "added"), Propostas())
    assertEquals(true, factory.criar() is CriarGarantia)
  }

  @Test
  fun `deve criar o evento AtualizarGarantia quando for o correto`() {
    val factory = EventoFactory(listOf("", "warranty", "updated"), Propostas())
    assertEquals(true, factory.criar() is AtualizarGarantia)
  }

  @Test
  fun `deve criar o evento DeletarGarantia quando for o correto`() {
    val factory = EventoFactory(listOf("", "warranty", "removed"), Propostas())
    assertEquals(true, factory.criar() is DeletarGarantia)
  }

  @Test
  fun `deve criar o evento CriarProponente quando for o correto`() {
    val factory = EventoFactory(listOf("", "proponent", "added"), Propostas())
    assertEquals(true, factory.criar() is CriarProponente)
  }

  @Test
  fun `deve criar o evento AtualizarProponente quando for o correto`() {
    val factory = EventoFactory(listOf("", "proponent", "updated"), Propostas())
    assertEquals(true, factory.criar() is AtualizarProponente)
  }

  @Test
  fun `deve criar o evento DeletarProponente quando for o correto`() {
    val factory = EventoFactory(listOf("", "proponent", "removed"), Propostas())
    assertEquals(true, factory.criar() is DeletarProponente)
  }

  @Test(expected = IllegalArgumentException::class)
  fun `nao deve criar um evento quando nao for valido`() {
    val factory = EventoFactory(listOf("", "x", "x"), Propostas())
    factory.criar()
  }

}
