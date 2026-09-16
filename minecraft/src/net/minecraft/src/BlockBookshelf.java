package net.minecraft.src;

import java.util.Random;

public class BlockBookshelf extends Block {
	public BlockBookshelf(int var1, int var2) {
		super(var1, var2, Material.wood);
	}

	public int getBlockTextureFromSide(int var1) {
		return var1 <= 1 ? 4 : this.blockIndexInTexture;
	}

	//BookshelfDropFix ModStart
	public int idDropped(int var1, Random var2) {
		return Item.book.shiftedIndex;
	}

	public int quantityDropped(Random var1) {
		return 3;
	}
	//BookshelfDropFix ModEnd
}
