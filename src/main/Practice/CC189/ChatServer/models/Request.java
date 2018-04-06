package main.Practice.CC189.ChatServer.models;

public class Request {
    private Type type;
    private String fromAccountId;
    private String toAccountName;
    private Status status;

    public Request(Type type, String toAccountName, Status status, String fromAccountId) {
        this.type = type;
        this.toAccountName = toAccountName;
        this.status = status;
        this.fromAccountId = fromAccountId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getToAccountName() {
        return toAccountName;
    }

    public void setToAccountName(String toAccountName) {
        this.toAccountName = toAccountName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
}
