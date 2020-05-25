package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ItemRecordCustom extends ItemRecord {
    public final String recordName;
    public final String recordArtist;

    public ItemRecordCustom(int var1, String var2, String var3) {
        super(var1, var2);
        this.recordName = var2;
        this.recordArtist = var3;
        this.maxStackSize = 1;
    }

    public Minecraft getMinecraftInstance() {
		Minecraft mc = ModLoader.getMinecraftInstance();
		return mc;
    }
    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7) {
        if (var3.getBlockId(var4, var5, var6) == Block.jukebox.blockID && var3.getBlockMetadata(var4, var5, var6) == 0) {
            if (var3.multiplayerWorld) {
                return true;
            } else {
                ((BlockJukeBox)Block.jukebox).ejectRecord(var3, var4, var5, var6, this.shiftedIndex);
                
                var3.playAuxSFXAtEntity((EntityPlayer)null, 1005, var4, var5, var6, this.shiftedIndex);
                --var1.stackSize;
                this.getMinecraftInstance().ingameGUI.setRecordPlayingMessage(this.recordArtist+" - "+this.recordName);
                return true;
            }
        } else {
            return false;
        }
    }
}








