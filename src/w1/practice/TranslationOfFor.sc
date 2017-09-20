def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  for(x <- xs) yield f(x)

def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  for(x <- xs; y <- f(x)) yield y

def filter[T](xs: List[T], p: T => Boolean): List[T] =
  for(x <- xs; if p(x)) yield x

def isPrime(n: Int): Boolean = {
  !((2 until n) exists (x => n%x == 0))
}

isPrime(7)

for {
  i <- 1 until 100
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)


(1 until 100).flatMap(i =>
  (1 until i).withFilter(j => isPrime(i + j)) map (j => (i,j)))
