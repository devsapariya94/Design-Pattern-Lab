interface GUIFactory{
    void createButton();
    void createCheckbox();
}

interface Button{
    void paint();
}

interface Checkbox{
    void paint();
}

class WinButton implements Button{
    public void paint(){
        System.out.println("WinButton");
    }
}

class WinCheckbox implements Checkbox{
    public void paint(){
        System.out.println("WinCheckbox");
    }
}


class MacButton implements Button{
    public void paint(){
        System.out.println("MacButton");
    }
}


class MacCheckbox implements Checkbox{
    public void paint(){
        System.out.println("MacCheckbox");
    }
}


class WinFactory implements GUIFactory{
    public void createButton(){
        new WinButton().paint();
    }
    public void createCheckbox(){
        new WinCheckbox().paint();
    }
}

class MacFactory implements GUIFactory{
    public void createButton(){
        new MacButton().paint();
    }
    public void createCheckbox(){
        new MacCheckbox().paint();
    }
}

class GUIFactoryProducer{
    public static GUIFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Win")){
            return new WinFactory();
        }
        else if(choice.equalsIgnoreCase("Mac")){
            return new MacFactory();
        }
        return null;
    }
}



