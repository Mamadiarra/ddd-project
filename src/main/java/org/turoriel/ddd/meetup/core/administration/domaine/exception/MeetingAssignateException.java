package org.turoriel.ddd.meetup.core.administration.domaine.exception;

public class MeetingAssignateException extends RuntimeException {

    public MeetingAssignateException() {
        super("Vous ne pouvez pas effectuer d'action, car ce meeting ne vous ait pas assigné");
    }

}
