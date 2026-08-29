package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
	private static Block[] blocksEffectiveAgainst = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.stairCompactCobblestone, Block.doorSteel, Block.brick, Block.stoneOvenIdle, Block.stoneOvenActive, Block.dispenser, Block.pressurePlateStone, Block.rail, Block.railPowered, Block.railDetector, Block.button};

	protected ItemPickaxe(int var1, EnumToolMaterial var2) {
		super(var1, 2, var2, blocksEffectiveAgainst);
	}

	public boolean canHarvestBlock(Block var1) {
		int var2 = this.toolMaterial == EnumToolMaterial.GOLD && Block.config.getProperty("GoldSilkTouch").equals("1") ? 2 : this.toolMaterial.getHarvestLevel();
		return var1 == Block.obsidian ? var2 == 3 : (var1 != Block.blockDiamond && var1 != Block.oreDiamond ? (var1 != Block.blockGold && var1 != Block.oreGold ? (var1 != Block.blockSteel && var1 != Block.oreIron ? (var1 != Block.blockLapis && var1 != Block.oreLapis ? (var1 != Block.oreRedstone && var1 != Block.oreRedstoneGlowing ? (var1.blockMaterial == Material.rock ? true : var1.blockMaterial == Material.iron) : var2 >= 2) : var2 >= 1) : var2 >= 1) : var2 >= 2) : var2 >= 2);
	}
}
