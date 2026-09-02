package net.minecraft.src;

public class ItemAxe extends ItemTool {
	private static Block[] blocksEffectiveAgainst = new Block[]{Block.planks, Block.bookShelf, Block.wood, Block.chest};

	protected ItemAxe(int var1, EnumToolMaterial var2) {
		super(var1, 3, var2, blocksEffectiveAgainst);
	}

	//ToolFix ModStart
	private static Block[] toolFixBlocks = new Block[]{Block.workbench, Block.doorWood, Block.stairCompactPlanks, Block.pressurePlatePlanks, Block.fence, Block.trapdoor, Block.jukebox, Block.pumpkin, Block.pumpkinLantern, Block.signPost, Block.signWall, Block.musicBlock, Block.ladder};

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
