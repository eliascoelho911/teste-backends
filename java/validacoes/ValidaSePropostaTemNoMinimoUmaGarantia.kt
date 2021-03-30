package validacoes

import dados.Proposta

class ValidaSePropostaTemNoMinimoUmaGarantia : Validacao {
//  Dever haver no mínimo 1 garantia de imóvel por proposta
  override fun validar(proposta: Proposta): Boolean =
    proposta.quantidadeGarantias() > 0
}
