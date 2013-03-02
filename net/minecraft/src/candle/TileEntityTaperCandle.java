package net.minecraft.src.candle;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class TileEntityTaperCandle extends TileEntity
{
	
	public Block getBlock()
	{
		return Block.blocksList[this.worldObj.getBlockId(xCoord, yCoord, zCoord)];
	}
	
	public int getBlockMetadata()
	{
		return this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
	}

}
