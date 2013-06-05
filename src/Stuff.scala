object Stuff {

  def charProduct(s: String) : Long = {
    // s.foldLeft(1L)((a, b) => a*b)
    if (s.isEmpty) 1 else s.head * charProduct(s.tail)
  }

  def signum (x: Int) = {if (x < 0) -1 else if (x > 0) 1 else 0}

  def countdown (n: Int) {for (i <- (0 to n).reverse) println(i)}
}
