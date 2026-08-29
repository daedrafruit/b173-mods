package net.minecraft.src;

public class BlockFence extends Block {
	public BlockFence(int var1, int var2) {
		super(var1, var2, Material.wood);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return this.config.getProperty("PlaceFloatingFence").equals("0") ? (world.getBlockId(x, y - 1, z) == this.blockID ? true : (!world.getBlockMaterial(x, y - 1, z).isSolid() ? false : super.canPlaceBlockAt(world, x, y, z))) : super.canPlaceBlockAt(world, x, y, z);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		if(this.config.getProperty("FixFenceCollision").equals("0")) {
			return AxisAlignedBB.getBoundingBoxFromPool((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)y + 1.5F), (double)(z + 1));
		} else {
			boolean isFenceMinusZ = this.isFenceAt(world, x, y, z - 1);
			boolean isFencePlusZ = this.isFenceAt(world, x, y, z + 1);
			boolean isFenceMinusX = this.isFenceAt(world, x - 1, y, z);
			boolean isFencePlusX = this.isFenceAt(world, x + 1, y, z);
			float var9 = 6.0F / 16.0F;
			float var10 = 10.0F / 16.0F;
			float var11 = 6.0F / 16.0F;
			float var12 = 10.0F / 16.0F;
			if(isFenceMinusZ) {
				var11 = 0.0F;
			}

			if(isFencePlusZ) {
				var12 = 1.0F;
			}

			if(isFenceMinusX) {
				var9 = 0.0F;
			}

			if(isFencePlusX) {
				var10 = 1.0F;
			}

			return AxisAlignedBB.getBoundingBoxFromPool((double)((float)x + var9), (double)y, (double)((float)z + var11), (double)((float)x + var10), (double)((float)y + 1.5F), (double)((float)z + var12));
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 11;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		if(this.config.getProperty("FixFenceCollision").equals("1")) {
			boolean isFenceMinusZ = this.isFenceAt(block, x, y, z - 1);
			boolean isFencePlusZ = this.isFenceAt(block, x, y, z + 1);
			boolean isFenceMinusX = this.isFenceAt(block, x - 1, y, z);
			boolean isFencePlusX = this.isFenceAt(block, x + 1, y, z);
			float var9 = 6.0F / 16.0F;
			float var10 = 10.0F / 16.0F;
			float var11 = 6.0F / 16.0F;
			float var12 = 10.0F / 16.0F;
			if(isFenceMinusZ) {
				var11 = 0.0F;
			}

			if(isFencePlusZ) {
				var12 = 1.0F;
			}

			if(isFenceMinusX) {
				var9 = 0.0F;
			}

			if(isFencePlusX) {
				var10 = 1.0F;
			}

			this.setBlockBounds(var9, 0.0F, var11, var10, 1.0F, var12);
		}

	}

	public boolean isFenceAt(IBlockAccess var1, int var2, int var3, int var4) {
		int var5 = var1.getBlockId(var2, var3, var4);
		return var5 == this.blockID || var5 == 107;
	}
}
