package com.jicstech.orumesh.model;

import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.utils.Serializer;

/**
 * Created by paul on 5/6/17.
 */
public class IntegerIndex implements Indexable {
    int value;
    public IntegerIndex(int value) {
        this.value = value;
    }

    public IntegerIndex() {}

    public int getValue() {
        return value;
    }

    @Override
    public byte[] bytes() {
        return Serializer.serialize(value);
    }

    @Override
    public void read(byte[] bytes) {
        this.value = Serializer.getInteger(bytes);
    }

    @Override
    public Indexable incremented() {
        return new IntegerIndex(value + 1);
    }

    @Override
    public Indexable decremented() {
        return new IntegerIndex(value - 1);
    }

    @Override
    public int compareTo(Indexable o) {
        IntegerIndex i = new IntegerIndex(Serializer.getInteger(o.bytes()));
        return value - ((IntegerIndex) o).value;
    }
}
