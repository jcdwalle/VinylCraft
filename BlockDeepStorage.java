package net.minecraft.src;

import java.util.Random;

public class BlockDeepStorage extends BlockContainer {
    private Random random = new Random();
    int topTexture;
    int bottomTexture;

    protected BlockDeepStorage(int var1, int var2, Material var3, int var4, int var5) {
        super(var1, var2, var3);
        this.topTexture = var4;
        this.bottomTexture = var5;
    }
    @Override
    protected TileEntity getBlockEntity() {
        return new TileEntityDeepStorage();
    }
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
        int var5 = 0;
        if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID) {
            ++var5;
        }

        if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID) {
            ++var5;
        }

        if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID) {
            ++var5;
        }

        if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID) {
            ++var5;
        }

        if (var5 > 100) {
            return false;
        } else if (this.isThereANeighborChest(var1, var2 - 1, var3, var4)) {
            return false;
        } else if (this.isThereANeighborChest(var1, var2 + 1, var3, var4)) {
            return false;
        } else if (this.isThereANeighborChest(var1, var2, var3, var4 - 1)) {
            return false;
        } else {
            return !this.isThereANeighborChest(var1, var2, var3, var4 + 1);
        }
    }

    private boolean isThereANeighborChest(World var1, int var2, int var3, int var4) {
        return false;
    }

    public void onBlockRemoval(World var1, int var2, int var3, int var4) {
    	TileEntityDeepStorage var5 = (TileEntityDeepStorage)var1.getBlockTileEntity(var2, var3, var4);

        for(int var6 = 0; var6 < var5.getSizeInventory(); ++var6) {
            ItemStack var7 = var5.getStackInSlot(var6);
            if (var7 != null) {
                float var8 = this.random.nextFloat() * 0.8F + 0.1F;
                float var9 = this.random.nextFloat() * 0.8F + 0.1F;
                float var10 = this.random.nextFloat() * 0.8F + 0.1F;

                while(var7.stackSize > 0) {
                    int var11 = this.random.nextInt(21) + 10;
                    if (var11 > var7.stackSize) {
                        var11 = var7.stackSize;
                    }

                    var7.stackSize -= var11;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
                    float var13 = 0.05F;
                    var12.motionX = (double)((float)this.random.nextGaussian() * var13);
                    var12.motionY = (double)((float)this.random.nextGaussian() * var13 + 0.2F);
                    var12.motionZ = (double)((float)this.random.nextGaussian() * var13);
                    var1.entityJoinedWorld(var12);
                }
            }
        }

        super.onBlockRemoval(var1, var2, var3, var4);
    }

    public boolean blockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5) {
        Object var6 = (TileEntityDeepStorage)var1.getBlockTileEntity(var2, var3, var4);
        if (var1.isBlockNormalCube(var2, var3 + 1, var4)) {
            return true;
        } else if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID && var1.isBlockNormalCube(var2 - 1, var3 + 1, var4)) {
            return true;
        } else if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID && var1.isBlockNormalCube(var2 + 1, var3 + 1, var4)) {
            return true;
        } else if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID && var1.isBlockNormalCube(var2, var3 + 1, var4 - 1)) {
            return true;
        } else if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID && var1.isBlockNormalCube(var2, var3 + 1, var4 + 1)) {
            return true;
        } else {
            if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID) {
                //var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.getBlockTileEntity(var2 - 1, var3, var4), (IInventory)var6);
            }

            if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID) {
                //var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.getBlockTileEntity(var2 + 1, var3, var4));
            }

            if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID) {
                //var6 = new InventoryLargeChest("Large chest", (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4 - 1), (IInventory)var6);
            }

            if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID) {
                //var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)var1.getBlockTileEntity(var2, var3, var4 + 1));
            }

            if (var1.multiplayerWorld) {
                return true;
            } else {
            	ModLoader.getMinecraftInstance().displayGuiScreen(new GuiDeepStorage(var5.inventory, (IInventory)var6, (TileEntityDeepStorage)var6));
                //var5.displayGUIChest((IInventory)var6);
                return true;
            }
        }
    }
    
    public int getBlockTextureFromSide(int var1) {
        if (var1 == 1) {
            return topTexture;
        } else if (var1 == 0) {
            return bottomTexture;
        } else {
            return this.blockIndexInTexture;
        }
    }

   
}
