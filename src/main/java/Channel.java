import java.util.Random;

public class Channel {
    private User[] users;
    private Message[] messages;
    private User[] admins;
    private String channelName;

    private int timeOffset;

    public Channel(User[] users, String[] adminUsernames, String channelName) {
        this.users = users;
        this.channelName = channelName;

        admins = new User[adminUsernames.length];
        for (int i = 0; i < adminUsernames.length; i++) {
            User admin = new User();
            boolean isAdminFinded = false;
            for (int j = 0; j < users.length; j++) {
                if (users[j].getUsername().equals(adminUsernames[i])) {
                    admin = users[j];
                    isAdminFinded = true;
                    break;
                }
            }

            if (!isAdminFinded) continue;

            admins[i] = admin;
        }
    }

    public void newMessage(String messageText, String username) {
        boolean isAdmin = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(username)) {
                isAdmin = true;
            }
        }
        if (!isAdmin) return;

        int messagesCount = 0;
        if (messages != null) messagesCount = messages.length;

        Message[] newMessages = new Message[messagesCount + 1];

        for (int i = 0; i < messagesCount; ++i) {
            newMessages[i] = messages[i];
        }

        newMessages[messagesCount] = new Message(messageText, username, timeOffset);
        messages = newMessages;

        Random random = new Random();
        timeOffset += random.nextInt(30);
    }

    public void printAllMessages() {
        System.out.println("Сообщения внутри канала: <" + channelName + ">:");
        for (Message message : messages) {
            System.out.println("Админ " + message.getSenderUsername() + " в " +
                    message.getDate() + ": " + message.getMessage());
        }
        System.out.println();
    }

    public void printUsers() {
        System.out.println("Пользователи внутри канала <" + channelName + ">:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
        System.out.println();
    }

    public void printAdmins() {
        System.out.println("Админы внутри канала <" + channelName + ">:");
        for (User admin : admins) {
            System.out.println(admin.getUsername());
        }
        System.out.println();
    }
}
