package org.jilen.literal
import scala.util.matching.Regex

trait Literal[T] {
   def unapply(literal: String): Option[T]
}

class RegexLiteral[T](val regex: Regex, val convert: String => T) extends Literal[T] {
   def unapply(literal: String) = {
      literal match {
         case regex(value, _*) => Some(convert(value))
         case _ => None
      }
   }
}

object StringLiteral extends RegexLiteral[String]("""\"(.*)\"""".r, _.toString)

object IntLiteral extends RegexLiteral[Int]("""([\+\-]?[0-9]*)""".r, _.toInt)

object LongLiteral extends RegexLiteral[Long]("""([\+\-]?[0-9]*)L""".r, _.toLong)

object CharLiteral extends RegexLiteral[Char]("""\'(\w)\' """.r, _(0))

object BooleanLiteral extends RegexLiteral[Boolean]("""((true)|(false))""".r, _.toBoolean) 