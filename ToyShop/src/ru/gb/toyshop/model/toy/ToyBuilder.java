package ru.gb.toyshop.model.toy;

import ru.gb.toyshop.model.toy.Toy;

public class ToyBuilder {

    public Toy build(String name, int numberOfToys) {
        return new Toy(name, numberOfToys);
    }
}
