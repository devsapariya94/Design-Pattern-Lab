interface Mobile {
    public void OSname();
    public void playmusic();
    public void sendMessage();
}

class Samsung implements Mobile {

    @Override
    public void OSname() {
        System.out.println("Samsung is Android");
    }

    @Override
    public void playmusic() {
        System.out.println("Play Music in Samsung");
    }

    @Override
    public void sendMessage() {
        System.out.println("Send Message in Samsung");
    }
}

class Apple implements Mobile {

    @Override
    public void OSname() {
        System.out.println("Apple has IOS");
    }

    @Override
    public void playmusic() {
        System.out.println("Play Music in Apple");
    }

    @Override
    public void sendMessage() {
        System.out.println("Send Message in Apple");
    }
}

class Nokia implements Mobile {

    @Override
    public void OSname() {
        System.out.println("Nokia had Windows OS");
    }

    @Override
    public void playmusic() {
        System.out.println("Play Music in Nokia");
    }

    @Override
    public void sendMessage() {
        System.out.println("Send Message in Nokia");
    }
}

class MobileFactory {
    public Mobile getMobile(String type) {
        if (type.equals("Samsung")) {
            return new Samsung();
        } else if (type.equals("Apple")) {
            return new Apple();
        } else if (type.equals("Nokia")) {
            return new Nokia();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        MobileFactory m1 = new MobileFactory();
        Mobile m2 = m1.getMobile("Apple");
        m2.OSname();
        m2.playmusic();

        MobileFactory s1 = new MobileFactory();
        Mobile s2 = s1.getMobile("Samsung");
        s2.OSname();
        s2.sendMessage();

    }
}