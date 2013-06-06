object Stuff {

  def charProduct(s: String) : Long = {
    // s.foldLeft(1L)((a, b) => a*b)
    if (s.isEmpty) 1 else s.head * charProduct(s.tail)
  }

  def signum (x: Int) = {if (x < 0) -1 else if (x > 0) 1 else 0}

  def countdown (n: Int) {for (i <- (0 to n).reverse) println(i)}

  def pow(x: Float, n: Int) : Float = {
    if (n == 0) 1.0f
    else if (n < 0) 1/(pow(x, -n))
    else if (n%2 == 1) x * pow(x, n-1)
    else {val y: Float = pow(x, n / 2); y * y }
  }

  def arrayOf(n: Int) = {
    val r = new util.Random()
    for (i <- 0 until n) yield r.nextInt(n)
  }
}
