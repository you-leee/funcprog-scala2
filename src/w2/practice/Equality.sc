def streamRange(lo: Int, hi: Int): Stream[Int] = {
  if(lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

def listRange(lo: Int, hi: Int): List[Int] = {
  if(lo >= hi) Nil
  else lo :: listRange(lo + 1, hi)
}

val stream1 = streamRange(0,10)
val stream2 = streamRange(0,10)
stream1 == stream2
stream1.eq(stream2)
stream1.equals(stream2)

val list1 = listRange(0,10)
stream1.equals(list1)
stream1.eq(list1)
stream1 == list1

val stream3 = stream1
stream1 == stream3
stream1.eq(stream3)
stream1.equals(stream3)

lazy val list2 = listRange(0,10)
lazy val stream4 = streamRange(0, 10)
def list3 = listRange(0,10)
list3