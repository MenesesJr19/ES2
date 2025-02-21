package com.es2.factorymethod;

public abstract class FactoryProduct extends Object {
    public FactoryProduct() {

    }

    public static Product makeProduct(String type) throws UndefinedProductException {
        try {
            if ("Software".equals(type)) {
                return new Software();
            } else if ("Computer".equals(type)) {
                return new Computer();
            } else {
                throw new UndefinedProductException();
            }
        } catch (UndefinedProductException e) {
            throw new UndefinedProductException();
        }
    }

}
