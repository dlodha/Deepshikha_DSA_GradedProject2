package com.learning.Q2.main;

import com.learning.Q2.model.Node;
import com.learning.Q2.service.Service;

public class Driver {
    Node node;
    static Node newRoot=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver tree= new Driver();
        tree.node =new Node(50);
        tree.node.left= new Node(30);
        tree.node.right= new Node(60);
        tree.node.left.left= new Node(10);
        tree.node.right.left= new Node(55);
        Service service=new Service();
        Node newRoot= service.createSkewedTree(tree.node);
        service.preOrder(newRoot);
      
	}
    
}
