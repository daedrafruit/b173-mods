package net.minecraft.src;

import java.util.Random;

public class BlockSand extends Block {
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

	private void tryToFall(World world, int x, int y, int z) {
		if(canFallBelow(world, x, y - 1, z) && y >= 0) {
			byte var5 = 32;
			if(!fallInstantly && world.checkChunksExist(x - var5, y - var5, z - var5, x + var5, y + var5, z + var5)) {
				EntityFallingSand sandEntity = new EntityFallingSand(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.blockID);
        //FarLandsFix ModStart
				if(this.config.getProperty("FixFarGravityBlocks").equals("1")) {
					sandEntity = new EntityFallingSand(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, this.blockID);
				}
        //FarLandsFix ModEnd

				world.entityJoinedWorld(sandEntity);
			} else {
				world.setBlockWithNotify(x, y, z, 0);

				while(canFallBelow(world, x, y - 1, z) && y > 0) {
					--y;
				}

				if(y > 0) {
					world.setBlockWithNotify(x, y, z, this.blockID);
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
