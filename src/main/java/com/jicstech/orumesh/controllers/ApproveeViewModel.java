package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Approvee;
import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Persistable;
import com.jicstech.orumesh.storage.Mesh;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by paul on 5/15/17.
 */
public class ApproveeViewModel implements HashesViewModel {
    private Approvee self;
    private Indexable hash;

    public ApproveeViewModel(Hash hash) {
        this.hash = hash;
    }

    private ApproveeViewModel(Approvee hashes, Indexable hash) {
        self = hashes == null || hashes.set == null ? new Approvee(): hashes;
        this.hash = hash;
    }

    public static ApproveeViewModel load(Mesh mesh, Indexable hash) throws Exception {
        return new ApproveeViewModel((Approvee) mesh.load(Approvee.class, hash), hash);
    }

    public static Map.Entry<Indexable, Persistable> getEntry(Hash hash, Hash hashToMerge) throws Exception {
        Approvee hashes = new Approvee();
        hashes.set.add(hashToMerge);
        return new HashMap.SimpleEntry<>(hash, hashes);
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
