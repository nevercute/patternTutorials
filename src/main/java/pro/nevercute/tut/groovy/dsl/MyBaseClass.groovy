package pro.nevercute.tut.groovy.dsl

 abstract class MyBaseClass extends Script {
    String name
    public void greet() {println "Hello $name"}
}

