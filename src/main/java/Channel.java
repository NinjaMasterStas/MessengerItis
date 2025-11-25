public class Channel {
    private User[] users;
    private Message[] messages;
    private User[] admins;
    private String channelName;

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

        newMessages[messagesCount] = new Message(messageText, username);
        messages = newMessages;
    }
}
