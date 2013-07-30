package nekpek.mod.Naturalis.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNaturalisBirchBare extends Block
    {
        public BlockNaturalisBirchBare(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.06F, 0.0F, 0.06F, 0.94F, 1F, 0.94F);
            }

        @SideOnly(Side.CLIENT)
        private Icon iconArray;
        @SideOnly(Side.CLIENT)
        private Icon tree_top;

        @Override
        public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
            {
                int j1 = par9 & 3;
                byte b0 = 0;

                switch (par5) {
                    case 0:
                    case 1:
                        b0 = 0;
                        break;

                    case 2:
                    case 3:
                        b0 = 8;
                        break;

                    case 4:
                    case 5:
                        b0 = 4;
                }

                return j1 | b0;
            }

        @Override
        @SideOnly(Side.CLIENT)
        /**
         * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
         */
        public Icon getIcon(int par1, int par2)
            {
                int k = par2 & 12;
                return k == 0 && (par1 == 1 || par1 == 0) ? tree_top : k == 4 && (par1 == 5 || par1 == 4) ? tree_top : k == 8 && (par1 == 2 || par1 == 3) ? tree_top : iconArray;
            }

        @Override
        public void registerIcons(IconRegister par1IconRegister)
            {
                tree_top = par1IconRegister.registerIcon("Naturalis:log_birch_top");
                iconArray = par1IconRegister.registerIcon("Naturalis:NaturalisBirchBare");
            }

        @Override
        public boolean canSustainLeaves(World world, int x, int y, int z)
            {
                return true;
            }

        @Override
        public boolean isWood(World world, int x, int y, int z)
            {
                return true;
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }
    }