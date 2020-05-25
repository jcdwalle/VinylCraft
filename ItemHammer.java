package net.minecraft.src;

public class ItemHammer extends ItemTool {
    private static Block[] blocksEffectiveAgainst;

    protected ItemHammer(int var1, EnumToolMaterial var2) {
        super(var1, 2, var2, blocksEffectiveAgainst);
    }
    
    public boolean onBlockDestroyed(ItemStack var1, int var2, int var3, int var4, int var5, EntityLiving var6) {
    	var1.damageItem(1, var6);
    	EntityPlayerSP player = ModLoader.getMinecraftInstance().thePlayer;
    	int rot = (MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        if (rot == 0 || rot == 2) {
        	breakBlockAt(var3, var4+1, var5);
            breakBlockAt(var3-1, var4+1, var5);
            breakBlockAt(var3+1, var4+1, var5);
            breakBlockAt(var3-1, var4, var5);
            breakBlockAt(var3+1, var4, var5);
            breakBlockAt(var3+1, var4-1, var5);
            breakBlockAt(var3-1, var4-1, var5);
            breakBlockAt(var3, var4-1, var5);
        }
        if (rot == 1 || rot == 3) {
        	breakBlockAt(var3, var4, var5-1);
        	breakBlockAt(var3, var4, var5+1);
        	breakBlockAt(var3, var4+1, var5-1);
        	breakBlockAt(var3, var4+1, var5);
        	breakBlockAt(var3, var4+1, var5+1);
        	breakBlockAt(var3, var4-1, var5+1);
        	breakBlockAt(var3, var4-1, var5);
        	breakBlockAt(var3, var4-1, var5-1);
        }
    	return false;
    }
    
    private void breakBlockAt(int var1, int var2, int var3) {
    	World world = ModLoader.getMinecraftInstance().theWorld;
    	Block toBreak = Block.blocksList[world.getBlockId(var1, var2, var3)];
    	if (toBreak != null) {
    		toBreak.dropBlockAsItem(world, var1, var2, var3, world.getBlockMetadata(var1, var2, var3));
    		world.setBlockWithNotify(var1, var2, var3, 0);
    	}
    }

    public boolean canHarvestBlock(Block var1) {
        if (var1 == Block.obsidian) {
            return this.toolMaterial.getHarvestLevel() == 3;
        } else if (var1 != Block.blockDiamond && var1 != Block.oreDiamond) {
            if (var1 != Block.blockGold && var1 != Block.oreGold) {
                if (var1 != Block.blockSteel && var1 != Block.oreIron) {
                    if (var1 != Block.blockLapis && var1 != Block.oreLapis) {
                        if (var1 != Block.oreRedstone && var1 != Block.oreRedstoneGlowing) {
                            if (var1.blockMaterial == Material.rock) {
                                return true;
                            } else {
                                return var1.blockMaterial == Material.iron;
                            }
                        } else {
                            return this.toolMaterial.getHarvestLevel() >= 2;
                        }
                    } else {
                        return this.toolMaterial.getHarvestLevel() >= 1;
                    }
                } else {
                    return this.toolMaterial.getHarvestLevel() >= 1;
                }
            } else {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        } else {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
    }

    static {
        blocksEffectiveAgainst = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis};
    }
}
