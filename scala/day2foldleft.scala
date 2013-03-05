// run interactively

val list = List("one", "two", "three", "four")
val size = (0 /: list) {(size, i) => size + i.size}
println(size)
println("")