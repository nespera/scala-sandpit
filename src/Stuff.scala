object Stuff {
  def charProduct(s: String) : Long = {
    if (s.isEmpty) {
      0
    } else {
      var product = 1L
      for (c <- s) product = product * c
      product
    }
  }

  def signum (x: Int) = {if (x < 0) -1 else if (x > 0) 1 else 0}

  def countdown (n: Int) {for (i <- (0 to n).reverse) println(i)}
}
