package pro.nevercute.tut.patterns.collections.iterator.menu;

import java.util.Arrays;

public class WaitressAtWork {
    public static void main(String[] args) {
        Waitress waitress = new Waitress(Arrays.asList(new PancakeHouseMenu(), new DinerMenu()));
        waitress.printMenu();
    }
}
