object MyLoop {
  def main(args: Array[String]): Unit = {
    val l = List.tabulate(5)(n => Some(n))
    println(l)
  }

}
