package net.minecraft.src;

import java.util.Random;

public class BlockSand extends Block {
	private ModConfig config = new ModConfig("FarLandFixConfig.txt", "# Far Land Fixes\n# Fix jitter at far coordinates\nFixFarJitter=1\n# Fix sand/gravel behaving strangely at far coordinates\nFixFarGravityBlocks=1\n");
	public static boolean fallInstantly = false;

	public BlockSand(int var1, int var2) {
		super(var1, var2, Material.sand);
	}

	public void onBlockAdded(World var1, int var2, int var3, int var4) {
		var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
	}

	public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
		var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
	}

	public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
		this.tryToFall(var1, var2, var3, var4);
	}

	private void tryToFall(World var1, int var2, int var3, int var4) {
		if(canFallBelow(var1, var2, var3 - 1, var4) && var3 >= 0) {
			byte var5 = 32;
			if(!fallInstantly && var1.checkChunksExist(var2 - var5, var3 - var5, var4 - var5, var2 + var5, var3 + var5, var4 + var5)) {
				EntityFallingSand var6 = new EntityFallingSand(var1, (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), this.blockID);
				if(this.config.getProperty("FixFarGravityBlocks").equals("1")) {
					var6 = new EntityFallingSand(var1, (double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, this.blockID);
				}

				var1.entityJoinedWorld(var6);
			} else {
				var1.setBlockWithNotify(var2, var3, var4, 0);

				while(canFallBelow(var1, var2, var3 - 1, var4) && var3 > 0) {
					--var3;
				}

				if(var3 > 0) {
					var1.setBlockWithNotify(var2, var3, var4, this.blockID);
				}
			}
		}

	}

	public int tickRate() {
		return 3;
	}

	public static boolean canFallBelow(World var0, int var1, int var2, int var3) {
		int var4 = var0.getBlockId(var1, var2, var3);
		if(var4 == 0) {
			return true;
		} else if(var4 == Block.fire.blockID) {
			return true;
		} else {
			Material var5 = Block.blocksList[var4].blockMaterial;
			return var5 == Material.water ? true : var5 == Material.lava;
		}
	}
}
