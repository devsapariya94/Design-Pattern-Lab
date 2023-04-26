import java.util.ArrayList;
import java.util.List;
public class MementoArticalTest {
    public static void main(String[] args) {
        Originator o1 = new Originator("Dev", "TOR", 18);
        CaretakerObj c = new CaretakerObj();
        MementoObj m = o1.saveStateToMemento();

        System.out.println(o1);
        c.addMementoObject(m);

        o1.setContent("Ronak");
        o1.setFontSize(20);
        o1.setFontType("Bold");
        System.out.println(o1);
        m = o1.saveStateToMemento();
        c.addMementoObject(m);

        o1.setContent("Khush");
        o1.setFontSize(24);
        o1.setFontType("Bold_TOM");
        System.out.println(o1);
        m = o1.saveStateToMemento();
        c.addMementoObject(m);

        o1.setContent("Mahesh");
        o1.setFontSize(30);
        o1.setFontType("Bold");
        System.out.println(o1);
        m = o1.saveStateToMemento();
        c.addMementoObject(m);

        o1.restoreState(c.getMementoObj(0));
        System.out.println(o1);
    }
}
class Originator{
    private String content;
    private String fontType;
    private int fontSize;
    public Originator(String c, String ft, int fs){
        content = c;
        fontType = ft;
        fontSize = fs;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFontType() {
        return fontType;
    }
    public void setFontType(String fontType) {
        this.fontType = fontType;
    }
    public int getFontSize() {
        return fontSize;
    }
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    public MementoObj saveStateToMemento(){
        return new MementoObj(content, fontSize, fontType);
    }
    public void restoreState(MementoObj m){
        content = m.getContent();
        fontSize = m.getFontSize();
        fontType = m.getFontType();
    }
    public String toString(){
        return "Content is : " + content + "\n" +" FontType is : " + fontType + "\n" + " FontSize is : " + fontSize;
    }
}
class MementoObj{
    private String content;
    private String fontType;
    private int fontSize;
    public MementoObj(String c, int fs, String ft) {
        content = c;
        fontSize = fs;
        fontType = ft;
    }
    public String getContent() {
        return content;
    }
    public String getFontType() {
        return fontType;
    }
    public int getFontSize() {
        return fontSize;
    }
}
class CaretakerObj{
    List<MementoObj> lm = new ArrayList<MementoObj>();
    public void addMementoObject(MementoObj m){
        lm.add(m);
    }
    public MementoObj getMementoObj(int i){
        return lm.get(i);
    }
}
