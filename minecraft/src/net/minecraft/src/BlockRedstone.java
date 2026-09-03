//RedstoneBlock ModStart
package net.minecraft.src;

public class BlockRedstone extends Block {

  protected BlockRedstone(int id, int texture, Material material) {
    super(id, texture, material);
    this.setTickOnLoad(true);
  }

  public int tickRate() {
    return 2;
  }

  public void onBlockAdded(World world, int x, int y, int z) {
    if(world.getBlockMetadata(x, y, z) == 0) {
      super.onBlockAdded(world, x, y, z);
    }

    world.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
  }

  public void onBlockRemoval(World world, int x, int y, int z) {
    world.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
    world.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
  }

  public void onNeighborBlockChange(World world, int x, int y, int z, int side) {
    super.onNeighborBlockChange(world, x, y, z, side);
    world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate());
  }

  public boolean isPoweringTo(IBlockAccess block, int x, int y, int z, int side) {
    return true;
  }

  public boolean canProvidePower() {
    return true;
  }
}
