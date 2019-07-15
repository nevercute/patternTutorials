package pro.nevercute.tut.groovy.dsl


String takeString(String message){
    assert message instanceof String
    return message
}
def message = "The message is ${'hello'}"
assert message instanceof GString

def result = takeString(message)
assert result instanceof String
assert result == 'The message is hello'

