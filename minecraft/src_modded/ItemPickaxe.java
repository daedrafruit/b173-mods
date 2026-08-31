package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
  //ToolFix ModStart
	private static Block[] blocksEffectiveAgainst = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.stairCompactCobblestone, Block.doorSteel, Block.brick, Block.stoneOvenIdle, Block.stoneOvenActive, Block.dispenser, Block.pressurePlateStone, Block.rail, Block.railPowered, Block.railDetector, Block.button};
  //ToolFix ModStart

	protected ItemPickaxe(int var1, EnumToolMaterial var2) {
		super(var1, 2, var2, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block block) {

  //GoldSilkTouch ModStart
  int harvestLevel = this.toolMaterial == EnumToolMaterial.GOLD && Block.config.getProperty("GoldSilkTouch").equals("1") ? 2 : this.toolMaterial.getHarvestLevel();
  //GoldSilkTouch ModEnd

		return block == Block.obsidian ? harvestLevel == 3 : (block != Block.blockDiamond && block != Block.oreDiamond ? (block != Block.blockGold && block != Block.oreGold ? (block != Block.blockSteel && block != Block.oreIron ? (block != Block.blockLapis && block != Block.oreLapis ? (block != Block.oreRedstone && block != Block.oreRedstoneGlowing ? (block.blockMaterial == Material.rock ? true : block.blockMaterial == Material.iron) : harvestLevel >= 2) : harvestLevel >= 1) : harvestLevel >= 1) : harvestLevel >= 2) : harvestLevel >= 2);
	}
}
