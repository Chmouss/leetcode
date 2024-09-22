import java.math.BigInteger;

public class Pb_2_AddTwoNumbers {

    /**
     *
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     **/

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        //ListNode l1 = new ListNode();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(2, node2);
        // number -> 342

        //ListNode l2 = new ListNode();
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(6, node4);
        ListNode node6 = new ListNode(5, node5);
        // number -> 465
        addTwoNumbers(node3, node6);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder string1 = new StringBuilder("");
        StringBuilder string2 = new StringBuilder("");
        while(l1 != null){
            string1.append(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            string2.append(l2.val);
            l2 = l2.next;
        }
        // Reverse both strings (since linked lists represent numbers in reverse)
        string1.reverse();
        string2.reverse();

        // Parse the strings into integers (handle large numbers by using BigInteger)
        java.math.BigInteger uno = new java.math.BigInteger(string1.toString());
        java.math.BigInteger dos = new java.math.BigInteger(string2.toString());


        // Get the result by adding the two large numbers
        //int result = uno + dos;
        java.math.BigInteger result = uno.add(dos);

        // Convert the result into a string and reverse it to match the list structure
        String strResult = String.valueOf(result);
        char[] charResult = strResult.toCharArray();

        // Create the resulting linked list
        ListNode baseNode = new ListNode(Character.getNumericValue(charResult[0]));
        ListNode currentNode = baseNode;

        // Iterate over the char array starting from the second digit
        for (int i = 1; i < charResult.length; i++) {
            // Convert the char to integer using Character.getNumericValue
            int digit = Character.getNumericValue(charResult[i]);

            // Create a new node with the digit and add it to the linked list
            ListNode newNode = new ListNode(digit, currentNode);

            // Move the pointer to the new node
            currentNode = newNode;
        }

        // Return the head of the constructed linked list
        return currentNode;
    }

}
