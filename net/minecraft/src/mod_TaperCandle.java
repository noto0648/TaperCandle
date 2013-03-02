package net.minecraft.src;

import net.minecraft.src.candle.BlockTaperCandle;
import net.minecraft.src.candle.ModelTaperCandle;
import net.minecraft.src.candle.TileEntityTaperCandle;
import net.minecraft.src.candle.TileEntityTaperCandleRender;

import org.lwjgl.opengl.GL11;

public class mod_TaperCandle extends BaseMod
{
	public static Block taperCandle;
	public ModelTaperCandle model = new ModelTaperCandle();
	@MLProp
	public static int TaperCandleID = 249;
	public static int renderType;

	public String getVersion()
	{
		return "1.4.7";
	}

	public void load()
	{
		renderType = ModLoader.getUniqueBlockModelID(this, true);
		
		taperCandle = new BlockTaperCandle(TaperCandleID, Material.cloth).setBlockName("NotoMod.taperCandle").setCreativeTab(CreativeTabs.tabDecorations);
		ModLoader.registerBlock(taperCandle);
		ModLoader.registerTileEntity(TileEntityTaperCandle.class, "candle.tile", new TileEntityTaperCandleRender());
		ModLoader.addName(taperCandle, "Taper Candle");
		ModLoader.addRecipe(new ItemStack(taperCandle, 1), new Object[]{"XXX", "CCC", " C ", Character.valueOf('X'), Block.torchWood, Character.valueOf('C'), Block.stone});
	}

	public void renderInvBlock(RenderBlocks var1, Block var2, int var3, int var4)
	{
		if(var4 != renderType)
		{
			return;
		}
		else
		{
			Tessellator var8 = Tessellator.instance;
			RenderEngine re = ModLoader.getMinecraftInstance().renderEngine;

			GL11.glPushMatrix();
			GL11.glTranslatef(0.5f, 1.9f, 0.5f);
			GL11.glRotatef(180, 0f, 0f, 1f);
			if(var2 instanceof BlockTaperCandle)
			{
				re.bindTexture(re.getTexture("/noto/Candle.png"));
				model.modelRender(0.09F);
			}

			GL11.glPopMatrix();
		}
	}

}
