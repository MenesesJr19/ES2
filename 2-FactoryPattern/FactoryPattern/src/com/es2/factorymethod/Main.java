package com.es2.factorymethod;

public class Main {
    public static void main(String[] args) throws UndefinedProductException {
        Product computer = FactoryProduct.makeProduct("Computer");
        Product software = FactoryProduct.makeProduct("Software");

        computer.setBrand("BrandX");
        software.setBrand("BrandY");

        System.out.println("Computer Brand: " + computer.getBrand());
        System.out.println("Software Brand: " + software.getBrand());
    }
}