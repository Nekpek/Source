package sdc.nekpek.Esquire.Blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
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
                this.setTickRandomly(true);
            }

        public static final String[] HerbType = new String[] { "Black Sun Flower", "Snowy Mist" };
        public static int HerbAmounts = HerbType.length;
        @SideOnly(Side.CLIENT)
        private Icon[] iconArray;

        public static int limitToValidMetadata(int par0)
            {
                return par0 & HerbAmounts;
            }

        @Override
        public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
            {
                for (int i = 0; i < HerbAmounts; i++)
                    {
                        par3List.add(new ItemStack(par1, 1, i));
                    }
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
         */
        public Icon getIcon(int par1, int par2)
            {
                return this.iconArray[par2 % this.iconArray.length];
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * When this method is called, your block should register all the icons it needs with the given IconRegister. This
         * is the only chance you get to register icons.
         */
        public void registerIcons(IconRegister par1IconRegister)
            {
                this.iconArray = new Icon[HerbAmounts];

                for (int i = 0; i < HerbAmounts; ++i)
                    {
                        this.iconArray[i] = par1IconRegister.registerIcon("Esquire:" + HerbType[i]);
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
                Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
                return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) && (soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this) || par1World.getBlockId(par2, par3 - 1, par4) == Block.sand.blockID);
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

        @Override
        public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
            {
                int id = idPicked(world, x, y, z);

                if (id == 0)
                    {
                        return null;
                    }

                Item item = Item.itemsList[id];
                if (item == null)
                    {
                        return null;
                    }

                return new ItemStack(id, 1, world.getBlockMetadata(x, y, z));
            }

        @Override
        public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
            {
                return null;
            }
    }
