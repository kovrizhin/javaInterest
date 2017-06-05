package parsing;

import java.util.*;

/**
 * Created by oleg on 8/17/16
 */
public class ShuntingYard {
    HashMap<Character, Integer> switchMap = new HashMap<>();

    public static final int OPERATION = 0;

    public static final int BRACKETS = 1;

    public static final int DIGITS = 2;

    {
        switchMap.put('*', OPERATION);
        switchMap.put('(', BRACKETS);
        switchMap.put(')', BRACKETS);
        switchMap.put('/', OPERATION);
        switchMap.put('^', OPERATION);
        switchMap.put('+', OPERATION);
        switchMap.put('-', OPERATION);
        switchMap.put('1', DIGITS);
        switchMap.put('2', DIGITS);
        switchMap.put('3', DIGITS);
        switchMap.put('4', DIGITS);
        switchMap.put('5', DIGITS);
        switchMap.put('6', DIGITS);
        switchMap.put('7', DIGITS);
        switchMap.put('8', DIGITS);
        switchMap.put('9', DIGITS);
        switchMap.put('0', DIGITS);

        
    }

    HashMap<Character, Integer> priorityOperation = new HashMap<>();
    public static final int PRIORITY_ZERO = 0;

    public static final int PRIORITY_FIRST = 1;

    public static final int PRIORITY_SECOND = 2;

    {
        priorityOperation.put('+', PRIORITY_ZERO);
        priorityOperation.put('-', PRIORITY_ZERO);
        priorityOperation.put('*', PRIORITY_FIRST);
        priorityOperation.put('/', PRIORITY_FIRST);
        priorityOperation.put('^', PRIORITY_SECOND);
    }

    HashMap<Character, Integer> associative = new HashMap<>();

    public static final Integer LEFT = 1;

    public static final int RIGHT = 2;

    {
        associative.put('+', LEFT);
        associative.put('-', LEFT);
        associative.put('*', LEFT);
        associative.put('/', LEFT);
        associative.put('^', RIGHT);
    }
    
    
    LinkedList<Character> queue =new LinkedList<>();
    Stack<Character> operandStack = new Stack<>();
     
    public LinkedList<Character> parse(String input) {
        Objects.requireNonNull(input);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
             switch (switchMap.get(c)){
                 case OPERATION:
                     if(operandStack.size() > 0 && BRACKETS != switchMap.get(operandStack.peek())) {
                         Character operatorStack = operandStack.peek();
                         int priorityStack = priorityOperation.get(operatorStack);
                         int priorityInput = priorityOperation.get(c);
                         boolean isLeftAssociative = Objects.equals(associative.get(c), LEFT);
                         if(priorityStack > priorityInput || isLeftAssociative && priorityStack == priorityInput){
                             queue.add(operandStack.pop());
                         }
                         operandStack.push(c);
                     } else {
                         operandStack.push(c);
                     }
                     break;
                 case DIGITS:
                     queue.add(c);
                     break;
                 case BRACKETS:
                     if(c == '('){
                         operandStack.push(c);
                     } else {
                         Character ch = operandStack.pop();
                         while (ch != '('){
                             queue.add(ch);
                             ch = operandStack.pop();
                         }
                     }

                     break;
                 default:
                     throw new NoSuchElementException();
             }
            
        }
        while (!operandStack.isEmpty()){
            queue.add(operandStack.pop());
        }

        return queue;
        
    }

    public static void main(String[] args) {
        System.out.println(new ShuntingYard().parse("3+4*2/(1-5)^2^3"));
    }
}
