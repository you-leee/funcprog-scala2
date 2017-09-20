// Rewriting rule
def iterate(n: Int, f: Int => Int, x: Int): Int = {
  if(n == 0) x else iterate(n - 1, f, f(x))
}
def square(x: Int) = x*x
iterate(1, square, 3)

// rewritten as follows:
if(1 == 0) 3 else iterate(1 -1, square, square(3)) // =>
iterate(0, square, square(3)) // =>
iterate(0, square, 3*3) // =>
iterate(0, square, 9)  // =>
if(0 == 0) 9 else iterate(0 - 1, square, square(9))

