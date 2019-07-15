package pro.nevercute.tut.groovy.dsl

import org.codehaus.groovy.control.CompilerConfiguration

def config = new CompilerConfiguration()
config.scriptBaseClass = 'pro.nevercute.tut.groovy.dsl.MyBaseClass'
def shell = new GroovyShell(this.class.classLoader, config)
shell.evaluate """ 
setName 
'Aleksandr'  
greet()
"""