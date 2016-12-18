package idv.hsiehpinghan.scalaexample.example

class FunctionToClassClass() {
  var function: Int => String = null
  
  def method(int: Int) {
    println("FunctionToClassClass method %s".format(function(int)))
  }
}
object FunctionToClassClass {
  implicit def functionToClass_0(function: Int => String) = {
    val clazz = new FunctionToClassClass()
    clazz.function = function
    clazz
  }
  
  implicit def functionToClass_1(function: Int => String) = {
    val clazz = new FunctionToClassClass()
    clazz.function = function
    clazz
  }
}

object ImplicitConversion_Main extends App {
//  import idv.hsiehpinghan.scalaexample.example.FunctionToClassClass.functionToClass_0
//  def functionToClassFunction_0 = (int: Int) => {
//    int.toString()
//  }
//  def functionToClassTest(clazz: FunctionToClassClass) = {
//    clazz.method(3)
//  }
//  functionToClassTest(functionToClassFunction_0)
  
//  import idv.hsiehpinghan.scalaexample.example.FunctionToClassClass.functionToClass_1
//  def functionToClassFunction_1 = (int: Int) => {
//    int.toString()
//  }
//  functionToClassFunction_1.method(3)
}