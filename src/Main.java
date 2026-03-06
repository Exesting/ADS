import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        Stack stack = new Stack();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].charAt(0) != '+' && inputArray[i].charAt(0) != '-' && inputArray[i].charAt(0) != '*') {
                stack.add(new StackNode(getNumber(inputArray[i])));
            } else {
                if (stack.getSize() < 2) {
                    throw new IllegalArgumentException("Error");
                } else {
                    int a = stack.getRoot().getValue();
                    int b = stack.getRoot().getPrevious().getValue();
                    if (inputArray[i].charAt(0) == '+') {
                        stack.remove();
                        stack.remove();
                        stack.add(new StackNode(a + b, stack.getRoot()));
                    } else if (inputArray[i].charAt(0) == '-') {
                        stack.remove();
                        stack.remove();
                        stack.add(new StackNode(a - b, stack.getRoot()));
                    } else if (inputArray[i].charAt(0) == '*') {
                        stack.remove();
                        stack.remove();
                        stack.add(new StackNode(a * b, stack.getRoot()));
                    }
                }
            }
        }
        System.out.println(stack.getRoot().getValue());
    }

    public static int getNumber(String input) {
        return Integer.parseInt(input);
    }
}