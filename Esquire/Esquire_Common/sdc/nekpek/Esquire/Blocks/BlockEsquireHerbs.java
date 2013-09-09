package sdc.nekpek.Esquire.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEsquireHerbs extends Block implements IPlantable
    {
        public BlockEsquireHerbs(int par1, Material par2Material)
            {
                super(par1, par2Material);
                float f = 0.2F;
                this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
                setCreativeTab(EsquireTabs.EsquireTabHerbs);
            }

        public static final String[] HerbType = new String[] { "BlackSunFlower", "SnowyMist" };

        public static int limitToValidMetadata(int par0)
            {
                return par0 & 2;
            }

        @Override
        public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                par3List.add(new ItemStack(par1, 1, 0));
                par3List.add(new ItemStack(par1, 1, 1));
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * When this method is called, your block should register all the icons it needs with the given IconRegister. This
         * is the only chance you get to register icons.
         */
        public void registerIcons(IconRegister par1IconRegister)
            {
                for (int i = 0; i < HerbType.length; i++)
                    {
                        blockIcon = par1IconRegister.registerIcon("Esquire:" + HerbType[i]);
                    }
            }

        @Override
        public void onBlockAdded(World par1World, int par2, int par3, int par4)
            {
                if (!canBlockStay(par1World, par2, par3, par4))
                    {
                        par1World.destroyBlock(par2, par3, par4, false);
                    }
            }

        @Override
        public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
            {
                return super.canPlaceBlockAt(par1World, par2, par3, par4);
            }

        @Override
        public boolean canBlockStay(World par1World, int par2, int par3, int par4)
            {

                if (par1World.getBlockId(par2, par3 - 1, par4) == Block.sand.blockID && par1World.getBlockMetadata(par2, par3, par4) == 0)
                    {
                        return true;
                    }
                if (par1World.getBlockId(par2, par3 - 1, par4) == Block.dirt.blockID || par1World.getBlockId(par2, par3 - 1, par4) == Block.grass.blockID && par1World.getBlockMetadata(par2, par3, par4) == 1)
                    {
                        return true;
                    }
                return false;
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public int getRenderType()
            {
                return 1;
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }

        @Override
        public EnumPlantType getPlantType(World world, int x, int y, int z)
            {

                return EnumPlantType.Plains;
            }

        @Override
        public int getPlantID(World world, int x, int y, int z)
            {

                return blockID;
            }

        @Override
        public int getPlantMetadata(World world, int x, int y, int z)
            {
                return world.getBlockMetadata(x, y, z);
            }

    }
