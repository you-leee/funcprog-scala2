val xs = Stream(1,2,3)

def streamRange(lo: Int, hi: Int): Stream[Int] = {
  if(lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def listRange(lo: Int, hi: Int): List[Int] = {
  if(lo >= hi) Nil
  else lo :: listRange(lo + 1, hi)
}

def expr = {
  val x= {print("x"); 1}
  lazy val y = {print("y"); 2}
  def z = {print("z"); 3}
  z + y + x + z + y + x
}
expr


def isPrime(n: Int): Boolean = {
  !((2 until n) exists (x => n%x == 0))
}
(streamRange(1000, 10000) filter isPrime) apply 1



def from(n: Int): Stream[Int] = n #:: from(n + 1)
val nats = from(0)
val m4s = nats map (_ * 4)

def sieve(s: Stream[Int]): Stream[Int] = {
  s.head #:: sieve(s.tail filter (_ % s.head != 0))
}

(sieve(from(2)) take 100) toList


def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2
  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
  guesses
}

def isGoodEnough(guess: Double, x: Double): Boolean = {
  math.abs((guess * guess - x) / x) < 0.0001
}

sqrtStream(4.0).filter(isGoodEnough(_, 4.0)).take(10).toList
