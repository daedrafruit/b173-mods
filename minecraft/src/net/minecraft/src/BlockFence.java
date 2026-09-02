package net.minecraft.src;

public class BlockFence extends Block {
	public BlockFence(int var1, int var2) {
		super(var1, var2, Material.wood);
	}

  //FenceFix ModStart
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
			float boxMinusX = 6.0F / 16.0F;
			float boxPlusX = 10.0F / 16.0F;
			float boxMinusZ = 6.0F / 16.0F;
			float boxPlusZ = 10.0F / 16.0F;
			if(isFenceMinusZ) {
				boxMinusZ = 0.0F;
			}

			if(isFencePlusZ) {
				boxPlusZ = 1.0F;
			}

			if(isFenceMinusX) {
				boxMinusX = 0.0F;
			}

			if(isFencePlusX) {
				boxPlusX = 1.0F;
			}

			return AxisAlignedBB.getBoundingBoxFromPool((double)((float)x + boxMinusX), (double)y, (double)((float)z + boxMinusZ), (double)((float)x + boxPlusX), (double)((float)y + 1.5F), (double)((float)z + boxPlusZ));
		}
	}

	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		if(this.config.getProperty("FixFenceCollision").equals("1")) {
			boolean isFenceMinusZ = this.isFenceAt(block, x, y, z - 1);
			boolean isFencePlusZ = this.isFenceAt(block, x, y, z + 1);
			boolean isFenceMinusX = this.isFenceAt(block, x - 1, y, z);
			boolean isFencePlusX = this.isFenceAt(block, x + 1, y, z);
			float boxMinusX = 6.0F / 16.0F;
			float boxPlusX = 10.0F / 16.0F;
			float boxMinusZ = 6.0F / 16.0F;
			float boxPlusZ = 10.0F / 16.0F;
			if(isFenceMinusZ) {
				boxMinusZ = 0.0F;
			}

			if(isFencePlusZ) {
				boxPlusZ = 1.0F;
			}

			if(isFenceMinusX) {
				boxMinusX = 0.0F;
			}

			if(isFencePlusX) {
				boxPlusX = 1.0F;
			}

			this.setBlockBounds(boxMinusX, 0.0F, boxMinusZ, boxPlusX, 1.0F, boxPlusZ);
		}

	}

	public boolean isFenceAt(IBlockAccess block, int x, int y, int z) {
		int blockID = block.getBlockId(x, y, z);
		return blockID == this.blockID || blockID == 107;
	}
  //FenceFix ModEnd

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 11;
	}
}
