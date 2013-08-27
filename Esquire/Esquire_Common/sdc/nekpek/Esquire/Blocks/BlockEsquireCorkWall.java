package sdc.nekpek.Esquire.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.Items.EsquireItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEsquireCorkWall extends BlockPane
    {
        @SideOnly(Side.CLIENT)
        private Icon theIcon;
        private final String sideTextureIndex;
        private final boolean canDropItself;
        private final String field_94402_c;

        protected BlockEsquireCorkWall(int par1, String par2Str, String par3Str, Material par4Material, boolean par5)
            {
                super(par1, par2Str, par3Str, par4Material, par5);
                this.sideTextureIndex = par3Str;
                this.canDropItself = par5;
                this.field_94402_c = par2Str;
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
            {
                return false;
            }

        public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
            {
                int l = par1IBlockAccess.getBlockId(par2, par3, par4);

                if (l != blockID && l != Block.fenceGate.blockID)
                    {
                        Block block = Block.blocksList[l];
                        return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
                    }
                else
                    {
                        return true;
                    }
            }

        @Override
        @SideOnly(Side.CLIENT)
        public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
            {
                return true;
            }

        @Override
        public Icon getSideTextureIndex()
            {
                return this.theIcon;
            }

        @Override
        public Icon getIcon(int par1, int par2)
            {
                return this.blockIcon;
            }

        @Override
        public int idDropped(int par1, Random par2Random, int par3)
            {
                return EsquireItems.EsquireCork.itemID;
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                this.blockIcon = iconRegister.registerIcon("Esquire:CorkWall");
                this.theIcon = iconRegister.registerIcon("Esquire:CorkWall");
            }

        @Override
        public int idPicked(World par1World, int par2, int par3, int par4)
            {
                return EsquireItems.EsquireCork.itemID;
            }
    }
