package nekpek.mod.Naturalis.blocks;

import java.util.Random;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockNaturalisRottingBark2 extends Block
    {
        public BlockNaturalisRottingBark2(int par1, Material par2Material)
            {
                super(par1, par2Material);
                this.setBlockBounds(0.035F, 0.0F, 0.15F, 0.965F, 0.07F, 0.85F);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                blockIcon = iconRegister.registerIcon("Naturalis:NaturalisRottingBark2");
            }

        @Override
        public boolean renderAsNormalBlock()
            {
                return false;
            }

        @Override
        public int idDropped(int par1, Random par2Random, int par3)
            {
                return Naturalis.NaturalisBastFibre.itemID;
            }

        @Override
        public int quantityDroppedWithBonus(int par1, Random par2Random)
            {
                return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
            }

        /**
         * Returns the quantity of items to drop on block destruction.
         */
        @Override
        public int quantityDropped(Random par1Random)
            {
                return 1 + par1Random.nextInt(3);
            }

        @Override
        public boolean isOpaqueCube()
            {
                return false;
            }
    }
