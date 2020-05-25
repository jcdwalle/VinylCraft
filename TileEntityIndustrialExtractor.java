package net.minecraft.src;

public class TileEntityIndustrialExtractor extends TileEntity implements IInventory {
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;

    public int getSizeInventory() {
        return this.furnaceItemStacks.length;
    }

    public ItemStack getStackInSlot(int paramInt) {
        return this.furnaceItemStacks[paramInt];
    }

    public ItemStack decrStackSize(int paramInt1, int paramInt2) {
        if (this.furnaceItemStacks[paramInt1] != null) {
            ItemStack localiz;
            if (this.furnaceItemStacks[paramInt1].stackSize <= paramInt2) {
                localiz = this.furnaceItemStacks[paramInt1];
                this.furnaceItemStacks[paramInt1] = null;
                return localiz;
            } else {
                localiz = this.furnaceItemStacks[paramInt1].splitStack(paramInt2);
                if (this.furnaceItemStacks[paramInt1].stackSize == 0) {
                    this.furnaceItemStacks[paramInt1] = null;
                }

                return localiz;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int paramInt, ItemStack paramiz) {
        this.furnaceItemStacks[paramInt] = paramiz;
        if (paramiz != null && paramiz.stackSize > this.getInventoryStackLimit()) {
            paramiz.stackSize = this.getInventoryStackLimit();
        }

    }

    public String getInvName() {
        return "Furnace";
    }

    public void readFromNBT(NBTTagCompound paramnu) {
        super.readFromNBT(paramnu);
        NBTTagList localsp = paramnu.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for(int j = 0; j < localsp.tagCount(); ++j) {
            NBTTagCompound localnu = (NBTTagCompound)localsp.tagAt(j);
            int k = localnu.getByte("Slot");
            if (k >= 0 && k < this.furnaceItemStacks.length) {
                this.furnaceItemStacks[k] = new ItemStack(localnu);
            }
        }

        this.furnaceBurnTime = paramnu.getShort("BurnTime");
        this.furnaceCookTime = paramnu.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound paramnu) {
        super.writeToNBT(paramnu);
        paramnu.setShort("BurnTime", (short)this.furnaceBurnTime);
        paramnu.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList localsp = new NBTTagList();

        for(int j = 0; j < this.furnaceItemStacks.length; ++j) {
            if (this.furnaceItemStacks[j] != null) {
                NBTTagCompound localnu = new NBTTagCompound();
                localnu.setByte("Slot", (byte)j);
                this.furnaceItemStacks[j].writeToNBT(localnu);
                localsp.setTag(localnu);
            }
        }

        paramnu.setTag("Items", localsp);
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public int getCookProgressScaled(int paramInt) {
        return this.furnaceCookTime * paramInt / 200;
    }

    public int getBurnTimeRemainingScaled(int paramInt) {
        if (this.currentItemBurnTime == 0) {
            this.currentItemBurnTime = 200;
        }

        return this.furnaceBurnTime * paramInt / this.currentItemBurnTime;
    }

    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity() {
        boolean j = this.furnaceBurnTime > 0;
        boolean k = false;
        if (this.furnaceBurnTime > 0) {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.multiplayerWorld) {
            if (this.furnaceBurnTime == 0 && this.canSmelt()) {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
                if (this.furnaceBurnTime > 0) {
                    k = true;
                    if (this.furnaceItemStacks[1] != null) {
                        if (this.furnaceItemStacks[1].getItem().hasContainerItem()) {
                            this.furnaceItemStacks[1] = new ItemStack(this.furnaceItemStacks[1].getItem().getContainerItem());
                        } else {
                            --this.furnaceItemStacks[1].stackSize;
                        }

                        if (this.furnaceItemStacks[1].stackSize == 0) {
                            this.furnaceItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt()) {
                ++this.furnaceCookTime;
                if (this.furnaceCookTime == 200) {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    k = true;
                }
            } else {
                this.furnaceCookTime = 0;
            }

            if (j != this.furnaceBurnTime > 0) {
                k = true;
                //BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (k) {
            this.onInventoryChanged();
        }

    }
    


    private boolean canSmelt() {
        if (this.furnaceItemStacks[0] == null) {
            return false;
        } else {
            boolean localiz = false;
            if (getExtractionResult(this.furnaceItemStacks[0].getItem().shiftedIndex) != null) {
            	localiz = true;
            }
            if (localiz == false) {
            	//System.out.println("not e");
                return false;
            } else if (this.furnaceItemStacks[2] == null) {
                return true;
            } else if (!this.furnaceItemStacks[2].isItemEqual(this.furnaceItemStacks[0])) {
                return true;
            } else if (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
                return true;
            } else {
                return this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[0].getMaxStackSize();
            }
        }
    }
    
    public ItemStack getExtractionResult(int input) {
    	if (input == Block.netherrack.blockID) {
    		return new ItemStack(Item.redstone, 1);
    		}
    	if (input == Block.gravel.blockID) {
    		return new ItemStack(Item.flint, 1);
    		}
    	if (input == Block.slowSand.blockID) {
    		return new ItemStack(Item.dyePowder, 1, 3);
    		}
    	if (input == Item.bucketWater.shiftedIndex) {
    		return new ItemStack(Block.ice, 1);
    		}
    	if (input == Block.wood.blockID) {
    		return new ItemStack(Item.coal, 1);
    		}
    	if (input == Item.leather.shiftedIndex) {
    		return new ItemStack(mod_Vinyl.DriedLeather, 3);
    	}
    	else {
    		return null;
    	}
    }

    public void smeltItem() {
        if (this.canSmelt()) {
            ItemStack localiz = getExtractionResult(this.furnaceItemStacks[0].getItem().shiftedIndex);
            if (this.furnaceItemStacks[2] == null) {
                this.furnaceItemStacks[2] = localiz.copy();
            } else if (this.furnaceItemStacks[2].itemID == localiz.itemID) {
                ItemStack var10000 = this.furnaceItemStacks[2];
                var10000.stackSize += localiz.stackSize;
            }

            if (this.furnaceItemStacks[0].getItem().hasContainerItem()) {
                this.furnaceItemStacks[0] = new ItemStack(this.furnaceItemStacks[0].getItem().getContainerItem());
            } else {
                --this.furnaceItemStacks[0].stackSize;
            }

            if (this.furnaceItemStacks[0].stackSize <= 0) {
                this.furnaceItemStacks[0] = null;
            }

        }
    }

    private int getItemBurnTime(ItemStack paramiz) {
        if (paramiz == null) {
            return 0;
        } else {
        	
            int j = paramiz.getItem().shiftedIndex;
            if (j == Item.redstone.shiftedIndex) {
                return 800;
            } else {
            	return 0;
            }
        }
    }

    public boolean canInteractWith(EntityPlayer paramgs) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        } else {
            return paramgs.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
        }
    }
}
