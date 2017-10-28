package com.jicstech.orumesh.controllers;


import com.jicstech.orumesh.model.Approvee;
import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.model.Transaction;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Mesh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class TipsViewModel {
    final Logger log = LoggerFactory.getLogger(TipsViewModel.class);

    private Set<Hash> tips = new HashSet<>();
    private Set<Hash> solidTips = new HashSet<>();
    private SecureRandom seed = new SecureRandom();
    public final Object sync = new Object();

    public boolean addTipHash (Hash hash) throws ExecutionException, InterruptedException {
        synchronized (sync) {
           
             return tips.add(hash);
        }
    }

    public boolean removeTipHash (Hash hash) throws ExecutionException, InterruptedException {
        synchronized (sync) {
            if(!tips.remove(hash)) {
                return solidTips.remove(hash);
            }
        }
        return true;
    }

    public void setSolid(Hash tip) {
        synchronized (sync) {
            if(!tips.remove(tip)) {
                solidTips.add(tip);
            }
        }
    }

    public Set<Hash> getTips() {
        Set<Hash> hashes = new HashSet<>();
        synchronized (sync) {
            hashes.addAll(tips);
            hashes.addAll(solidTips);
        }
        return hashes;
    }
    public Hash getRandomSolidTipHash() {
        synchronized (sync) {
            int size = solidTips.size();
            if(size == 0) {
                return null;
            }
            int index = seed.nextInt(size);
            Iterator<Hash> hashIterator;
            hashIterator = solidTips.iterator();
            Hash hash = null;
            while(index-- > 1 && hashIterator.hasNext()){ hash = hashIterator.next();}
            return hash;
            //return solidTips.size() != 0 ? solidTips.get(seed.nextInt(solidTips.size())) : getRandomNonSolidTipHash();
        }
    }

    public Hash getRandomNonSolidTipHash() {
        synchronized (sync) {
            int size = tips.size();
            if(size == 0) {
                return null;
            }
            int index = seed.nextInt(size);
            Iterator<Hash> hashIterator;
            hashIterator = tips.iterator();
            Hash hash = null;
            while(index-- > 1 && hashIterator.hasNext()){ hash = hashIterator.next();}
            return hash;
            //return tips.size() != 0 ? tips.get(seed.nextInt(tips.size())) : null;
        }
    }

    public Hash getRandomTipHash() throws ExecutionException, InterruptedException {
        synchronized (sync) {
            if(size() == 0) {
                return null;
            }
            int index = seed.nextInt(size());
            if(index >= tips.size()) {
                return getRandomSolidTipHash();
            } else {
                return getRandomNonSolidTipHash();
            }
        }
    }

    public int nonSolidSize() {
        synchronized (sync) {
            return tips.size();
        }
    }

    public int size() {
        return tips.size() + solidTips.size();
    }

    public void loadTipHashes(Mesh mesh) throws Exception {
        Set<Indexable> hashes = mesh.keysWithMissingReferences(Transaction.class, Approvee.class);
        if(hashes != null) {
            tips.addAll(hashes.stream().map(h -> (Hash) h).collect(Collectors.toList()));
        }
    }
}
