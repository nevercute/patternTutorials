package pro.nevercute.tut.patterns.collections.composite;

public class WaitressAtWork {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu =
                new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu =
                new Menu("DINER MENU", "Lunch");
        MenuComponent dessertMenu =
                new Menu("DESSERT MENU", "Desert of course");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(dessertMenu);

        dinerMenu.add(new MenuItem(
                "Pasta",
                "Spagetti with marinara sauce, and slice of sourdough bread",
                true,
                3.89));

        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem(
                "Apple pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59
        ));

        Waitress waitress = new Waitress(allMenus);
        waitress.print();
        waitress.printVegetarianMenu();
    }
}
