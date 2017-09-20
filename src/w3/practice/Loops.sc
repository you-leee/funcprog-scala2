def REPEAT(command: => Unit)(condition: => Boolean): Unit = {
  command
  if(condition) {}
  else REPEAT(command)(condition)
}