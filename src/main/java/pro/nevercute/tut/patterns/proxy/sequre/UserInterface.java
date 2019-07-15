package pro.nevercute.tut.patterns.proxy.sequre;

import java.lang.reflect.Proxy;

public class UserInterface {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.go();
    }

    public void go(){
        PersonBean aleks = new PersonBeanImpl("Aleks","Male", "Programmer, Engineer, Producer");
        PersonBean sofa = new PersonBeanImpl("Sofa","FeMale", "Programmer, Designer, Coach");
        PersonBean matt = new PersonBeanImpl("Matt","Male", "Musician, Engineer, Art");
        System.out.println(aleks);
        System.out.println(sofa);
        System.out.println(matt);

        PersonBean ownerProxy = getOwnerProxy(aleks);
        System.out.println("Name is "+ownerProxy.getName());
        ownerProxy.setInterests("Programmer, Engineer, Producer, Compositor");
        System.out.println("Interests set from owner proxy");
        try{
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
            System.out.println("You can't set rating from owner proxy");
        }
        System.out.println("Rating is "+ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(aleks);
        System.out.println("Name is "+nonOwnerProxy.getName());
        try{
            nonOwnerProxy.setInterests("Nothing to do");
        }catch (Exception e){
            System.out.println("You can'r set interestst from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(10);
        System.out.println("Rating was set from non owner proxy");
        System.out.println("Rating for "+nonOwnerProxy.getName()+" is "+nonOwnerProxy.getHotOrNotRating());
    }

    public PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    public PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person)
        );
    }
}
