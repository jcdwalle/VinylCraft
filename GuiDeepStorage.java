package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class GuiDeepStorage extends GuiContainerCustom {
    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;
    private TileEntityDeepStorage storageEntity;
    protected List controlList = new ArrayList();
    private int inventoryRows = 0;

    public void initGui() {
        super.initGui();
        this.mc.thePlayer.craftingInventory = this.inventorySlots;
        
    }
    public GuiDeepStorage(IInventory var1, IInventory var2, TileEntityDeepStorage ent) {
        super(new ContainerChest(var1, var2),ent);
        this.upperChestInventory = var1;
        this.lowerChestInventory = var2;
        this.storageEntity = ent;
        this.allowUserInput = true;
        short var3 = 222;
        int var4 = var3 - 108;
        this.inventoryRows = var2.getSizeInventory() / 9;
        this.ySize = var4 + 3 * 18;
    }

    protected void drawGuiContainerForegroundLayer() {
        this.fontRenderer.drawString(this.lowerChestInventory.getInvName(), 8, 6, 4210752);
        this.fontRenderer.drawString("§dStorage", 8, 18, 4210752);
        this.fontRenderer.drawString("§dUnit", 8, 30, 4210752);
        
        this.fontRenderer.drawString(this.upperChestInventory.getInvName(), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float var1) {
        int var2 = this.mc.renderEngine.getTexture("/gui/deepstorage.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var2);
        int var3 = (this.width - this.xSize) / 2;
        int var4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var3, var4, 0, 0, this.xSize+80, 167);
        //this.drawTexturedModalRect(var3, var4 + this.inventoryRows * 18 + 40, 0, 126, this.xSize, 96);
    }
}
