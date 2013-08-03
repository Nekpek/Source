package nekpek.mod.Naturalis.render;

import nekpek.mod.Naturalis.Entity.EntityNaturalisFish;
import nekpek.mod.Naturalis.models.NaturalisFish;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderNaturalisFish extends RenderLiving

    {

        public RenderNaturalisFish(ModelBase par1ModelBase, float par2)
            {
                super(par1ModelBase, par2);
                model = ((NaturalisFish) mainModel);
            }

        protected NaturalisFish model;

        public void renderNaturalisFish(EntityNaturalisFish entity, double par2, double par4, double par6, float par8, float par9)
            {
                super.doRenderLiving(entity, par2, par4, par6, par8, par9);
            }

        @Override
        public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
            {
                renderNaturalisFish((EntityNaturalisFish) par1EntityLiving, par2, par4, par6, par8, par9);

            }

        @Override
        public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
            {
                renderNaturalisFish((EntityNaturalisFish) par1Entity, par2, par4, par6, par8, par9);

            }

        @Override
        protected ResourceLocation func_110775_a(Entity entity)
            {
                ResourceLocation Naturalis = new ResourceLocation("naturalis", "textures/entity/fish.png");
                return Naturalis;
            }

    }
