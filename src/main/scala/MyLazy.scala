

object MyLazy {
  def main(args: Array[String]): Unit = {
    println(((1 to 10) filter (_%2==0))(2))
    println((Stream.from(1,1) filter (_%2==0))(2))

  }

}
