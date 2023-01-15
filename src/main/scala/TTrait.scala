trait Tt {
  def print(): Unit
  def mv: Int
}
object TTrait {
  def main(args: Array[String]): Unit = {
    object mt extends Tt {
      def print(): Unit = {
        println(mv)
      }
      def mv:Int = 4
    }
    mt.print()
  }
}
