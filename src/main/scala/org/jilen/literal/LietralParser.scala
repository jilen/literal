package org.jilen.literal

/**
 * parse a string literal to expected type of value
 */
trait LiteralParser {
  def parse[T](literal: String): T
}

object RegexLiteralParser extends LiteralParser {

  def parse[T](literal: String): T = {
    val parsedValue = literal match {

      case StringLiteral(value) => value
      case CharLiteral(value) => value
      case IntLiteral(value) => value
      case LongLiteral(value) => value
      case BooleanLiteral(value) => value
      case NullLiteral(value) => value
      //treat literal as string if no match found
      case str: String => str
    }
    parsedValue.asInstanceOf[T]

  }
}