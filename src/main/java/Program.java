public class Program {
    public static void main(String[] args) {
        User[] users = new User[] {
                new User(),
                new User("Юля", 19, "-"),
                new User("Шамиль", 19, "м"),
                new User("Станислав", 17, "м")
        };

        Message[] messages = new Message[] {
                new Message("Привет. как дела?", "Шамиль"),
                new Message("хорощо", "Станислав"),
                new Message("Поздравляю", "Юля"),
        };

        Group group = new Group(users, messages);
        group.getAllmessage();
        group.printUsers();
    }
}
