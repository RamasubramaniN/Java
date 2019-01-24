package com.subex.ramasubramani;

import java.util.concurrent.LinkedBlockingQueue;

public class MainClass
{
	private LinkedBlockingQueue<TreeNode> myQueue;

	MainClass( LinkedBlockingQueue<TreeNode> myQueue )
	{
		this.myQueue = myQueue;
	}

	public static void main( String[] args ) throws InterruptedException
	{
		MainClass mainClass = new MainClass( new LinkedBlockingQueue<TreeNode>() );
		TreeNode root = mainClass.putObjectsIntoQueue();
		System.out.println( "Breadth First Traversal" );
		mainClass.breadthFirstTraverse( root );
		NthLevelNodes nthLevelNodes = new NthLevelNodes( root );
		nthLevelNodes.loadAllNodes();
		for ( int i = 0; i < 6; i++ )
		{
			System.out.println( "Printing nodes at level : " + i );
			nthLevelNodes.printNthLevel( i );
		}
	}

	private void breadthFirstTraverse( TreeNode root ) throws InterruptedException
	{
		TreeNode node = root;
		myQueue.put( node );
		while ( myQueue.size() != 0 )
		{
			node = myQueue.take();
			System.out.println( node.getX() );
			if ( node.getChild() != null )
			{
				for ( TreeNode nd : node.getChild() )
				{
					myQueue.put( nd );
				}
			}
		}
	}

	private TreeNode putObjectsIntoQueue()
	{
		//LEVEL 0
		TreeNode node = new TreeNode();
		node.setX( 0 );
		//LEVEL 1
		TreeNode node1 = new TreeNode();
		node1.setX( 1 );
		TreeNode node2 = new TreeNode();
		node2.setX( 2 );
		node.setChild( new TreeNode[]
		{ node1, node2 } );
		//LEVEL 2
		TreeNode node3 = new TreeNode();
		node3.setX( 3 );
		TreeNode node4 = new TreeNode();
		node4.setX( 4 );
		node1.setChild( new TreeNode[]
		{ node3, node4 } );
		TreeNode node5 = new TreeNode();
		node5.setX( 5 );
		TreeNode node6 = new TreeNode();
		node6.setX( 6 );
		node2.setChild( new TreeNode[]
		{ node5, node6 } );
		//LEVEL 3
		TreeNode node7 = new TreeNode();
		node7.setX( 7 );
		TreeNode node8 = new TreeNode();
		node8.setX( 8 );
		TreeNode node9 = new TreeNode();
		node9.setX( 9 );
		TreeNode node10 = new TreeNode();
		node10.setX( 10 );
		TreeNode node11 = new TreeNode();
		node11.setX( 11 );
		TreeNode node12 = new TreeNode();
		node12.setX( 12 );
		TreeNode node13 = new TreeNode();
		node13.setX( 13 );
		TreeNode node14 = new TreeNode();
		node14.setX( 14 );
		node3.setChild( new TreeNode[]
		{ node7, node8 } );
		node4.setChild( new TreeNode[]
		{ node9, node10 } );
		node5.setChild( new TreeNode[]
		{ node11, node12 } );
		node6.setChild( new TreeNode[]
		{ node13, node14 } );
		//LEVEL 4
		TreeNode node15 = new TreeNode();
		node15.setX( 15 );
		TreeNode node16 = new TreeNode();
		node16.setX( 16 );
		node13.setChild( new TreeNode[]
		{ node15 } );
		node14.setChild( new TreeNode[]
		{ node16 } );
		//LEVEL 5
		TreeNode node17 = new TreeNode();
		node17.setX( 17 );
		TreeNode node18 = new TreeNode();
		node18.setX( 18 );
		node15.setChild( new TreeNode[]
		{ node17 } );
		node16.setChild( new TreeNode[]
		{ node18 } );

		return node;
	}

	private static void test()
	{

	}
}
