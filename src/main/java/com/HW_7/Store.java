package com.HW_7;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {

    private static Gson gson = new Gson();

    private ArrayList<Fruit> storage = new ArrayList<>(); // временный склад лавки


    public ArrayList<Fruit> getStorage() {
        return storage;
    }

    public void addFruits(String pathToJsonFile) throws IOException {

        FileReader reader = new FileReader(pathToJsonFile);
        storage.addAll(gson.fromJson(reader, Store.class).getStorage());
        reader.close();
    }

    public void save(String pathToJsonFile) throws IOException {

        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(gson.toJson(storage));
        writer.close();
    }

    public void load(String pathToJsonFile) {
        storage.clear();
        try {
            addFruits(pathToJsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Load isn't finished!");
        }
    }

    public List<Fruit> getSpoiledFruits(Date date) {

        List<Fruit> list = new ArrayList<Fruit>();

        Date expDate = new Date();

        for (int i = 0; i < storage.size(); i++) {
            expDate.setTime(storage.get(i).getShelfLife());
            if (date.after(expDate)) { // если дата, которая принимается - после строка годности
                list.add(storage.get(i));
            }
        }
        return list;
    }

    public List<Fruit> getAvailableFruits(Date date) {

        List<Fruit> list = new ArrayList<Fruit>();

        Date expDate = new Date();
        Date deliveryDate = new Date();

        for (int i = 0; i < storage.size(); i++) {
            expDate.setTime(storage.get(i).getShelfLife());
            deliveryDate.setTime(storage.get(i).getDate());
            if (date.before(expDate) && date.after(deliveryDate)) { // если продукт уже поступил, но ещё не испортился
                list.add(storage.get(i));
            }
        }
        return list;
    }

    public List<Fruit> getSpoiledFruits(Date date, Type type) {

        List<Fruit> list = new ArrayList<Fruit>();

        Date expDate = new Date();

        for (int i = 0; i < storage.size(); i++) {
            expDate.setTime(storage.get(i).getShelfLife());
            if (date.after(expDate) && type.equals(storage.get(i).getType())) {
                list.add(storage.get(i));
            }
        }
        return list;

    }

    public List<Fruit> getAvailableFruits(Date date, Type type) {

        List<Fruit> list = new ArrayList<Fruit>();

        Date expDate = new Date();
        Date deliveryDate = new Date();

        for (int i = 0; i < storage.size(); i++) {
            expDate.setTime(storage.get(i).getShelfLife());
            deliveryDate.setTime(storage.get(i).getDate());
            if (date.before(expDate) && date.after(deliveryDate) && type.equals(storage.get(i).getType())) {
                list.add(storage.get(i));
            }
        }
        return list;
    }

    public List<Fruit> getAddedFruits(Date date) {

        List<Fruit> list = new ArrayList<>();

        Date deliveryDate = new Date();

        for (int i = 0; i < storage.size(); i++) {
            deliveryDate.setTime(storage.get(i).getDate());
            if (date.equals(deliveryDate)) {
                list.add(storage.get(i));
            }
        }
        return list;

    }

    public List<Fruit> getAddedFruits(Date date, Type type) {

        List<Fruit> list = new ArrayList<>();

        Date deliveryDate = new Date();


        for (int i = 0; i < storage.size(); i++) {
            deliveryDate.setTime(storage.get(i).getDate());
            if (date.equals(deliveryDate) && type.equals(storage.get(i).getType())) {
                list.add(storage.get(i));
            }
        }
        return list;

    }

}
