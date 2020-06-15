package org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur;

public enum MeetingGroupProposalDecision {

    Accept("ACCEPT"),
    Reject("REJECT");

    private String decision;

    MeetingGroupProposalDecision(String decision) {
        this.decision = decision;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecisionTable(String decision) {
        this.decision = decision;
    }

}
