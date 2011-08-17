package org.jilen.literal

trait LiteralParser {
   def parse(literal: String): Any
}

object RegexLiteralParser extends LiteralParser {

   def parse(literal: String): Any = {
      literal match {
         case StringLiteral(value) => value
         case CharLiteral(value) => value
         case IntLiteral(value) => value
         case LongLiteral(value) => value
         case BooleanLiteral(value) => value
      }
   }
}