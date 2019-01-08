package com.cesi.database.models;

public enum Status {
    NOT_BEGIN,
    IN_PROGRESS,
    FINISHED,
    ABANDONNED,
    INVALID;

    public static Status from(int status) {
        switch (status) {
            case 0: return NOT_BEGIN;
            case 1: return IN_PROGRESS;
            case 2: return FINISHED;
            case 3: return ABANDONNED;
            default: return null;
        }
    }
}
