package br.com.desafio.escritor

import java.io.PrintWriter
import java.nio.file.{Files, Path, Paths}
import java.util.logging.Logger

import br.com.desafio.modelo.Pessoa

import scala.util.parsing.json.{JSONArray, JSONObject}

/**
  * Classe responsável por encapsular a escrita de um arquivo json
  * @param caminho
  */
class Escritor (val caminho : String){
  val LOG : Logger = Logger.getLogger(getClass.getName)

  def escreverArquivo(pessoas : Array[Pessoa]) = {
     LOG.info("Criando o arquivo: " + caminho)

    Files.write(Paths.get(caminho),new JSONArray(pessoas.toList).toString().getBytes)
  }
}
