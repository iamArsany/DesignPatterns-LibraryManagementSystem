package com.library.approval;

public abstract class BaseApprover {
    protected BaseApprover nextApprover;

    public void setNext(BaseApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(int days);
}
