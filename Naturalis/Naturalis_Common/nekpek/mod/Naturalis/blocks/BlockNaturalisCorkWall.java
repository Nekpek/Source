package nekpek.mod.Naturalis.blocks;

import java.util.List;
import java.util.Random;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNaturalisCorkWall extends Block
    {

        public BlockNaturalisCorkWall(int par1, Material par2Material)
            {
                super(par1, par2Material);
            }

        @Override
        public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
            {
                boolean flag = this.canConnectFenceTo(par1World, par2, par3, par4 - 1);
                boolean flag1 = this.canConnectFenceTo(par1World, par2, par3, par4 + 1);
                boolean flag2 = this.canConnectFenceTo(par1World, par2 - 1, par3, par4);
                boolean flag3 = this.canConnectFenceTo(par1World, par2 + 1, par3, par4);
                float f = 0.43F;
                float f1 = 0.57F;
                float f2 = 0.43F;
                float f3 = 0.57F;

                if (flag)
                    {
                        f2 = 0.0F;
                    }

                if (flag1)
                    {
                        f3 = 1.0F;
                    }

                if (flag || flag1)
                    {
                        this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
                        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
                    }

                f2 = 0.43F;
                f3 = 0.57F;

                if (flag2)
                    {
                        f = 0.0F;
                    }

                if (flag3)
                    {
                        f1 = 1.0F;
                    }

                if (flag2 || flag3 || !flag && !flag1)
                    {
                        this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
                        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
                    }

                if (flag)
                    {
                        f2 = 0.0F;
                    }

                if (flag1)
                    {
                        f3 = 1.0F;
                    }

                this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
            }

        /**
         * Updates the blocks bounds based on its current state. Args: world, x,
         * y, z
         */

        @Override
        public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
            {
                boolean flag = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 - 1);
                boolean flag1 = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 + 1);
                boolean flag2 = this.canConnectFenceTo(par1IBlockAccess, par2 - 1, par3, par4);
                boolean flag3 = this.canConnectFenceTo(par1IBlockAccess, par2 + 1, par3, par4);
                float f = 0.43F;
                float f1 = 0.57F;
                float f2 = 0.43F;
                float f3 = 0.57F;

                if (flag)
                    {
                        f2 = 0.0F;
                    }

                if (flag1)
                    {
                        f3 = 1.0F;
                    }

                if (flag2)
                    {
                        f = 0.0F;
                    }

                if (flag3)
                    {
                        f1 = 1.0F;
                    }

                this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
            }

        /**
         * Is this block (a) opaque and (b) a full 1m cube? This determines
         * whether or not to render the shared face of two adjacent blocks and
         * also whether the player can attach torches, redstone wire, etc to
         * this block.
         */
        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }

        /**
         * If this block doesn't render as an ordinary block it will return
         * False (examples: signs, buttons, stairs, etc)
         */
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

        /**
         * Returns true if the specified block can be connected by a fence
         */
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
        /**
         * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
         * coordinates.  Args: blockAccess, x, y, z, side
         */
        public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
            {
                return true;
            }

        @Override
        public int idDropped(int par1, Random par2Random, int par3)
            {
                return Naturalis.NaturalisCork.itemID;
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisCorkWall");
            }
    }
