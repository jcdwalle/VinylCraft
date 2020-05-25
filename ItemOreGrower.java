package net.minecraft.src;

public class ItemOreGrower extends Item {

    protected ItemOreGrower(int var1) {
        super(var1);
        this.maxStackSize = 64;
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
            int var8 = var3.getBlockId(var4, var5, var6);

            if (var8 == mod_Vinyl.BlockOreCropsDiamond.blockID || var8 == mod_Vinyl.BlockOreCropsIron.blockID || 
            		var8 == mod_Vinyl.BlockOreCropsRedstone.blockID || var8 == mod_Vinyl.BlockOreCropsGold.blockID ||
            		var8 == mod_Vinyl.BlockOreCropsLapis.blockID || var8 == mod_Vinyl.BlockOreCropsCoal.blockID) {
                if (!var3.multiplayerWorld) {
                	if (var3.getBlockMetadata(var4, var5, var6) != 7) {
                		((BlockOreCrops)mod_Vinyl.BlockOreCropsDiamond).fertilize(var3, var4, var5, var6);
                        --var1.stackSize;
                	}
                    
                }
                return true;
            }

        return false;
    }
}
