package net.minecraft.src.candle;

import net.minecraft.src.Block;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;

public class TileEntityTaperCandleRender extends TileEntitySpecialRenderer
{
	private ModelTaperCandle model = new ModelTaperCandle();
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double par2, double par3, double par4, float f)
	{
		TileEntityTaperCandle tile = (TileEntityTaperCandle)var1;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)par2 + 0.5f, (float)par3 + 1.5f, (float)par4 + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		if(tile.getBlockMetadata() >= 10)
		{
			GL11.glRotatef(90, 0f, 1f, 0f);
		}
		
		this.bindTextureByName("/noto/Candle.png");
		GL11.glPushMatrix();
		this.model.modelRender(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
