//GoldSilkTouch ModStart
package net.minecraft.src;

public class ItemTallGrass extends ItemBlock {
	public ItemTallGrass(int var1) {
		super(var1);
		this.setHasSubtypes(true);
	}

	public int getPlacedBlockMetadata(int var1) {
		return var1;
	}

	public int getIconFromDamage(int var1) {
		return Block.tallGrass.getBlockTextureFromSideAndMetadata(0, var1);
	}

	public int getColorFromDamage(int var1) {
		return ColorizerGrass.getGrassColor(0.5D, 1.0D);
	}

	public String getItemNameIS(ItemStack var1) {
		return var1.getItemDamage() == 2 ? super.getItemName() + ".fern" : super.getItemName() + ".grass";
	}
}
//GoldSilkTouch ModEnd
