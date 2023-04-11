import java.util.ArrayList;
import java.util.List;

class OriginatorObject{
    private String content;
    private String fontName;

    public OriginatorObject(String content, String fontName) {
        this.content = content;
        this.fontName = fontName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public String getContent() {
        return content;
    }

    public String getFontName() {
        return fontName;
    }

    @Override
    public String toString() {
        return "Content: " + content + " and FontName: " + fontName;
    }

    public MementoObject saveStateToMemento() {
        return new MementoObject(content, fontName);
    }

    public void restoreStateFromMemento(MementoObject memento) {
        content = memento.getContent();
        fontName = memento.getFontName();
    }


}

class MementoObject{
    private String content;
    private String fontName;

    public MementoObject(String content, String fontName) {
        this.content = content;
        this.fontName = fontName;
    }

    public String getContent() {
        return content;
    }

    public String getFontName() {
        return fontName;
    }
}


class CareTakerObject{
    private List<MementoObject> mementoList = new ArrayList<MementoObject>();

    public void add(MementoObject state){
        mementoList.add(state);
    }

    public MementoObject get(int index){
        return mementoList.get(index);
    }
}

public class MementoPatternTestArticalFormating {
    public static void main(String[] args) {
        CareTakerObject careTaker = new CareTakerObject();

        OriginatorObject originator = new OriginatorObject("This is the content.", "Times New Roman");
        careTaker.add(originator.saveStateToMemento());

        originator.setFontName("Arial");
        careTaker.add(originator.saveStateToMemento());

        originator.setContent("This is new content.");
        System.out.println("Current State: " + originator);

        originator.restoreStateFromMemento(careTaker.get(1));
        System.out.println("First saved State: " + originator);

        originator.restoreStateFromMemento(careTaker.get(0));
        System.out.println("Second saved State: " + originator);
    }
}

