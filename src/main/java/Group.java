public class Group {
    private User[] users;
    private Message[] messages;
    private String groupName;

    public Group(User[] users, String groupName) {
        this.users = users;
        this.groupName = groupName;
    }

    public void printAllMessages() {
        System.out.println("Сообщения внутри группы: <" + groupName + ">:");
        for (Message message : messages) {
            System.out.println("Пользователь " + message.getSenderUsername() + " в " +
                    message.getDate() + ": " + message.getMessage());
        }
        System.out.println();
    }

    public void printUsers() {
        System.out.println("Пользователи внутри группы <" + groupName + ">:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        System.out.println();
    }

    public void newMessage(String messageText, String username) {
        boolean ThisIsUserInGroup = false;
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                ThisIsUserInGroup = true;
                break;
            }
        }
        if (!ThisIsUserInGroup) return;

        int CountMessages = 0;
        if (messages != null) CountMessages = messages.length;

        Message[] NewMessages = new Message[CountMessages + 1];
        for (int i = 0; i < CountMessages; ++i) {
            NewMessages[i] = messages[i];
        }

        NewMessages[CountMessages] = new Message(messageText, username);
        messages = NewMessages;

    }
}

