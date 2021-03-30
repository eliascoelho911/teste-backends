package validacoes

import dados.Proposta

class ValidaSeTodosProponentesSaoMaioresDe18Anos : Validacao {
  //Todos os proponentes devem ser maiores de 18 anos
  override fun validar(proposta: Proposta): Boolean {
    return !proposta.todosProponentes().any { it.idade < 18 }
  }
}
