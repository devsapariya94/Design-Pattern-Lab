abstract class Mobile {
    public abstract void makeCall(String phoneNumber);
    public abstract void sendMessage(String message);
    public abstract void playMusic(String song);
}

class SamsungMobile extends Mobile {
    public void makeCall(String phoneNumber) {
        System.out.println("Making a call on a Samsung device to " + phoneNumber);
    }
    public void sendMessage(String message) {
        System.out.println("Sending a message on a Samsung device: " + message);
    }
    public void playMusic(String song) {
        System.out.println("Playing " + song + " on a Samsung device");
    }
}

class AppleMobile extends Mobile {
    public void makeCall(String phoneNumber) {
        System.out.println("Making a call on an Apple device to " + phoneNumber);
    }
    public void sendMessage(String message) {
        System.out.println("Sending a message on an Apple device: " + message);
    }
    public void playMusic(String song) {
        System.out.println("Playing " + song + " on an Apple device");
    }
}

class NokiaMobile extends Mobile {
    public void makeCall(String phoneNumber) {
        System.out.println("Making a call on a Nokia device to " + phoneNumber);
    }
    public void sendMessage(String message) {
        System.out.println("Sending a message on a Nokia device: " + message);
    }
    public void playMusic(String song) {
        System.out.println("Playing " + song + " on a Nokia device");
    }
}

class MobileFactory {
    public static Mobile createMobile(String osName, String deviceName) {
        if (osName.equalsIgnoreCase("Android") && deviceName.equalsIgnoreCase("Samsung")) {
            return new SamsungMobile();
        }
        else if (osName.equalsIgnoreCase("iOS") && deviceName.equalsIgnoreCase("iPhone")) {
            return new AppleMobile();
        }
        else if (osName.equalsIgnoreCase("Windows") && deviceName.equalsIgnoreCase("Nokia")) {
            return new NokiaMobile();
        }
        else {
            throw new IllegalArgumentException("Invalid OS or device name.");
        }
    }
}

public class mobileFactoryDP {
    public static void main(String[] args) {
        Mobile samsungMobile = MobileFactory.createMobile("Android", "Samsung");
        Mobile appleMobile = MobileFactory.createMobile("iOS", "iPhone");
        Mobile nokiaMobile = MobileFactory.createMobile("Windows", "Nokia");

        samsungMobile.makeCall("1234567890");
        appleMobile.sendMessage("Hello, world!");
        nokiaMobile.playMusic("Bones");
    }
}
