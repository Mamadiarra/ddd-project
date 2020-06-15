package org.turoriel.ddd.meetup.infrastructure.objetvaleur.administrateur;

public enum MeetingGroupProposalStatusTable {

    Accepted("ACCEPTED"),
    InVerification("INVERIFICATION"),
    Rejected("REJECTED");

    private String status;

    MeetingGroupProposalStatusTable(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
