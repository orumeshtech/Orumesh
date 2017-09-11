package com.jicstech.orumesh.controllers;





import com.jicstech.orumesh.model.Hash;
import com.jicstech.orumesh.model.IntegerIndex;
import com.jicstech.orumesh.model.Milestone;
import com.jicstech.orumesh.storage.Indexable;
import com.jicstech.orumesh.storage.Mesh;
import com.jicstech.orumesh.storage.Persistable;
import com.jicstech.orumesh.utils.Pair;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by paul on 4/11/17.
 */
public class MilestoneViewModel {
    private final Milestone milestone;
    private static final Map<Integer, MilestoneViewModel> milestones = new ConcurrentHashMap<>();

    private MilestoneViewModel(final Milestone milestone) {
        this.milestone = milestone;
    }

    public static void clear() {
        milestones.clear();
    }

    public MilestoneViewModel(final int index, final Hash milestoneHash) {
        this.milestone = new Milestone();
        this.milestone.index = new IntegerIndex(index);
        milestone.hash = milestoneHash;
    }

    public static MilestoneViewModel get(Mesh mesh, int index) throws Exception {
        MilestoneViewModel milestoneViewModel = milestones.get(index);
        if(milestoneViewModel == null && load(mesh, index)) {
            milestoneViewModel = milestones.get(index);
        }
        return milestoneViewModel;
    }

    public static boolean load(Mesh mesh, int index) throws Exception {
        Milestone milestone = (Milestone) mesh.load(Milestone.class, new IntegerIndex(index));
        if(milestone != null && milestone.hash != null) {
            milestones.put(index, new MilestoneViewModel(milestone));
            return true;
        }
        return false;
    }

    public static MilestoneViewModel first(Mesh mesh) throws Exception {
        Pair<Indexable, Persistable> milestonePair = mesh.getFirst(Milestone.class, IntegerIndex.class);
        if(milestonePair != null && milestonePair.hi != null) {
            Milestone milestone = (Milestone) milestonePair.hi;
            return new MilestoneViewModel(milestone);
        }
        return null;
    }

    public static MilestoneViewModel latest(Mesh mesh) throws Exception {
        Pair<Indexable, Persistable> milestonePair = mesh.getLatest(Milestone.class, IntegerIndex.class);
        if(milestonePair != null && milestonePair.hi != null) {
            Milestone milestone = (Milestone) milestonePair.hi;
            return new MilestoneViewModel(milestone);
        }
        return null;
    }

    public MilestoneViewModel previous(Mesh mesh) throws Exception {
        Pair<Indexable, Persistable> milestonePair = mesh.previous(Milestone.class, this.milestone.index);
        if(milestonePair != null && milestonePair.hi != null) {
            Milestone milestone = (Milestone) milestonePair.hi;
            return new MilestoneViewModel((Milestone) milestone);
        }
        return null;
    }

    public MilestoneViewModel next(Mesh mesh) throws Exception {
        Pair<Indexable, Persistable> milestonePair = mesh.next(Milestone.class, this.milestone.index);
        if(milestonePair != null && milestonePair.hi != null) {
            Milestone milestone = (Milestone) milestonePair.hi;
            return new MilestoneViewModel((Milestone) milestone);
        }
        return null;
    }

    public MilestoneViewModel nextWithSnapshot(Mesh mesh) throws Exception {
        MilestoneViewModel milestoneViewModel = next(mesh);
        while(milestoneViewModel !=null && !StateDiffViewModel.exists(mesh, milestoneViewModel.getHash())) {
            milestoneViewModel = milestoneViewModel.next(mesh);
        }
        return milestoneViewModel;
    }

    public static MilestoneViewModel firstWithSnapshot(Mesh mesh) throws Exception {
        MilestoneViewModel milestoneViewModel = first(mesh);
        while(milestoneViewModel !=null && !StateDiffViewModel.exists(mesh, milestoneViewModel.getHash())) {
            milestoneViewModel = milestoneViewModel.next(mesh);
        }
        return milestoneViewModel;
    }

    public static MilestoneViewModel findClosestPrevMilestone(Mesh mesh, int index) throws Exception {
        Pair<Indexable, Persistable> milestonePair = mesh.previous(Milestone.class, new IntegerIndex(index));
        if(milestonePair != null && milestonePair.hi != null) {
            return new MilestoneViewModel((Milestone) milestonePair.hi);
        }
        return null;
    }

    public static MilestoneViewModel findClosestNextMilestone(Mesh mesh, int index) throws Exception {
        if(index <= 0) {
            return first(mesh);
        }
        Pair<Indexable, Persistable> milestonePair = mesh.next(Milestone.class, new IntegerIndex(index));
        if(milestonePair != null && milestonePair.hi != null) {
            return new MilestoneViewModel((Milestone) milestonePair.hi);
        }
        return null;
    }

    public static MilestoneViewModel latestWithSnapshot(Mesh mesh) throws Exception {
        MilestoneViewModel milestoneViewModel = latest(mesh);
        while(milestoneViewModel !=null && !StateDiffViewModel.exists(mesh, milestoneViewModel.getHash())) {
            milestoneViewModel = milestoneViewModel.previous(mesh);
        }
        return milestoneViewModel;
    }

    public boolean store(Mesh mesh) throws Exception {
        return mesh.save(milestone, milestone.index);
    }

    public Hash getHash() {
        return milestone.hash;
    }
    public Integer index() {
        return milestone.index.getValue();
    }

    public void delete(Mesh mesh) throws Exception {
        mesh.delete(Milestone.class, milestone.index);
    }

}
