package javacore.week5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        Animal result[];
        int n;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
            n = objectInputStream.readInt();
            result = new Animal[n];
            for (int i = 0; i < n; i++) {
                result[i] = (Animal) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalArgumentException();
        }

        return result;
    }
}
