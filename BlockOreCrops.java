package net.minecraft.src;

import java.util.Random;

public class BlockOreCrops extends BlockFlower {
	
	private int[] textureArray = new int[8];
	public Item seedItem = mod_Vinyl.OreSeedsDiamond;
	public Item dropItem = mod_Vinyl.OreWheatDiamond;
	public String type;
	
    protected BlockOreCrops(int var1, int var2, int t0, int t1, int t2, int t3, int t4, int t5, int t6, int t7, String drop) {
        super(var1, var2);
        this.blockIndexInTexture = var2;
        this.setTickOnLoad(true);
        float var3 = 0.5F;
        this.type = drop;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        textureArray[0] = t0;
        textureArray[1] = t1;
        textureArray[2] = t2;
        textureArray[3] = t3;
        textureArray[4] = t4;
        textureArray[5] = t5;
        textureArray[6] = t6;
        textureArray[7] = t7;
        
        
        //System.out.println(drop);
        //System.out.println(this.seed);
        
    }

    protected boolean canThisPlantGrowOnThisBlockID(int var1) {
        return var1 == Block.tilledField.blockID;
    }

    public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
        super.updateTick(var1, var2, var3, var4, var5);
        if (var1.getBlockLightValue(var2, var3 + 1, var4) >= 9) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            if (var6 < 7) {
                float var7 = this.getGrowthRate(var1, var2, var3, var4);
                if (var5.nextInt((int)(100.0F / var7)) == 0) {
                    ++var6;
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var6);
                }
            }
        }

    }

    public void fertilize(World var1, int var2, int var3, int var4) {
    	if (var1.getBlockMetadata(var2, var3, var4) != 7 ) {
    		var1.setBlockMetadataWithNotify(var2, var3, var4, var1.getBlockMetadata(var2, var3, var4)+1);
            var1.markBlockNeedsUpdate(var2, var3, var4);
            var1.scheduleBlockUpdate(var2, var3, var4, this.blockID, this.tickRate());
    	}
        
    }

    private float getGrowthRate(World var1, int var2, int var3, int var4) {
        float var5 = 1.0F;
        int var6 = var1.getBlockId(var2, var3, var4 - 1);
        int var7 = var1.getBlockId(var2, var3, var4 + 1);
        int var8 = var1.getBlockId(var2 - 1, var3, var4);
        int var9 = var1.getBlockId(var2 + 1, var3, var4);
        int var10 = var1.getBlockId(var2 - 1, var3, var4 - 1);
        int var11 = var1.getBlockId(var2 + 1, var3, var4 - 1);
        int var12 = var1.getBlockId(var2 + 1, var3, var4 + 1);
        int var13 = var1.getBlockId(var2 - 1, var3, var4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for(int var17 = var2 - 1; var17 <= var2 + 1; ++var17) {
            for(int var18 = var4 - 1; var18 <= var4 + 1; ++var18) {
                int var19 = var1.getBlockId(var17, var3 - 1, var18);
                float var20 = 0.0F;
                if (var19 == Block.tilledField.blockID) {
                    var20 = 1.0F;
                    if (var1.getBlockMetadata(var17, var3 - 1, var18) > 0) {
                        var20 = 3.0F;
                    }
                }

                if (var17 != var2 || var18 != var4) {
                    var20 /= 4.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15) {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getBlockTextureFromSideAndMetadata(int var1, int var2) {
    	if (var2 < 0) {
            var2 = 7;
        }

        return textureArray[var2];
    }

    public int getRenderType() {
        return 6;
    }

    public void updateDrops() {
    	if (type == "diamond") {
        	this.seedItem = mod_Vinyl.OreSeedsDiamond;
        	this.dropItem = mod_Vinyl.OreWheatDiamond;
        }
        if (type == "iron") {
        	this.seedItem = mod_Vinyl.OreSeedsIron;
        	this.dropItem = mod_Vinyl.OreWheatIron;
        }
        if (type == "redstone") {
        	this.seedItem = mod_Vinyl.OreSeedsRedstone;
        	this.dropItem = mod_Vinyl.OreWheatRedstone;
        }
        if (type == "gold") {
        	this.seedItem = mod_Vinyl.OreSeedsGold;
        	this.dropItem = mod_Vinyl.OreWheatGold;
        }
        if (type == "lapis") {
        	this.seedItem = mod_Vinyl.OreSeedsLapis;
        	this.dropItem = mod_Vinyl.OreWheatLapis;
        }
        if (type == "coal") {
        	this.seedItem = mod_Vinyl.OreSeedsCoal;
        	this.dropItem = mod_Vinyl.OreWheatCoal;
        }
    }
    
    public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6) {
    	//Item seedItem = seed;
    	updateDrops();
        super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6);
        if (!var1.multiplayerWorld) {
            for(int var7 = 0; var7 < 3; ++var7) {
                if (var1.rand.nextInt(15) <= var5) {
                    float var8 = 0.7F;
                    float var9 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var10 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    float var11 = var1.rand.nextFloat() * var8 + (1.0F - var8) * 0.5F;
                    EntityItem var12 = new EntityItem(var1, (double)((float)var2 + var9), (double)((float)var3 + var10), (double)((float)var4 + var11), new ItemStack(seedItem,1));
                    var12.delayBeforeCanPickup = 10;
                    var1.entityJoinedWorld(var12);
                }
            }

        }
    }

    public int idDropped(int var1, Random var2) {
    	updateDrops();
        return var1 == 7 ? dropItem.shiftedIndex : -1;
    }

    public int quantityDropped(Random var1) {
        return 1;
    }
}
