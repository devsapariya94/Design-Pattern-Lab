import java.util.*;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void showName();
    public abstract int getSize();
}

class File extends FileSystemComponent {
    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    public void showName() {
        System.out.println("File: " + name + " (Size: " + size + " KB)");
    }

    public int getSize() {
        return size;
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    public void showName() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showName();
        }
    }

    public int getSize() {
        int size = 0;
        for (FileSystemComponent component : components) {
            size += component.getSize();
           }
        return size;
    }
}


public class FileManagementSystem {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory home = new Directory("home");
        root.addComponent(home);

        Directory user = new Directory("user");
        home.addComponent(user);

        File file1 = new File("file1.txt", 100);
        user.addComponent(file1);

        File file2 = new File("file2.txt", 200);
        user.addComponent(file2);

        root.showName();
        System.out.println("Total size: " + root.getSize() + " KB");
    }
}
