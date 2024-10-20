
class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class LinkedList {
    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static int lengthOfLL(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            temp= temp.next;
            count++;
        }
        return count;
    }
    private static int checkOfPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return 1;
            }
            temp= temp.next;
        }
        return 0;
    }
    private  static Node removehead(Node head){
        if (head == null){
            head = head.next;
        }
        Node temp = head;
        head = temp.next;
        return head;

    }
    private static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node removeAny(Node head, int k){
        if (head == null){
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null){
            count++;
            if (count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp=temp.next;
        }
        return head;
    }
    private static Node insertHead(Node head, int val){
        return new Node(val,head);
    }
    private static Node insertTail(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null){
            temp= temp.next;
        }
        Node newnode = new Node(val);
        temp.next =newnode;
        return head;
    }
    private static Node insertPosition(Node head, int el , int k ){
        if (head == null){
            if (k == 1){
                return  new Node(el);
            }else {
                return head;
            }
        }
        if ( k == 1){
            return  new Node(el,head);
        }
        int count = 0;
        Node temp = head;
        while ( temp != null){
            count++;
            if (count == (k-1)){
                Node x = new Node(el,temp.next);
                temp.next = x ;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    private static Node insertBeforeValue(Node head, int el, int val) {
        if (head == null) {
            return null; // Return null if the list is empty
        }
        if (head.data == val) {
            // Insert at the head if the value is found in the first node
            return new Node(el, head);
        }
        Node temp = head;
        Node prev = null;
        // Traverse the list to find the node with the value `val`
        while (temp != null) {
            if (temp.data == val) {
                // Insert the new node before the node with value `val`
                Node newNode = new Node(el, temp);
                if (prev != null) {
                    prev.next = newNode;
                }
                return head; // Return the updated linked list
            }
            prev = temp; // Track the previous node
            temp = temp.next;
        }

        return head; // Return original list if value is not found
    }

    // Print the linked list
    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,9,7,1};
        Node head = convertArr2LL(arr);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
        System.out.println("NumberOfNode -> " + lengthOfLL(head));
        System.out.println(checkOfPresent(head,5));
        head = removehead(head);
        System.out.println("remove head");
        printLL(head);
        head= removeTail(head);
        System.out.println("remove tail");
        printLL(head);
        head=removeAny(head,2);
        System.out.println("remove Any one position");
        printLL(head);
        head= insertHead(head,10);
        System.out.println("insert head");
        printLL(head);
        head= insertTail(head,40);
        System.out.println("insert Tail");
        printLL(head);
        System.out.println("insert position");
        head= insertPosition(head,45,3);
        printLL(head);
        head=insertBeforeValue(head,10,40);
        System.out.println("insert position value");
        printLL(head);

    }

}
