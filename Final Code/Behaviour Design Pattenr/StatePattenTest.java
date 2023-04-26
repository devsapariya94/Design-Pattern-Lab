    interface State {
        public void stateHandling();
    }
    class State1 implements State {
        @Override
        public void stateHandling() {
            System.out.println("Welcome State!");
            System.out.println("Initial state1 - can move to state2");
        }
    }
    class State2 implements State {
        @Override
        public void stateHandling() {
            System.out.println("Welcome to State2!");
            System.out.println("State2 - can move to state3");
        }
    }
    class State3 implements State {
        @Override
        public void stateHandling() {
            System.out.println("Welcome to State3!");
            System.out.println("State3 - last state of the context - can move to initial state1!");
        }
    }
    class Context {
        State s;
        public Context(State s) {
            this.s = s;
        }
        public void setState(State s) {
            this.s = s;
        }
        public State getState() {
            return s;
        }
        public void performAction() {
            s.stateHandling();
        }
    }
    public class StatePattenTest {
        public static void main(String[] args) {
            State1 s1 = new State1();
            State2 s2 = new State2();
            State3 s3 = new State3();

            Context c1 = new Context(s1);
            Context c2 = new Context(s2);
            Context c3 = new Context(s3);

            c1.performAction();
            c2.performAction();
            c3.performAction();
        }
    }
