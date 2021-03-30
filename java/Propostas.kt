import dados.Proposta
import validacoes.*

private val VALIDACOES = listOf(
  ValidaSeARendaDoProponentePrincipalEhValida(),
  ValidaSeGarantiasEstaoNosEstadosValidos(),
  ValidaSePropostaTemNoMinimoUmaGarantia(),
  ValidaSePropostaTemNumMinimoDeProponentes(),
  ValidaSePropostaTemProponentePrincipal(),
  ValidaSeSomaValorDasGarantiasEhEquivalenteAoValorEmprestimo(),
  ValidaSeTempoDePgtoDoEmprestimoEhValido(),
  ValidaSeTodosProponentesSaoMaioresDe18Anos(),
  ValidaSeValorEmprestimoEhValido(),
)

class Propostas {
  private val todasPropostasMutavel: MutableList<Proposta> = mutableListOf()
  val todasPropostas: List<Proposta>
    get() = todasPropostasMutavel

  fun adiciona(proposta: Proposta) {
    todasPropostasMutavel.add(proposta)
  }

  fun busca(idProposta: String): Proposta =
    todasPropostas.firstOrNull { it.id == idProposta }
      ?: throw IllegalArgumentException("Essa proposta ainda não foi criada")

  fun atualiza(proposta: Proposta) {
    deleta(proposta.id)
    todasPropostasMutavel.add(proposta)
  }

  fun deleta(propostaId: String) {
    todasPropostasMutavel.removeIf { it.id == propostaId }
  }

  fun quantidadePropostas(): Int =
    todasPropostas.size

  fun propostasValidas(): List<Proposta> = todasPropostas.filter { proposta ->
    !VALIDACOES.map { validacao -> validacao.validar(proposta) }.contains(false)
  }
}
