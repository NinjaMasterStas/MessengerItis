public class Message {
    private String message;
    private User sender;
    private String date;

    public Message(String message, User sender, String date) {
        this.message = message;
        this.sender = sender;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public User setSender() {
        return sender;
    }
    public String getDate() {
        return date;
    }
}