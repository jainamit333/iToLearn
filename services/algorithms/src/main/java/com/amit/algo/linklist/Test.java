package com.amit.algo.linklist;

/**
 * Created by amit on 17/10/16.
 */
public class Test {


    public static void main(String[] args) {

        Test test = new Test();
        ReverseLinkList reverseLinklIst = new ReverseLinkList();

        Node root = test.createLinkList(10);
        test.printLinkList(root);
        root = reverseLinklIst.rotate(root,3);
        System.out.println("---------------Level-------------");
        System.out.println();
        test.printLinkList(root);

    }


    public Node createLinkList(int size){

        Node root = new Node();
        root.setValue(0);
        Node current = root;
        for (int i = 1; i < size; i++) {

            Node newNode = new Node();
            newNode.setValue(i);
            current.setNext(newNode);
            newNode.setNext(null);
            current = newNode;
        }
        return root;
    }

    public void printLinkList(Node root){
        Node current = root;
        while (current!=null){
            System.out.print(current.getValue()+" -> ");
            current = current.getNext();
        }
    }

}
