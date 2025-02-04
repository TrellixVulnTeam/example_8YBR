package idv.hsiehpinghan.scalaexample.example

import scala.collection.immutable.List

class Basic {
  def println_0() {
    var l = List(1, 2, 3)
    l.foreach { println }
  }

  def println_1() {
    var l = List(1, 2, 3)
    l.foreach { x => println(x) }
  }

  def println_2() {
    var l = List(1, 2, 3)
    l.foreach { (x: Int) => println(x) }
  }

  def println_3() {
    val int: Int = 3
    val double: Double = 3.3
    val string: String = "string"
    println("int(%d), double(%f), string(%s)".format(int, double, string))
  }

  def println_4() {
    val int: Int = 3
    val double: Double = 3.3
    val string: String = "string"
    println(s"int($int), double($double), string($string)")
  }

  def unit_0(): Unit = {
    println(Unit)
  }

  def unit_1() {
    val result = println("unit_1")
    println(result == ())
  }

  def oneLineExpress_0() {
    val str = "oneLineExpress_0"; println(str)
  }

  def multilinesExpress_0() {
    val v = (3
      + 5)
    println(v)
  }

  def multilinesExpress_1() {
    val v = 3 +
      5
    println(v)
  }

  def unicodeParameterName_0() {
    val \u0041\u0044 = 1
    println(\u0041\u0044)
  }

  def unary_0() {
    // only +, -, !, and ~ allowed
    println((3).unary_-)
  }

  def equals_0() {
    println(1 == 1.0)
  }

  def recursive_0(i: Int) {
    if (i < 0) Unit
    else if (i % 2 == 0) recursive_0(i + 1) // continue
    else if (i >= 10) Unit // break
    else {
      println(i)
      recursive_0(i + 1)
    }
  }

  def variableMask() {
    val v = 1;
    {
      val v = 2
      println(v)
    }
    println(v)
  }

  def variableLengthArgument_0(args: String*) {
    args.foreach { println }
  }

  def bigParanthesesReplaceSmallParantheses_0() {
    println { "big parantheses replace small parantheses" }
  }

  def zip_0() {
    val list = List("a", "b", "c")
    for ((index, value) <- list.indices zip list) {
      println(index, value)
    }
  }

  def unzip_0() {
    val list = List(("c", 2), ("b", 1), ("a", 0))
    println(list.unzip)
  }

  def anyRef_0(null_ : AnyRef) {
    println(null_)
  }

  def nothing_0(): Nothing = {
    throw new RuntimeException("nothing_0")
  }

  def assert_0() {
    assert(1 == 2, "assert_0")
  }

  def isInstanceOfAndAsInstanceOf() {
    val str = "str"
    if (str.isInstanceOf[String]) {
      println(str.asInstanceOf[String])
    }
  }

  def option_0(key: String) {
    val map = Map("some" -> "Some")
    val value = map.get(key)
    val result = value match {
      case Some(s) => s
      case None =>
    }
    println(result)
  }

  def partialFunction_0() {
    val partialFunction: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }
    if (partialFunction.isDefinedAt(Nil)) {
      println(partialFunction(Nil))
    }
    val list = List(1, 2, 3)
    if (partialFunction.isDefinedAt(list)) {
      println(partialFunction(list))
    }
  }

  def partialFunction_1() {
    val tuples = Array((0, ("A", "a")), (1, ("B", "b")), (2, ("C", "c")))
    tuples.map { case (i, (x, y)) => "%d%s%s".format(i, x, y) }.foreach { println }
  }

  def partialFunction_2() {
    val arrays = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
    arrays.map { case Array(x, y, z) => "%d%d%d".format(x, y, z) }.foreach { println }
  }

  def functionVariable_0() {
    var fun = (x: Int) => x + 1
    println(fun(1))
  }

  def placeholder_0() {
    var fun = (_: Int) + (_: Int)
    println(fun(3, 5))
  }

  def foldLeft_0() {
    val list = List("1", "2", "3")
    println(foldLeft_0_0(list))
  }
  def foldLeft_0_0(list: List[String]) = ("A" /: list)(_ + _)

  def foldLeft_1() {
    val list = List("1", "2", "3")
    println(foldLeft_1_0(list))
  }
  def foldLeft_1_0(list: List[String]) = ("A" /: list) { (x, y) => x + "," + y }

  def foldRight_0() {
    val list = List("1", "2", "3")
    println(foldRight_0_0(list))
  }
  def foldRight_0_0(list: List[String]) = (list :\ "Z")(_ + _)

  def classOf(clazz: Class[_]) {
    println(clazz)
  }
}

object Basic_Main {
  def main(args: Array[String]) {
    val b = new Basic
    //    b.println_0()
    //    b.println_1()
    //    b.println_2()
    //    b.println_3()
    b.println_4()
    //    b.unit_0()
    //    b.unit_1()
    //    b.oneLineExpress_0()
    //    b.multilinesExpress_0()
    //    b.multilinesExpress_1()
    //    b.unicodeParameterName_0()
    //    b.unary_0()
    //    b.equals_0()
    //    b.recursive_0(0)
    //    b.variableMask()
    //    b.variableLengthArgument_0("aaa", "bbb", "ccc")
    //    val arr_21 = Array("aaa", "bbb", "ccc")
    //    b.variableLengthArgument_0(arr_21: _*)
    //    b.bigParanthesesReplaceSmallParantheses_0()
    //    b.zip_0()
    //    b.unzip_0()
    //    b.anyRef_0(null)
    //    println(b.nothing_0())
    //    b.assert_0()
    //    b.isInstanceOfAndAsInstanceOf()
    //    b.option_0("some")
    //    b.option_0("none")
    //    b.partialFunction_0()
    //    b.partialFunction_1()
    //    b.partialFunction_2()
    //    b.functionVariable_0()
    //    b.placeholder_0()
    //    b.foldLeft_0()
    //    b.foldLeft_1()
    //    b.foldRight_0()
    //    b.classOf(classOf[Int])
  }
}
