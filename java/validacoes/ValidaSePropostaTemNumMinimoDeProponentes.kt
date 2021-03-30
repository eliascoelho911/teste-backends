package validacoes

import dados.Proposta

class ValidaSePropostaTemNumMinimoDeProponentes : Validacao {
  //  Deve haver no mínimo 2 proponentes por proposta
  override fun validar(proposta: Proposta): Boolean {
    val quantidadeProponentes = proposta.quantidadeProponentes()
    return quantidadeProponentes >= 2
  }
}
