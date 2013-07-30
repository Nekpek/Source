package nekpek.mod.Naturalis.item;

import nekpek.mod.Naturalis.common.Naturalis;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemNaturalisScraper extends ItemAxe
    {
        public ItemNaturalisScraper(int par1, EnumToolMaterial par2EnumToolMaterial)
            {
                super(par1, par2EnumToolMaterial);
            }

        @Override
        public void registerIcons(IconRegister iconRegister)
            {
                itemIcon = iconRegister.registerIcon("Naturalis:NaturalisScraper");
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
                        UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);

                        if (MinecraftForge.EVENT_BUS.post(event))
                            {
                                return false;
                            }

                        if (event.getResult() == Result.ALLOW)
                            {
                                par1ItemStack.damageItem(1, par2EntityPlayer);
                                return true;
                            }

                        int i1 = par3World.getBlockId(par4, par5, par6);
                        int i2 = par3World.getBlockMetadata(par4, par5, par6);
                        par3World.getBlockId(par4, par5 + 1, par6);

                        if (i1 != Block.wood.blockID)
                            {
                                return false;
                            }
                        else
                            {
                                if (i2 == 0)
                                    {
                                        Block block = Naturalis.NaturalisOakBare;
                                        par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                                        if (par3World.isRemote == false)
                                            {
                                                EntityItem entityitem = new EntityItem(par3World, par4, par5, par6, new ItemStack(Naturalis.NaturalisRawCork, 1));
                                                entityitem.delayBeforeCanPickup = 10;
                                                par3World.spawnEntityInWorld(entityitem);
                                            }

                                        if (par3World.isRemote)
                                            {
                                                return true;
                                            }
                                        else
                                            {
                                                par3World.setBlock(par4, par5, par6, block.blockID);
                                                par1ItemStack.damageItem(1, par2EntityPlayer);
                                                return true;
                                            }
                                    }
                                else
                                    if (i2 == 2)
                                        {
                                            Block block = Naturalis.NaturalisBirchBare;
                                            par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                                            if (par3World.isRemote == false)
                                                {
                                                    EntityItem entityitem = new EntityItem(par3World, par4, par5, par6, new ItemStack(Naturalis.NaturalisBirchBark, 1));
                                                    entityitem.delayBeforeCanPickup = 10;
                                                    par3World.spawnEntityInWorld(entityitem);
                                                }

                                            if (par3World.isRemote)
                                                {
                                                    return true;
                                                }
                                            else
                                                {
                                                    par3World.setBlock(par4, par5, par6, block.blockID);
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
