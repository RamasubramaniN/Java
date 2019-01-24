package com.subex.ramasubramani;

import java.util.ArrayList;

public class NthLevelNodes
{
	TreeNode root;
	ArrayList<ArrayList<TreeNode>> lstNodes;

	public NthLevelNodes( TreeNode node )
	{
		this.root = node;
		lstNodes = new ArrayList<ArrayList<TreeNode>>();
	}

	public void loadAllNodes()
	{
		ArrayList<TreeNode> lstParent = addSecondLevel();
		addNthLevel( lstParent );
	}

	private void addNthLevel( ArrayList<TreeNode> lstParent )
	{
		while ( isAtleastOneChildExists( lstParent ) )
		{
			ArrayList<TreeNode> lstChild = new ArrayList<TreeNode>();
			lstNodes.add( lstChild );
			for ( TreeNode parent : lstParent )
			{
				if ( parent.getChild() != null && parent.getChild().length > 0 )
				{
					addToList( lstChild, parent.getChild() );
				}
			}
			lstParent = lstChild;
		}
	}

	private boolean isAtleastOneChildExists( ArrayList<TreeNode> lstParent )
	{
		boolean isAtleastOneChildExists = false;
		if ( lstParent != null && lstParent.size() > 0 && lstParent.get( 0 ) != null )
		{
			for ( TreeNode parentNode : lstParent )
			{
				if ( parentNode.getChild() != null && parentNode.getChild().length > 0 )
				{
					isAtleastOneChildExists = true;
					break;
				}
			}
		}
		return isAtleastOneChildExists;
	}

	private ArrayList<TreeNode> addSecondLevel()
	{
		TreeNode currentNode = root;
		ArrayList<TreeNode> nodes = null;
		if ( currentNode.getChild() != null && currentNode.getChild().length > 0 )
		{
			nodes = new ArrayList<TreeNode>();
			addToList( nodes, currentNode.getChild() );
			lstNodes.add( nodes );
		}
		return nodes;
	}

	private void addToList( ArrayList<TreeNode> nodes, TreeNode[] treeNodes )
	{
		for ( TreeNode node : treeNodes )
			nodes.add( node );
	}

	public void printNthLevel( int level )
	{
		if ( level == 0 )
			System.out.println( root.getX() );
		else
		{
			if ( level <= lstNodes.size() )
			{
				ArrayList<TreeNode> nthLevelNodes = lstNodes.get( level - 1 );
				for ( TreeNode node : nthLevelNodes )
					System.out.println( node.getX() );
			}
		}
	}
}
