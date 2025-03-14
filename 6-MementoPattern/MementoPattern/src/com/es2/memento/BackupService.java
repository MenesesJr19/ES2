package com.es2.memento;

import java.util.ArrayList;

public class BackupService {
    private ArrayList<Memento> snapshots;
    private Server server;

    public BackupService(Server server) {
        this.server = server;
        snapshots = new ArrayList<>();
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if (snapshotNumber >= 0 && snapshotNumber < snapshots.size()) {
            server.restore(snapshots.get(snapshotNumber));
        } else {
            throw new NotExistingSnapshotException();
        }
    }

    public void takeSnapshot() {
        snapshots.add(server.backup());
    }
    //ez frag
}
