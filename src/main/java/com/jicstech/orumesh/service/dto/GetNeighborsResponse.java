package com.jicstech.orumesh.service.dto;

import java.util.List;

public class GetNeighborsResponse extends AbstractResponse {

    private Neighbor[] neighbors;

    public Neighbor[] getNeighbors() {
        return neighbors;
    }

    static class Neighbor {

        private String address;
        public long numberOfAllTransactions, numberOfRandomTransactionRequests, numberOfNewTransactions, numberOfInvalidTransactions, numberOfSentTransactions;
        public String connectionType;

        public String getAddress() {
            return address;
        }

        public long getNumberOfAllTransactions() {
            return numberOfAllTransactions;
        }

        public long getNumberOfNewTransactions() {
            return numberOfNewTransactions;
        }

        public long getNumberOfInvalidTransactions() {
            return numberOfInvalidTransactions;
        }
        
        public long getNumberOfSentTransactions() {
            return numberOfSentTransactions;
        }

        public String getConnectionType() {
            return connectionType;
        }

        public static Neighbor createFrom(com.jicstech.orumesh.network.Neighbor n) {
            Neighbor ne = new Neighbor();
            int port = n.getPort();
            ne.address = n.getAddress().getHostString() + ":" + port;
            ne.numberOfAllTransactions = n.getNumberOfAllTransactions();
            ne.numberOfInvalidTransactions = n.getNumberOfInvalidTransactions();
            ne.numberOfNewTransactions = n.getNumberOfNewTransactions();
            ne.numberOfRandomTransactionRequests = n.getNumberOfRandomTransactionRequests();
            ne.numberOfSentTransactions = n.getNumberOfSentTransactions();
            ne.connectionType = n.connectionType();
            return ne;
        }
    }

    public static AbstractResponse create(final List<com.jicstech.orumesh.network.Neighbor> elements) {
        GetNeighborsResponse res = new GetNeighborsResponse();
        res.neighbors = new Neighbor[elements.size()];
        int i = 0;
        for (com.jicstech.orumesh.network.Neighbor n : elements) {
            res.neighbors[i++] = Neighbor.createFrom(n);
        }
        return res;
    }

}
