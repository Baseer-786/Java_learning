package LinkedList;

import java.util.Stack;

class node {
    static node tail;
    node prev;
    int data;
    node next;
    node back;

    node(int data1, node next1, node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
    node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
    public node(int val, node head) {
    }


    public node() {

    }
}

public class DLL_takeUforward {
private static  void  print (node head){
    while (head != null){
        System.out.print(head.data + " -> ");
        head = head.next;
    }
    System.out.println("Null");
    }
    private  static node convertArr2DLL(int [] arr){
    node head = new node(arr[0]);
    node prev = head;
        for (int i = 1; i < arr.length; i++) {
            node temp = new node(arr[i],null,prev);
            prev.next = temp;
            prev=temp;

        }
        return head;
    }
    private static node deleteHead(node head){
    if ( head == null || head.next == null){
        return null;
    }
    node prev = head;
    head = head.next;
    head.back = null;
    prev.next = null;
    return  head;
    }
    private static node deleteTail(node head){
    if (head == null || head.next == null){
        return null;
    }
    node tail= head;
    while (tail.next != null){
        tail =tail.next;
    }
    node newtail = tail.back;
    newtail.next = null;
    tail.back = null;
    return head;
    }
    private static node removePositionElement(node head, int k) {
        if (head == null) {
            return null;
        }
        // If k is 1, remove the head
        if (k == 1) {
            return deleteHead(head);
        }
        int count = 1;
        node Knode = head;
        // Traverse to the k-th node
        while (Knode != null && count < k) {
            Knode = Knode.next;
            count++;
        }
        // If the k-th node does not exist
        if (Knode == null) {
            System.out.println("Position " + k + " does not exist.");
            return head;
        }
        node prev = Knode.back;
        node front = Knode.next;
        // If the node to be deleted is the only node
        if (prev == null && front == null) {
            return null; // The list becomes empty
        }
        // If the node to be deleted is the head node
        else if (prev == null) {
            return deleteHead(head);
        }
        // If the node to be deleted is the tail node
        else if (front == null) {
            return deleteTail(head);
        }
        // Normal case: node is in the middle
        prev.next = front;
        front.back = prev;
        Knode.next = null;
        Knode.back = null;
        return head;
    }
    private static  node deleteNode(node temp ){
    node prev = temp.back;
    node front = temp.next;
    if (front == null){
        prev.next = null;
        temp.back = null;
        return null ;
    }
    prev.next= front;
    front.back= prev;

    temp.next = temp.back = null;
    return  temp;
    }
    private static node insertBeforeHead(node head, int val) {
        node newnode = new node(val);  // Create the new node
        newnode.next = head;           // The new node's next should point to the current head
        if (head != null) {
            head.back = newnode;       // If the list is not empty, set the current head's back to newnode
        }
        return newnode;                // Return the new node, which is now the head
    }
    private static node insertBeforeTail(node head, int val) {
           if (head.next == null){
               return insertBeforeHead(head,val);
           }
           node tail = head;
           while (tail.next != null){
               tail = tail.next;
           }
           node prev = tail.back;
           node newNode = new node(val,tail,prev);
           prev.next = newNode;
           tail.back = newNode;
           return head;


    }
    private static node insertBeforeKlement(node head, int k, int val) {
        if (k == 1) {
            return insertBeforeHead(head, val);  // If inserting before the first element, treat it as insertBeforeHead.
        }
        node temp = head;
        int count = 1;  // Start counting from 1, since the head is the 1st element.
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position " + k + " does not exist.");
            return head;
        }
        // Now temp points to the k-th node, and we need to insert before it
        node prev = temp.back;
        node newNode = new node(val, temp, prev);  // Create new node with next as temp and back as prev.
        if (prev != null) {
            prev.next = newNode;  // Connect the previous node to the new node.
        }
        temp.back = newNode;  // Connect the k-th node's back to the new node.
        // If inserting at the head position (k == 1), update the head.
        if (k == 1) {
            return newNode;  // Return newNode as the new head.
        }
        return head;
    }
    private  static  node insertNode(node Node, int val){
    node prev = Node.back;
    node newNode = new node(val,Node,prev);
        if (prev != null) {
            prev.next = newNode; // Update previous node's next to point to new node
        }
    Node.back=newNode;
        return newNode;
    }
    private static node reverse(node head) {
        if (head == null || head.next == null) {
            return head; // Return the head if the list is empty or has one node
        }
        node curr = head;
        node temp = null;
        // Traverse the list and swap next and back for each node
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.back;
            curr.back = temp;
            // Move to the next node (which is now the previous node due to reversal)
            curr = curr.back;
        }
        // After reversing, the temp will point to the last node
        // Now find the new head, which should be the last node
        node newHead = head;
        while (newHead.back != null) {
            newHead = newHead.back;
        }
        return newHead;  // Return the new head of the reversed list
    }
    private static node reverse1(node head){
    if (head == null || head.next == null){
        return  head;
    }
    node prev = null;
    node current = head;
    while (current != null){
        prev = current.prev;
        current.prev = current.next;
        current.next = prev;
        current = current.prev;
    }
        if (prev != null) {
            head = prev;
        }
  return  head;
    }

//    private static node twoNumber(node num1,node num2){
//    node dummyHead = new node(-1);
//    node curr = dummyHead;
//    node temp1 = num1;
//    node temp2 = num2;
//    int carry = 0 ;
//    int(temp1 != null || temp2 != null){
//        int sum = carry;
//        if (temp1) {
//            sum += temp1.data;
//        }
//        if (temp2) {
//                sum += temp2.data;
//        }
//        node newNode = new newNode(sum%10);
//        carry = sum/10;
//        curr.next = newNode;
//        curr = curr.next;
//        if (temp1){
//            temp1.next;
//        }
//        if (temp2){
//            temp2.next;
//        }
//        if (carry){
//            node newNode = new node(carry);
//            curr.next = newNode;
//        }
//        return dummyHead.next;
//        }
//
//    }




    public static void main(String[] args) {
        int[] arr = {45,5,2,7,8,30,12};
        node head = DLL_takeUforward.convertArr2DLL(arr);
       print(head);
       head = deleteHead(head);
        System.out.println("delete head");
       print(head);
       head = deleteTail(head);
        System.out.println("delete Tail");
        print(head);
        head= removePositionElement(head,3);
        System.out.println("Remove position Element");
        print(head);
        node temp = head.next;
        head= deleteNode(temp);
        System.out.println("Delete a Node");
        print(head);
        head =insertBeforeHead(head,500);
        System.out.println("insert before head");
        print(head);
        head = insertBeforeTail(head,10);
        System.out.println("insert before Tail");
        print(head);
        head = insertBeforeKlement(head,2,22);
        System.out.println("insert before K element");
        print(head);
        head= insertNode(head,450);
        System.out.println("insert Node");
        print(head);
        head= reverse(head);
        System.out.println("Reverse Doubly LL");
        print(head);
//        head= reverse1(head);
//        System.out.println("Reverse Doubly LL");
//        print(head);


    }
}
