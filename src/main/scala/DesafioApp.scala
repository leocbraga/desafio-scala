import java.util.logging.Logger

import br.com.desafio.escritor.Escritor
import br.com.desafio.leitor.Leitor
import br.com.desafio.modelo.Pessoa

import scala.io.Source


/**
  * Desafio APP
  *
  * @param arg[0] nome do arquivo de entrada (CSV)
  * @param arg[1] nome do arquivo de saída (JSON)
  *
  * @author Leonardo Corrêa Braga
  */
object DesafioApp extends App{
  val LOG : Logger = Logger.getLogger(DesafioApp.getClass.getName)

  val leitor = new Leitor(args(0))
  val escritor = new Escritor(args(1))

  LOG.info("Iniciando a filtragem das pessoas com a data de aniversário no primeiro semestre do ano")
  var pessoas : Array[Pessoa] = leitor.getPessoaComDataDeAniversarioMenorQue(6);

  LOG.info("Fim da filtragem")

  LOG.info("Iniciando a escrita do arquivo json contendo as pessoas que nasceram no primeiro semestre")
  escritor.escreverArquivo(pessoas)

}
