package BASIC;

import java.util.*;
public class info {
    public static void main(String[] args) {

                Stack<String> cards = new Stack<>();

                // Push
                cards.push("Ace of Spades");
                cards.push("King of Hearts");
                cards.push("Queen of Diamonds");
                cards.push("Jack of Clubs");

                System.out.println("Stack: " + cards);

                // Peek
                String topCard = cards.peek();
                System.out.println("Top (peek): " + topCard);

                // Pop
                String removedCard = cards.pop();
                System.out.println("Popped: " + removedCard);
                System.out.println("Stack after pop: " + cards);

                // Search
                int position = cards.search("King of Hearts");
                System.out.println("Position from top: " + position);

                // IsEmpty & Loop
                System.out.println("Is empty? " + cards.isEmpty());

                while (!cards.isEmpty()) {
                    System.out.println("Popped: " + cards.pop());
                }

                System.out.println("Is empty now? " + cards.isEmpty());


    }
}
