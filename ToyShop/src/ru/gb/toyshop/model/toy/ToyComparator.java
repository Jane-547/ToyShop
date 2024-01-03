package ru.gb.toyshop.model.toy;

import ru.gb.toyshop.model.toylist.ToyItem;

import java.util.Comparator;

public class ToyComparator <E extends ToyItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getFrequency(), o2.getFrequency());
    }

}
