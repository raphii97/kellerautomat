import java.util.ArrayList;

public class KellerAutomat {
    private ArrayList<String> stack = new ArrayList<String>();

    public KellerAutomat(){
        stack.add("$");
    }

    private void push(int value) {
        stack.add(value + "");
    }

    private int pop() {
        int lastElement = stack.size() - 1;
        int value = 0;

        if (stack.get(lastElement) == "$") System.out.println("Error");
        else value = Integer.parseInt(stack.get(lastElement));

        stack.remove(lastElement);

        return value;
    }

    public void berechnungsSchritt(Character read, boolean modus) {
        if (read == '*') {
            int a = pop();
            int b = pop();
            push(a * b);
        } else if (read == '+') {
            int a = pop();
            int b = pop();
            push(a + b);
        } else if (read >= '0' && read <= '9') {
            push(Integer.parseInt(read.toString()));
        }
        else System.out.println("Error");

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
