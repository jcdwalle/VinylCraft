package net.minecraft.src;

public class ItemCreeperWhistle extends Item {
    public ItemCreeperWhistle(int var1) {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(15);
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        var2.playSoundAtEntity(var3, "random.fuse", 1F, 0.5F);
        if (!var2.multiplayerWorld) {
        	var1.damageItem(1, var3);
            EntityCreeper spawnedCreeper = new EntityCreeper(var2);
            System.out.println("test");
            spawnedCreeper.timeSinceIgnited = -200;
            spawnedCreeper.setPosition(var3.posX, var3.posY, var3.posZ);
            System.out.println(spawnedCreeper.posX);
            System.out.println(spawnedCreeper.posY);
            System.out.println(spawnedCreeper.posZ);
            var2.entityJoinedWorld(spawnedCreeper);
        }

        return var1;
    }
}
