package net.minecraft.src;

import java.util.Random;

public class ItemPDA extends Item {
	
	Random generator = new Random();
	
    public ItemPDA(int var1) {
        super(var1);
        this.maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
        var2.playSoundAtEntity(var3, "note.harp", 1F, 1F);
        var3.addChatMessage(" ");
        var3.addChatMessage(" ");
        var3.addChatMessage(" ");
        var3.addChatMessage(" ");
        var3.addChatMessage(" ");
        var3.addChatMessage(" ");
        String user = var3.username;
        var3.addChatMessage("User: §e"+user);
        double x = var3.posX;
        double y = var3.posY;
        double z = var3.posZ;
        var3.addChatMessage("Position: §e"+Math.round(x)+"§r, §e"+Math.round(y)+"§r, §e"+Math.round(z)+"§r");
        long time = var2.getWorldTime();
        var3.addChatMessage("Time: §e"+Math.round(time));
        if (var2.isDaytime()) {
        	var3.addChatMessage("Daytime: §aYes");
        } else {
        	var3.addChatMessage("Daytime: §cNo");
        }
        int health = var3.health;
        var3.addChatMessage("Health: §e"+health);
        int armor = ModLoader.getMinecraftInstance().thePlayer.getPlayerArmorValue();
        var3.addChatMessage("Armor: §e"+armor);
        int air = var3.air;
        var3.addChatMessage("Air: §e"+air);
        float light = var2.getBlockLightValue((int)Math.round(x), (int)Math.round(y-1), (int)Math.round(z));
        var3.addChatMessage("Light: §e"+Math.round(light));
        float pitch = var3.rotationPitch;
    	var3.addChatMessage("Pitch: §e"+Math.round(pitch));
    	float yaw = var3.rotationYaw;
    	var3.addChatMessage("Yaw: §e"+Math.round(yaw));
    	return var1;
    	
    }
}
