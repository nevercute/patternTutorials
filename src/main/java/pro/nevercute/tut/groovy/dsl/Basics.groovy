package pro.nevercute.tut.groovy.dsl

def key = "a"
def hCode = "${key}".hashCode()

println(hCode)
def map = [red: "red", blue : "blue"]
def map2 = [("${key}".hashCode()): "keyValue = a"]

println(map2)
println(map2[("${key}".hashCode())])
println(map.red)
println(map.someKey)

assert map instanceof LinkedHashMap