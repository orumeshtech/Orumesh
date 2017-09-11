package com.jicstech.orumesh.controllers;

import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Mesh;

import java.util.*;

/**
 * Created by paul on 5/6/17.
 */
public interface HashesViewModel {
    boolean store(Mesh mesh) throws Exception;
    int size();
    boolean addHash(Hash theHash);
    Indexable getIndex();
    Set<Hash> getHashes();
}
