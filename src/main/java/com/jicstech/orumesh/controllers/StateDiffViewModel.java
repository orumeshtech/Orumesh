package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.model.StateDiff;
import com.jicstech.orumesh.storage.Mesh;

import java.util.Map;

/**
 * Created by paul on 5/6/17.
 */
public class StateDiffViewModel {
    private StateDiff stateDiff;
    private Hash hash;

    public static StateDiffViewModel load(Mesh mesh, Hash hash) throws Exception {
        return new StateDiffViewModel((StateDiff) mesh.load(StateDiff.class, hash), hash);
    }

    public StateDiffViewModel(final Map<Hash, Long> state, final Hash hash) {
        this.hash = hash;
        this.stateDiff = new StateDiff();
        this.stateDiff.state = state;
    }

    public static boolean exists(Mesh mesh, Hash hash) throws Exception {
        return mesh.maybeHas(StateDiff.class, hash);
    }

    StateDiffViewModel(final StateDiff diff, final Hash hash) {
        this.hash = hash;
        this.stateDiff = diff == null || diff.state == null ? new StateDiff(): diff;
    }

    public Hash getHash() {
        return hash;
    }

    public Map<Hash, Long> getDiff() {
        return stateDiff.state;
    }

    public boolean store(Mesh mesh) throws Exception {
        //return Mesh.instance().save(stateDiff, hash).get();
        return mesh.save(stateDiff, hash);
    }

    public void delete(Mesh mesh) throws Exception {
        mesh.delete(StateDiff.class, hash);
    }
}
