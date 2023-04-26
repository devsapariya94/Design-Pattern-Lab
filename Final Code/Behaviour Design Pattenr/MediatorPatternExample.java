import java.util.ArrayList;
import java.util.List;

interface ChatRoom {
    void sendMessage(String message, User sender);
    void addUser(User user);
}

class ChatRoomImpl implements ChatRoom {
    private List<User> users;
    
    public ChatRoomImpl() {
        this.users = new ArrayList<>();
    }
    
    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
    
    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

abstract class User {
    protected ChatRoom chatRoom;
    protected String name;
    
    public User(ChatRoom chatRoom, String name) {
        this.chatRoom = chatRoom;
        this.name = name;
    }
    
    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }
    
    public abstract void receiveMessage(String message);
}

class ChatUser extends User {
    public ChatUser(ChatRoom chatRoom, String name) {
        super(chatRoom, name);
    }
    
    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoomImpl();
        User user1 = new ChatUser(chatRoom, "Dev");
        User user2 = new ChatUser(chatRoom, "Khush");
        User user3 = new ChatUser(chatRoom, "Ronak");
        
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);
        
        user1.sendMessage("Hello, everyone!");
        user2.sendMessage("Hey, Ronak!");
        user3.sendMessage("What's up?");
    }
}
