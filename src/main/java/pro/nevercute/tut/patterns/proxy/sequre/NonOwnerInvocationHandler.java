package pro.nevercute.tut.patterns.proxy.sequre;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {
    private PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person){
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try{
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if(method.getName().equals("setHotOrNotRating")){
                return method.invoke(person, args);
            } else if(method.getName().startsWith("set")){
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
