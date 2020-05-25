package net.minecraft.src;

public class ItemLightningRod extends Item {
    public ItemLightningRod(int var1) {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(63);
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        
    	var3.addWeatherEffect(new EntityLightningBolt(var3, var4, var5, var6));
    	var1.damageItem(1, var2);
    	return true;
    }

    public boolean isFull3D() {
        return true;
    }
}
