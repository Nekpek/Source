package sdc.nekpek.Esquire.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import sdc.nekpek.Esquire.Entities.EsquireEntityFish;
import sdc.nekpek.Esquire.Mobs.EsquireFish;

public class EsquireRenderFish extends RenderLiving

    {

        public EsquireRenderFish(ModelBase par1ModelBase, float par2)
            {
                super(par1ModelBase, par2);
                model = ((EsquireFish) mainModel);
            }

        protected EsquireFish model;

        public void renderEsquireFish(EsquireEntityFish entity, double par2, double par4, double par6, float par8, float par9)
            {
                super.doRenderLiving(entity, par2, par4, par6, par8, par9);
            }

        @Override
        public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
            {
                renderEsquireFish((EsquireEntityFish) par1EntityLiving, par2, par4, par6, par8, par9);

            }

        @Override
        public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
            {
                renderEsquireFish((EsquireEntityFish) par1Entity, par2, par4, par6, par8, par9);

            }

        @Override
        protected ResourceLocation getEntityTexture(Entity entity)
            {
                ResourceLocation Esquire = new ResourceLocation("esquire", "textures/entity/fish.png");
                return Esquire;
            }

    }
