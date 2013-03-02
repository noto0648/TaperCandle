package net.minecraft.src.candle;

import java.util.Random;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.mod_TaperCandle;

public class BlockTaperCandle extends BlockContainer
{
	public BlockTaperCandle(int par1, Material par2Material)
	{
		super(par1, par2Material);
		setLightValue(0.9375F);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if((var6 == 3)||(var6 == 1))
		{
			par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 10);
		}
		else
		{
			par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, 0);
		}
		
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if(par1World.getBlockMetadata(par2, par3, par4) % 2 == 0)
		{
			int metadata = par1World.getBlockMetadata(par2, par3, par4) + 1;
			par1World.setBlockAndMetadata(par2, par3, par4, this.blockID, metadata);
		}
		else if(par1World.getBlockMetadata(par2, par3, par4) % 2 == 1)
		{
			par1World.setBlockAndMetadataWithNotify(par2, par3, par4, this.blockID, par1World.getBlockMetadata(par2, par3, par4) - 1);
		}
		return true;

	}
	
	public int getLightValue(IBlockAccess world, int par2, int par3, int par4) 
	{
		return (world.getBlockMetadata(par2, par3, par4) & 2) == 0 ? 14 : 0;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public int getRenderType()
	{
		return mod_TaperCandle.renderType;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		double var7 = (double)((float)par2 + 0.75F);
		double var9 = (double)((float)par3 + 0.7F);
		double var11 = (double)((float)par4 + 0.5F);
		double var13 = 0.2199999988079071D;
		double var15 = 0.27000001072883606D;

		if((par1World.getBlockMetadata(par2, par3, par4) == 0)||(par1World.getBlockMetadata(par2, par3, par4) == 10))
		{
			par1World.spawnParticle("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
			if(par1World.getBlockMetadata(par2, par3, par4) >= 10)
			{
				par1World.spawnParticle("flame", var7 - var15, var9 + var13, (float)par4 + 0.75F, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", var7 - var15, var9 + var13, (float)par4 + 0.25F, 0.0D, 0.0D, 0.0D);
			}
			else
			{
				par1World.spawnParticle("flame", ((float)par2 + 1.0F) - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", ((float)par2 + 0.5F) - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
			}
		}

	}

	public TileEntity createNewTileEntity(World var1)
	{
		return new TileEntityTaperCandle();
	}

}
