package task_16;

public class NodePractice {

    public static void main(String[] args) {
        Node nodeP = new Node(1);
        Node nodeQ = new Node();
        Node nodeR = new Node(3);
        nodeQ = nodeP;
        System.out.println(nodeQ.data);
    }

    private static int countNodes(Node head) {
        int count = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            count++;
        }

        /**
         *  Can use this while, but the count must be equal to 0.
         *  while (head != null){
         *      head = head.next;
         *      count++;
         *  }
         */

        return count;
    }
}
