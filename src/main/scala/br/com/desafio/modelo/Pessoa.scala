package br.com.desafio.modelo

import java.text.SimpleDateFormat

/**
  * Classe responsável por representar uma pessoa da planilha informada
  *
  * @param nome
  * @param email
  * @param genero
  * @param dataAniversario
  */
class Pessoa (var nome: String, var email: String, var genero: String, var dataAniversario: String){

  def this(valores: Array[String]) {
    this (valores(0), valores(1), valores(2), valores(3))
  }

  /**
    * Verifica se a data de aniversário é maior do que um determinado mês
    * @param mes
    * @return
    */
  def isDataDeAniversarioMenorQue(mes : Integer) = {
    val formato = new SimpleDateFormat("yyyy-MM-dd")
    val data = formato.parse(this.dataAniversario)

    (data.getMonth) + 1 <= mes
  }

  override def toString: String = {
    "{\"nome\":\"" + nome + "\", \"email\": \"\"" + email + "\", \"genero\":\"\"" + genero + "\", \"dataAniversario\":\"\"" + dataAniversario + "\"}"
  }

}

