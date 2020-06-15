package org.turoriel.ddd.meetup.infrastructure.objetvaleur.administrateur;

public enum MeetingGroupProposalDecisionTable {

    Accept("ACCEPT"),
    Reject("REJECT");

    private String decisionTable;

    MeetingGroupProposalDecisionTable(String decisionTable) {
        this.decisionTable = decisionTable;
    }

    public String getDecisionTable() {
        return decisionTable;
    }

    public void setDecisionTable(String decisionTable) {
        this.decisionTable = decisionTable;
    }

}
