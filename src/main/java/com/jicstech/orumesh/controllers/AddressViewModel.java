package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Address;
import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Mesh;

import java.util.Set;

/**
 * Created by paul on 5/15/17.
 */
public class AddressViewModel implements HashesViewModel {
    private Address self;
    private Indexable hash;

    public AddressViewModel(Hash hash) {
        this.hash = hash;
    }

    private AddressViewModel(Address hashes, Indexable hash) {
        self = hashes == null || hashes.set == null ? new Address(): hashes;
        this.hash = hash;
    }

    public static AddressViewModel load(Mesh mesh, Indexable hash) throws Exception {
        return new AddressViewModel((Address) mesh.load(Address.class, hash), hash);
    }

    public boolean store(Mesh mesh) throws Exception {
        return mesh.save(self, hash);
    }

    public int size() {
        return self.set.size();
    }

    public boolean addHash(Hash theHash) {
        return getHashes().add(theHash);
    }

    public Indexable getIndex() {
        return hash;
    }

    public Set<Hash> getHashes() {
        return self.set;
    }
}
