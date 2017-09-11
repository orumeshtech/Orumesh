package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.model.Tag;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Mesh;
import com.jicstech.orumesh.storage.Persistable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * Created by paul on 5/15/17.
 */
public class TagViewModel implements HashesViewModel {
    private Tag self;
    private Indexable hash;

    public TagViewModel(Hash hash) {
        this.hash = hash;
    }

    private TagViewModel(Tag hashes, Indexable hash) {
        self = hashes == null || hashes.set == null ? new Tag(): hashes;
        this.hash = hash;
    }

    public static TagViewModel load(Mesh mesh, Indexable hash) throws Exception {
        return new TagViewModel((Tag) mesh.load(Tag.class, hash), hash);
    }

    public static Map.Entry<Indexable, Persistable> getEntry(Hash hash, Hash hashToMerge) throws Exception {
        Tag hashes = new Tag();
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
