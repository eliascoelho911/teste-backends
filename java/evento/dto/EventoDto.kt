package evento.dto

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter.ISO_INSTANT

open class EventoDto(
  val eventoId: String,
  val tipo: String,
  val acao: String,
  dataString: String,
  val propostaId: String,
) {
  val data by lazy {
    val instant = Instant.from(ISO_INSTANT.parse(dataString))
    LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
  }
}
