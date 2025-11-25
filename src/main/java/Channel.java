public class Channel {
    private User[] users;
    private Message[] messages;
    private User[] admins;

    public Channel(User[] users, String[] adminUsernames) {
        this.users = users;

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

    public void SendMessage(User user, String messageText) {
        boolean isAdmin = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(user.getUsername())) {
                isAdmin = true;
            }
        }
        if (!isAdmin) return;

        Message[] newMessages = new Message[messages.length + 1];

        for (int i = 0; i < messages.length; i++) {
            newMessages[i] = messages[i];
        }

        Message newMessage = new Message(messageText, user.getUsername());

        newMessages[newMessages.length - 1] = newMessage;
    }

}
