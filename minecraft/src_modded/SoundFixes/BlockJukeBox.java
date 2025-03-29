package net.minecraft.src;

public class BlockJukeBox extends BlockContainer {
	private static ModConfig config = new ModConfig("SoundConfig.txt", "# Fix bed sounds\n# 0 = Stone (vanilla)\n# 1 = Wood (modern vanilla)\n# 2 = Cloth\nBedSound=2\n\n# Fix jukebox and noteblock sounds\n# 0 = Stone (vanilla)\n# 1 = Wood\nJukeboxSound=1\nNoteblockSound=1\n\n");

	protected BlockJukeBox(int var1, int var2) {
		super(var1, var2, Material.wood);
	}

	public int getBlockTextureFromSide(int var1) {
		if(config.getProperty("NoteblockSound").equals("1")) {
			this.setStepSound(soundWoodFootstep);
		}

		return this.blockIndexInTexture + (var1 == 1 ? 1 : 0);
	}

	public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
		if(var1.getBlockMetadata(var2, var3, var4) == 0) {
			return false;
		} else {
			this.func_28038_b_(var1, var2, var3, var4);
			return true;
		}
	}

	public void ejectRecord(World var1, int var2, int var3, int var4, int var5) {
		if(!var1.multiplayerWorld) {
			TileEntityRecordPlayer var6 = (TileEntityRecordPlayer)var1.getBlockTileEntity(var2, var3, var4);
			var6.record = var5;
			var6.onInventoryChanged();
			var1.setBlockMetadataWithNotify(var2, var3, var4, 1);
		}

	}

	public void func_28038_b_(World var1, int var2, int var3, int var4) {
		if(!var1.multiplayerWorld) {
			TileEntityRecordPlayer var5 = (TileEntityRecordPlayer)var1.getBlockTileEntity(var2, var3, var4);
			int var6 = var5.record;
			if(var6 != 0) {
				var1.func_28106_e(1005, var2, var3, var4, 0);
				var1.playRecord((String)null, var2, var3, var4);
				var5.record = 0;
				var5.onInventoryChanged();
				var1.setBlockMetadataWithNotify(var2, var3, var4, 0);
				float var7 = 0.7F;
				double var8 = (double)(var1.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
				double var10 = (double)(var1.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
				double var12 = (double)(var1.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
				EntityItem var14 = new EntityItem(var1, (double)var2 + var8, (double)var3 + var10, (double)var4 + var12, new ItemStack(var6, 1, 0));
				var14.delayBeforeCanPickup = 10;
				var1.entityJoinedWorld(var14);
			}
		}

	}

	public void onBlockRemoval(World var1, int var2, int var3, int var4) {
		this.func_28038_b_(var1, var2, var3, var4);
		super.onBlockRemoval(var1, var2, var3, var4);
	}

	public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
		if(!var1.multiplayerWorld) {
			super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
		}

	}

	protected TileEntity getBlockEntity() {
		return new TileEntityRecordPlayer();
	}
}
