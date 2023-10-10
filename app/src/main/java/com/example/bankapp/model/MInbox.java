package com.example.bankapp.model;

public class MInbox {
    private String inboxName;
    private String inboxMsg;

    public MInbox(String inboxName, String inboxMsg) {
        this.inboxName = inboxName;
        this.inboxMsg = inboxMsg;
    }


    public String getInboxName() {
        return inboxName;
    }

    public void setInboxName(String inboxName) {
        this.inboxName = inboxName;
    }

    public String getInboxMsg() {
        return inboxMsg;
    }

    public void setInboxMsg(String inboxMsg) {
        this.inboxMsg = inboxMsg;
    }
}
