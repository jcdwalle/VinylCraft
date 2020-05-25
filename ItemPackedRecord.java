package net.minecraft.src;

import java.util.Random;

public class ItemPackedRecord extends Item {
	
	Random generator = new Random();
	
    public ItemPackedRecord(int var1) {
        super(var1);
        this.maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        var2.playSoundAtEntity(var3, "mob.chickenplop", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        int randomIndex = generator.nextInt(mod_Vinyl.Records.length);
        var3.addChatMessage("Enjoy your new record!");
    	return new ItemStack(mod_Vinyl.Records[randomIndex],1);
    }
}
