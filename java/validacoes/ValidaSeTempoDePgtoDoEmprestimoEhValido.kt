package validacoes

import dados.Proposta

class ValidaSeTempoDePgtoDoEmprestimoEhValido : Validacao {
  //O empréstimo deve ser pago em no mínimo 2 anos e no máximo 15 anos
  override fun validar(proposta: Proposta): Boolean {
    val parcelasEmMeses = proposta.parcelasEmMeses
    return parcelasEmMeses >= (12 * 2) && parcelasEmMeses <= (12 * 15)
  }
}
