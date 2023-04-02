import java.util.ArrayList;

public class KellerAutomat {
    private ArrayList<String> stack = new ArrayList<String>();

    public KellerAutomat(){
        stack.add("$");
    }

    private void push(int value) {
        stack.add(Integer.toString(value));
    }

    private int pop() {
        int lastElement = stack.size() - 1;
        int value = 0;

        if (stack.get(lastElement) == "$") System.out.println("Error: Stack is empty");
        else value = Integer.parseInt(stack.get(lastElement));

        stack.remove(lastElement);

        return value;
    }

    public void berechnungsSchritt(Character symbol, boolean modus) {
        if (symbol == '*') {
            int a = pop();
            int b = pop();
            push(a * b);
        } else if (symbol == '+') {
            int a = pop();
            int b = pop();
            push(a + b);
        } else if (symbol >= '0' && symbol <= '9') {
            push(Integer.parseInt(symbol.toString()));
        }
        else System.out.println("Error: Symbol is not valid");

        if (modus) {
            System.out.println("Stack: " + stack);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String gibResultat() {
        return stack.get(1);
    }
}
