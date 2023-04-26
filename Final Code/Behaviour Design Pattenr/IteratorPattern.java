import java.util.ArrayList;
import java.util.List;
// Channel class for Channel Details
class MyChannel {
    private double operationFreq;
    private String language;
    public MyChannel(double operationFreq, String language) {
        this.operationFreq = operationFreq;
        this.language = language;
    }
    public double getOperationFreq() {
        return operationFreq;
    }
    @Override
    public String toString() {
        return "operationFreq=" + operationFreq +
                ", language=" + language;
    }
}
// interface - IterableCollection
interface ChannelCollection {
    ChannelIterator createChannelIterator();
}
// interface - Iterator
interface ChannelIterator {
    public boolean hasNext();
    public Object next();
}
// Concrete Channel Collection
class ChannelCollectionImpl implements ChannelCollection {
    List<MyChannel> channelList;
    int position = 0;
    public ChannelCollectionImpl(List<MyChannel> channelList) {
        this.channelList = channelList;
    }
//Channel Iterator Implementation - to iterate over our channels
    @Override
    public ChannelIterator createChannelIterator(){
        return new ChannelIterator() {
        @Override
            public boolean hasNext() {
                while(position < channelList.size()) {
                    MyChannel c = channelList.get(position);
                    if(c.getOperationFreq() != 0 ) {
                        return true;
                    }else {
                        position++;
                    }
                }
                return false;
            }
            @Override
            public Object next() {
                MyChannel c = channelList.get(position);
                position++;
                return c;
            }
        };
    }
}
public class IteratorPattern {
    public static void main(String[] args) {
        // Filling our list with the required channels
        List<MyChannel> ls = new ArrayList<>();
        ls.add(new MyChannel(91.1, "Hindi"));
        ls.add(new MyChannel(92.5, "Marathi"));
        ls.add(new MyChannel(93.5, "English"));
        ls.add(new MyChannel(94.3, "Tamil"));
        ls.add(new MyChannel(96.0, "Gujarati"));
        // Channel Collection class
        ChannelCollectionImpl channelCollection = new ChannelCollectionImpl(ls);
        // Creating Iterator object to iterate over our channels
        ChannelIterator ourIterator = channelCollection.createChannelIterator();
        // Iterating channels
        while (ourIterator.hasNext()) {
            MyChannel c = (MyChannel) ourIterator.next();
            System.out.println(c);
        }
    }
}
