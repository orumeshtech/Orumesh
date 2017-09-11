package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Bundle;
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
public class BundleViewModel implements HashesViewModel {
    private Bundle self;
    private Indexable hash;

    public BundleViewModel(Hash hash) {
        this.hash = hash;
    }

    private BundleViewModel(Bundle hashes, Indexable hash) {
        self = hashes == null || hashes.set == null ? new Bundle(): hashes;
        this.hash = hash;
    }

    public static BundleViewModel load(Mesh mesh, Indexable hash) throws Exception {
        return new BundleViewModel((Bundle) mesh.load(Bundle.class, hash), hash);
    }

    public static Map.Entry<Indexable, Persistable> getEntry(Hash hash, Hash hashToMerge) throws Exception {
        Bundle hashes = new Bundle();
        hashes.set.add(hashToMerge);
        return new HashMap.SimpleEntry<>(hash, hashes);
    }

    /*
    public static boolean merge(Hash hash, Hash hashToMerge) throws Exception {
        Bundle hashes = new Bundle();
        hashes.set = new HashSet<>(Collections.singleton(hashToMerge));
        return Mesh.instance().merge(hashes, hash);
    }
    */

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
