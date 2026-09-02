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
		return this.config.getProperty("FixBookshelvesDropNothing").equals("1") ? Item.book.shiftedIndex : Block.bookShelf.blockID;
	}

	public int quantityDropped(Random var1) {
		return this.config.getProperty("FixBookshelvesDropNothing").equals("1") ? 3 : (this.config.getProperty("FixBookshelvesDropNothing").equals("2") ? 1 : 0);
	}
	//BookshelfDropFix ModEnd
}
