package org.turoriel.ddd.meetup.core.administration.domaine.objetvaleur;

public enum MeetingGroupProposalStatus {

    Accepted("ACCEPTED"),
    InVerification("INVERIFICATION"),
    Rejected("REJECTED");

    private String status;

    MeetingGroupProposalStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
