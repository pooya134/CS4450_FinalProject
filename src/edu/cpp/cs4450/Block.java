
/***************************************************************
* file: Block.java
*
* author: Jong Yoon, Youngjun Woo, Brian Rivera
* class: CS 4450 Computer Graphics
*
* assignment: Final Project (Check Point 2)
* date last modified: 3/28/2019
*
* purpose: Block class that stores a blocks ID which determines its type based
* on the enum BlockType, as well as its 3D coordinates in the world, and whether
* it is active or in the world.
****************************************************************/

package edu.cpp.cs4450;

public class Block {

	private boolean IsActive;
	private BlockType Type;
	private float x,y,z;

	public enum BlockType{

		BlockType_Grass(0),
		BlockType_Sand(1),
		BlockType_Water(2),
		BlockType_Dirt(3),
		BlockType_Stone(4),
		BlockType_Bedrock(5),
		BlockType_Default(6);

		private int BlockID;

		BlockType
		(int i) {
		BlockID=i;
		}

		public int GetID(){
		return BlockID;
		}

		public void SetID
		(int i){
		BlockID = i;
		}
	}

	public Block(BlockType type){
		Type= type;
	}

	public void setCoords(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public boolean IsActive() {

		return IsActive;
	}

	public void SetActive(boolean active){
		IsActive=active;
	}

	public int GetID(){

		return Type.GetID();
	}
}

