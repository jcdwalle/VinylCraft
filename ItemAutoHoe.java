package net.minecraft.src;

public class ItemAutoHoe extends Item {
    public ItemAutoHoe(int var1) {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(3499);
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        int var8 = var3.getBlockId(var4, var5, var6);
        int var9 = var3.getBlockId(var4, var5 + 1, var6);
        if (var8 == Block.crops.blockID || var8 == mod_Vinyl.BlockOreCropsCoal.blockID || var8 == mod_Vinyl.BlockOreCropsIron.blockID || var8 == mod_Vinyl.BlockOreCropsDiamond.blockID || 
        		var8 == mod_Vinyl.BlockOreCropsGold.blockID || var8 == mod_Vinyl.BlockOreCropsLapis.blockID || var8 == mod_Vinyl.BlockOreCropsRedstone.blockID) {
        	int growthLevel = var3.getBlockMetadata(var4, var5, var6);
        	String str = "Growth level: §e"+growthLevel;
        	if (growthLevel == 7) {
        		str+= " §r(§aHarvestable§r)";
        	}
        	var2.addChatMessage(str);
        }
        if ((var7 == 0 || var9 != 0 || var8 != Block.grass.blockID) && var8 != Block.dirt.blockID) {
            return false;
        } else {
            Block var10 = Block.tilledField;
            var3.playSoundEffect((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), var10.stepSound.stepSoundDir2(), (var10.stepSound.getVolume() + 1.0F) / 2.0F, var10.stepSound.getPitch() * 0.8F);
            if (var3.multiplayerWorld) {
                return true;
            } else {
                var3.setBlockWithNotify(var4, var5, var6, var10.blockID);
                var1.damageItem(1, var2);
                return true;
            }
        }
    }

    public boolean isFull3D() {
        return true;
    }
}
