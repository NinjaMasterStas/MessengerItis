public class Program {
    public static void main(String[] args) {

        User[] users = new User[] {
                new User(),
                new User("Юля", 19, "-"),
                new User("Шамиль", 19, "м"),
                new User("Стасян", 17, "м")
        };

        Group group = new Group(users, "Хорошая группа");
        group.newMessage("Привет. как дела?", "Шамиль");
        group.newMessage("хорощо", "Стасян");
        group.newMessage("Поздравляю", "Юля");
        group.newMessage("Можете меня добавить", "Виталий");

        group.printUsers();
        group.printAllMessages();
    }
}
