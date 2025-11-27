import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private String messageText;
    private String senderUsername;
    private String date;

    public Message(String message, String senderUsername, int timeOffset) {
        this.messageText = message;
        this.senderUsername = senderUsername;
        this.date = LocalDateTime.now().plusMinutes(timeOffset).plusSeconds(timeOffset).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));;
    }

    public String getMessage() {
        return messageText;
    }
    public String getSenderUsername() {
        return senderUsername;
    }
    public String getDate() {
        return date;
    }
}