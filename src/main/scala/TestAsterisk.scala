

object TestAsterisk {
  def main(args: Array[String]): Unit = {
    import scala.collection.Seq
    val b : Seq[Int] = mer(List(1,2,3,4): _*)
//    val s : Seq[Int] =
  }

  def mer(as : Int*) : Seq[Int] = as

}
