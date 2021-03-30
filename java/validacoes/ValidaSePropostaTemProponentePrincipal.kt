package validacoes

import dados.Proposta

class ValidaSePropostaTemProponentePrincipal : Validacao {
  //Deve haver exatamente 1 proponente principal por proposta
  override fun validar(proposta: Proposta): Boolean {
    return proposta.proponentePrincipalId != null
  }
}
