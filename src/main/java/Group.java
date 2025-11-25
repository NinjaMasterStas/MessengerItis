public class Group {
    private User[] users;
    private Message[] messages;

    public Group(User[] users, Message[] messages) {
        this.users = users;
        this.messages = messages;
    }

    public void getAllmessage() {
        for (int i = 0; i < messages.length; ++i) {
            System.out.println("Текст " + messages[i].getMessage() +
                    " Отправитель " + messages[i].getSenderUsername() + " Время " +
                    messages[i].getDate());
        }
    }

    public void printUsers() {
        for (int i = 0; i < users.length; ++i) {
            System.out.println(users[i].getUsername());
        }
    }

    public void newMessages(String message, String userName) {
        int countMessage = messages.length;

        Message[] newMessages = new Message[countMessage + 1];
        for (int i = 0; i < countMessage; ++i) {
            newMessages[i] = messages[i];
        }
        newMessages[countMessage] = new Message(message, userName);
        messages = newMessages;
    }
}
