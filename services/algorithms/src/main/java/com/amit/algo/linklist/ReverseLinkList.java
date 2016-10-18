package com.amit.algo.linklist;

/**
 * Created by amit on 17/10/16.
 */
public class ReverseLinkList {


    public Node reverseLinklIst(Node node){

        Node current = node;
        Node previous = null;
        Node next = null;

        while(current!=null){

            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        node = previous;
        return node;

    }


    public Node reverseInGroup(Node node,int k){
        Node current = node;
        Node next = null;
        Node prev = null;
        int count = 0;
        while(count<k && current!=null){
            next = current.getNext();
            current.setNext(prev);
            prev =current;
            current = next;
            count++;
        }

        if(next!=null)
            node.setNext(reverseInGroup(next,k));

        return prev;
    }

    public Node rotate(Node head,int k ){

        Node temp = head;
        Node newHead = null;
        int count = 0;
        while(temp.getNext()!=null){

            temp = temp.getNext();
            count++;
            if(count==k-1){
                newHead = temp;
            }
        }
        Node root = newHead.getNext();
        newHead.setNext(null);
        temp.setNext(head);
        return root;
    }
}
