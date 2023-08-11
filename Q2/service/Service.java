package com.learning.Q2.service;

import com.learning.Q2.model.Node;

public class Service {
	static Node newRoot=null,temp =null;;
     public Node createSkewedTree(Node root) {
	        if(root == null)
	    		return null;
	    	/*while(node.left!=null) {
	    		node=node.left;
	    	}*/
	    	
	    	createSkewedTree(root.left);
	    	Node leftNode= root.left;
	    	Node rightNode= root.right;
	    	if(newRoot==null) {
	    		newRoot=root;
	    		root.left=null;
	    		temp =root;
	    		
	    	}else {
	    		temp.right= root;
	    		root.left=null;
	    		temp=root;
	    		
	    	}
	    	
	    	createSkewedTree(rightNode);
	    	return newRoot;
    }
    public void preOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.right);       
    }
}
