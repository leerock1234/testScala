object MyMatch {
  abstract class MyAbstract
  case class MyFirst() extends MyAbstract
  case class MySecond() extends MyAbstract
  case class MyThird() extends MyAbstract

  def main(args: Array[String]): Unit = {
    val x: MyAbstract = MyThird()

    val y = x match {
      case m: MyFirst => 1
      case _ => 3
    }
    println(y)

    val a:() => Option[Int] = () => Some(4)
    val b:Option[Int] = a.apply() match {
      case p @ Some(_) => p
      case None => None
    }
    println(b)
  }

}
