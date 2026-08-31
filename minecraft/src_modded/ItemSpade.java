package net.minecraft.src;

public class ItemSpade extends ItemTool {
	private static Block[] blocksEffectiveAgainst = new Block[]{Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField};

	public ItemSpade(int var1, EnumToolMaterial var2) {
		super(var1, 1, var2, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block var1) {
		return var1 == Block.snow ? true : var1 == Block.blockSnow;
	}

	//ToolFix ModStart
	private static Block[] toolFixBlocks = new Block[]{Block.slowSand};

	public float getStrVsBlock(ItemStack var1, Block block) {
		if(Block.config.getProperty("ToolFix").equals("1")) {
			for(int i = 0; i < toolFixBlocks.length; ++i) {
				if(toolFixBlocks[i] == block) {
					return this.toolMaterial.getEfficiencyOnProperMaterial();
				}
			}
		}

		return super.getStrVsBlock(var1, block);
	}
	//ToolFix ModEnd
}
