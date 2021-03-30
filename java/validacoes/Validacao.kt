package validacoes

import dados.Proposta

interface Validacao {
  fun validar(proposta: Proposta): Boolean
}
