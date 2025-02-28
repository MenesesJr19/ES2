package com.es2.composite;

public class Main {
    public static void main(String[] args) {
        Link link = new Link();
        link.setLabel("Google");
        link.setURL("https://www.google.com");

        SubMenu submenu = new SubMenu();
        submenu.setLabel("Favoritos");

        Link link1 = new Link();
        link1.setLabel("GitHub");
        link1.setURL("https://www.github.com");

        SubMenu submenu2 = new SubMenu();
        submenu2.setLabel("Redes Sociais");

        Link link2 = new Link();
        link2.setLabel("Facebook");
        link2.setURL("https://www.facebook.com");

        submenu2.addChild(link2);

        submenu.addChild(link1);
        submenu.addChild(submenu2);

        System.out.println("Link:");
        link.showOptions();

        System.out.println("\nSubmenu:");
        submenu.showOptions();
    }
}
