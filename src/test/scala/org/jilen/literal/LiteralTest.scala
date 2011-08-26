package org.jilen.literal

import org.junit.Test
import org.junit.Assert._
import org.jilen.literal.RegexLiteralParser._

class LiteralTest {
  @Test
  def testLiteral() {
    val helloWithQuotes = """"hello""""

    assertEquals("hello", parse(helloWithQuotes))
    assertEquals(5, parse[Int]("5"))
    assertEquals(5L, parse("5L"))
    assertEquals(true, parse("true"))
    assertEquals("", parse(""))
    assertEquals('c', parse[Char]("\'c\'"))
    assertEquals(null,parse("null"))

  }
}