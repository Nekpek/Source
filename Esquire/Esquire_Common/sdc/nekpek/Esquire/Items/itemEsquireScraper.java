package sdc.nekpek.Esquire.Items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sdc.nekpek.Esquire.Blocks.EsquireBlocks;
import sdc.nekpek.Esquire.CreativeTabs.EsquireTabs;

public class itemEsquireScraper extends ItemAxe
    {

        public itemEsquireScraper(int par1, EnumToolMaterial par2EnumToolMaterial)
            {
                super(par1, par2EnumToolMaterial);
                this.setCreativeTab(EsquireTabs.EsquireTabItems);
                setMaxStackSize(1);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Esquire:Scraper");
            }

        @Override
        public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
            {
                if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
                    {
                        return false;
                    }
                else
                    {

                        int i1 = par3World.getBlockId(par4, par5, par6);
                        int i2 = par3World.getBlockMetadata(par4, par5, par6);

                        if (i1 != Block.wood.blockID)
                            {
                                return false;
                            }
                        else
                            {
                                if (i2 == 0)
                                    {
                                        Block block = EsquireBlocks.EsquireLogBare;
                                        par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                                        par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(EsquireItems.EsquireBark, 1, i2));

                                        if (par3World.isRemote)
                                            {

                                                return true;
                                            }
                                        else
                                            {
                                                par3World.setBlock(par4, par5, par6, block.blockID, i2, 3);
                                                par1ItemStack.damageItem(1, par2EntityPlayer);
                                                return true;
                                            }
                                    }
                                else
                                    if (i2 == 1)
                                        {
                                            Block block = EsquireBlocks.EsquireLogBare;
                                            par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                                            par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(EsquireItems.EsquireBark, 1, i2));

                                            if (par3World.isRemote)
                                                {
                                                    return true;
                                                }
                                            else
                                                {
                                                    par3World.setBlock(par4, par5, par6, block.blockID, i2, 3);
                                                    par1ItemStack.damageItem(1, par2EntityPlayer);
                                                    return true;
                                                }
                                        }
                                    else
                                        if (i2 == 2)
                                            {
                                                Block block = EsquireBlocks.EsquireLogBare;
                                                par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                                                par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(EsquireItems.EsquireBark, 1, i2));

                                                if (par3World.isRemote)
                                                    {
                                                        return true;
                                                    }
                                                else
                                                    {
                                                        par3World.setBlock(par4, par5, par6, block.blockID, i2, 3);
                                                        par1ItemStack.damageItem(1, par2EntityPlayer);
                                                        return true;
                                                    }
                                            }

                                        else
                                            if (i2 == 3)
                                                {
                                                    Block block = EsquireBlocks.EsquireLogBare;
                                                    par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                                                    par2EntityPlayer.inventory.addItemStackToInventory(new ItemStack(EsquireItems.EsquireBark, 1, i2));

                                                    if (par3World.isRemote)
                                                        {
                                                            return true;
                                                        }
                                                    else
                                                        {
                                                            par3World.setBlock(par4, par5, par6, block.blockID, i2, 3);
                                                            par1ItemStack.damageItem(1, par2EntityPlayer);
                                                            return true;
                                                        }
                                                }
                                            else
                                                {
                                                    return false;
                                                }
                            }
                    }
            }

    }
