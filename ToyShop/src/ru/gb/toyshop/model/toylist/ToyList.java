package ru.gb.toyshop.model.toylist;

import ru.gb.toyshop.model.toy.Toy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyList<E extends ToyItem> implements Serializable, Iterable<E>{

    private List<E> toyList;
    private int toyId;
    private int total;

    public ToyList() {
        toyList = new ArrayList<>();
    }

    public void addToy(E toy) {
        toy.setId(toyId++);
        toyList.add(toy);
    }

    public List<E> makeList() {
        List<E> result = new ArrayList<>();
        result.addAll(toyList);
        return result;
    }

    public List<E> getToyList() {
        return toyList;
    }

    public Toy chooseToy() {
        int maxFrequency = 0;
        Toy choice = null;
        for (E toy: toyList) {
            if (toy.getFrequency() > maxFrequency) {
                maxFrequency = toy.getFrequency();
                choice = (Toy) toy;
            }
        }
        choice.setNumberOfToys(choice.getNumberOfToys() - 1);
        setFrequences(this.getTotal() - 1);
        return choice;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setFrequences(int total) {
        setTotal(total);
        if (total != 0) {
            for (E toy: toyList) {
                toy.setFrequency(toy.getNumberOfToys()*100/getTotal());
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toyList);
    }

    public Toy findInList(int id) {
        for (E toy : toyList) {
            if (toy.getId() == id) {
                return (Toy) toy;
            }
        }
        return null;
    }
    public void deleteToy(int id) {
        for (E toy : toyList) {
            if (toy.getId() == id) {
                toyList.remove(toy);
            }
        }
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (E toy : toyList) {
            sb.append(toy).append("\n");
        }
        return sb.toString();
    }
}
