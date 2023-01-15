object SeqOps {
  def main(args: Array[String]): Unit = {
    val myV = List(Some(1), Some(2), Some(3), Some(4))
    println(sequence(myV))

    val myV2 = List(Some(1), None, Some(3), Some(4))
    println(sequence(myV2))

    val myV3 = List.tabulate(5)(n=>n.toString)
    println(traverse(myV3)(i => Try(i.toInt)))

    val myV4 = List("1","err")
    println(traverse(myV4)(i => Try(i.toInt)))
  }

  def Try[A](i: => A) : Option[A] = {
    try Some(i) catch {case e: Exception => None}
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a.foldRight[Option[List[B]]](Some(Nil:List[B]))((o, acc) => {
      val r = merge(acc, f(o))
      r match {
        case Some(_) => r
        case None => return None
      }
    })
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    traverse(a)(identity)
  }

  def merge[A](acc: Option[List[A]], o: Option[A]): Option[List[A]] = {
    (acc, o) match {
      case (Some(l), Some(a)) => Some(a :: l)
      case (_, None) => None
      case (None, _) => None
    }
  }

}
