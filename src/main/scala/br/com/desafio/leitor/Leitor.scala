package br.com.desafio.leitor

import java.text.{ParseException, SimpleDateFormat}
import java.util.logging.Logger

import br.com.desafio.modelo.Pessoa

import scala.io.Source

/**
  * Classe responsável por encapsular a leitura do csv recebendo no seu contrutor o caminho do csv
  * @param caminho
  */
class Leitor (caminho : String){
  val LOG : Logger = Logger.getLogger(getClass.getName)

  val QTD_POSICOES_LINHA_COM_DATA = 4
  val POSICAO_DATA = 3
  val PATTERN_DATA = "yyyy-MM-dd"

  /**
    * Função responsável por buscar todas pessoas da listagem que tenham a data de aniversário informada
    * @return
    */
  def getPessoasComDataDeAniversarioInformada() : Iterator[Pessoa] = {
    val src = Source.fromFile(this.caminho)

    LOG.info("Buscando todas as pessoas que tem a data de nascimento cadastrada e válida no arquivo: " + caminho)
    return src.getLines()
            .map(_.split(","))
            .drop(1)
            .filter({_.length == QTD_POSICOES_LINHA_COM_DATA})
            .filter((atributo: Array[String]) =>  isDataValida(atributo(POSICAO_DATA)))
            .map(new Pessoa(_))

  }

  /**
    * Função responsável por verificar se a data informada é válida
    * @param data
    * @return
    */
  def isDataValida(data : String) : Boolean = {
    val formato = new SimpleDateFormat(PATTERN_DATA)
    var dataValida = true

    try {
      formato.parse(data)
    }catch{
      case parse : ParseException => dataValida = false
    }

    dataValida
  }

  /**
    * Função responsável por buscar todas as pessoas com a data de aniversário maior do que um determinado mês
    * @param mes
    * @return
    */
  def getPessoaComDataDeAniversarioMenorQue(mes : Integer) : Array[Pessoa] = {
    LOG.info("Buscando todas as pessoas com o mês da data de nascimento menor do que: " + mes)

    return getPessoasComDataDeAniversarioInformada()
      .filter(_.isDataDeAniversarioMenorQue(mes))
      .toArray
  }
}

