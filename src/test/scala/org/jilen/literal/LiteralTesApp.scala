package org.jilen.literal

/**
 * Created by IntelliJ IDEA.
 * User: jilen
 * Date: 8/26/11
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */

object LiteralTesApp extends App {
  println("type anything you like")

  while (true) {
    val literal = readLine()
    if (literal == null || literal.trim() == "") {
      sys.exit()
    }
    val value: Any = RegexLiteralParser.parse(literal)
    println("type:%s,value:%s".format(value.asInstanceOf[AnyRef].getClass, value))
  }

}