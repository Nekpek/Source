package sdc.nekpek.Esquire.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;
import sdc.nekpek.Esquire.Entities.EsquireMortarTileEntity;
import sdc.nekpek.Esquire.common.Esquire;

public class BlockEsquireMortarStone extends BlockContainer
    {

        protected BlockEsquireMortarStone(int par1)
            {
                super(par1, Material.rock);
                this.setCreativeTab(EsquireTabs.EsquireTabBlocks);
                this.setBlockBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 0.4375F, 0.6875F);

            }

        @Override
        public TileEntity createNewTileEntity(World world)
            {
                return new EsquireMortarTileEntity();
            }

        @Override
        public int getRenderType()
            {
                return -1;
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
        public void registerIcons(IconRegister par1IconRegister)
            {
                blockIcon = par1IconRegister.registerIcon("Esquire:StoneMortar");
            }

        @Override
        public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
            {
                if (!par5EntityPlayer.isSneaking())
                    {
                        par5EntityPlayer.openGui(Esquire.instance, 1, par1World, par2, par3, par4);
                        return true;
                    }
                else
                    {
                        return false;
                    }
            }
    }
