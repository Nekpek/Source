package nekpek.mod.Naturalis.PowerFurnace;

import nekpek.mod.Naturalis.blocks.TileEntityNaturalisFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NaturalisGuiFurnace extends GuiContainer
    {
        private static final ResourceLocation field_110410_t = new ResourceLocation("Naturalis:textures/gui/PowerFurnaceGui.png");
        private final TileEntityNaturalisFurnace furnaceInventory;

        public NaturalisGuiFurnace(InventoryPlayer par1InventoryPlayer, TileEntityNaturalisFurnace par2TileEntityFurnace)
            {
                super(new NaturalisContainerPowerFurnace(par1InventoryPlayer, par2TileEntityFurnace));
                this.furnaceInventory = par2TileEntityFurnace;
            }

        /**
         * Draw the foreground layer for the GuiContainer (everything in front
         * of the items)
         */
        @Override
        protected void drawGuiContainerForegroundLayer(int par1, int par2)
            {
                String s = this.furnaceInventory.isInvNameLocalized() ? this.furnaceInventory.getInvName() : I18n.getString(this.furnaceInventory.getInvName());
                this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
                this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
            }

        /**
         * Draw the background layer for the GuiContainer (everything behind the
         * items)
         */
        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
            {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.getTextureManager().bindTexture(field_110410_t);
                int k = (this.width - this.xSize) / 2;
                int l = (this.height - this.ySize) / 2;
                this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
                int i1;

                if (this.furnaceInventory.isBurning())
                    {
                        i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
                        this.drawTexturedModalRect(k + 39, l + 19 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
                    }

                i1 = this.furnaceInventory.getCookProgressScaled(24);
                this.drawTexturedModalRect(k + 87, l + 35, 176, 14, i1 + 1, 16);
            }
    }
