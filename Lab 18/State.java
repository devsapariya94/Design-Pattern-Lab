public class StatePattenTest {
    public static void main(String[] args) {
        State1 s1 = new State1();
        State2 s2 = new State2();
        State3 s3 = new State3();

        Context c = new Context() {
            
        };
    }
}

interface State{
    public void stateHandling();

}

class State1 implements State{

    @Override
    public void stateHandling() {
        System.out.println("Welcome State");
        System.out.println("Initial state - can move to state2");
    }

}

class State2 implements State{

    @Override
    public void stateHandling() {
        System.out.println("state2 - can move to state3");
    }

}

class State3 implements State{

    @Override
    public void stateHandling() {
        System.out.println("state3 - last state of context - can move to initial state");
    }

}

abstract class Context{
    State s;
    public Context(State s){

    }
    public void setState(State s){
        this.s = s;

    }
    public State getState(){
        return s;
    }
    public void performAction(){
        s.stateHandling();
    }
}