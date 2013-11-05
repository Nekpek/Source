package sdc.nekpek.Esquire.Mortar;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EsquireMortarModel extends ModelBase
    {
        // fields
        ModelRenderer botton_;
        ModelRenderer connecter_;
        ModelRenderer lower_bowl_;
        ModelRenderer Lower_left_side;
        ModelRenderer Lower_front_side;
        ModelRenderer Lower_right_side_;
        ModelRenderer Lower_Back_side;
        ModelRenderer Left_side_;
        ModelRenderer Right_side;
        ModelRenderer Front_side;
        ModelRenderer Back_side_;

        public EsquireMortarModel()
            {
                textureWidth = 64;
                textureHeight = 32;

                botton_ = new ModelRenderer(this, 1, 1);
                botton_.addBox(-3F, -0.5F, -3F, 6, 1, 6);
                botton_.setRotationPoint(0F, 23.5F, 0F);
                botton_.setTextureSize(64, 32);
                botton_.mirror = true;
                setRotation(botton_, 0F, 0F, 0F);
                connecter_ = new ModelRenderer(this, 1, 9);
                connecter_.addBox(-1.5F, -0.5F, -1.5F, 3, 2, 3);
                connecter_.setRotationPoint(0F, 21.5F, 0F);
                connecter_.setTextureSize(64, 32);
                connecter_.mirror = true;
                setRotation(connecter_, 0F, 0F, 0F);
                lower_bowl_ = new ModelRenderer(this, 27, 1);
                lower_bowl_.addBox(-2F, 0F, -2F, 4, 0, 4);
                lower_bowl_.setRotationPoint(0F, 21F, 0F);
                lower_bowl_.setTextureSize(64, 32);
                lower_bowl_.mirror = true;
                setRotation(lower_bowl_, 0F, 0F, 0F);
                Lower_left_side = new ModelRenderer(this, 44, 1);
                Lower_left_side.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 5);
                Lower_left_side.setRotationPoint(2F, 20.5F, 0F);
                Lower_left_side.setTextureSize(64, 32);
                Lower_left_side.mirror = true;
                setRotation(Lower_left_side, 0F, 0F, 0F);
                Lower_front_side = new ModelRenderer(this, 46, 8);
                Lower_front_side.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1);
                Lower_front_side.setRotationPoint(0F, 20.5F, -2F);
                Lower_front_side.setTextureSize(64, 32);
                Lower_front_side.mirror = true;
                setRotation(Lower_front_side, 0F, 0F, 0F);
                Lower_right_side_ = new ModelRenderer(this, 44, 1);
                Lower_right_side_.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 5);
                Lower_right_side_.setRotationPoint(-2F, 20.5F, 0F);
                Lower_right_side_.setTextureSize(64, 32);
                Lower_right_side_.mirror = true;
                setRotation(Lower_right_side_, 0F, 0F, 0F);
                Lower_Back_side = new ModelRenderer(this, 46, 8);
                Lower_Back_side.addBox(-1.5F, -0.5F, -0.5F, 3, 1, 1);
                Lower_Back_side.setRotationPoint(0F, 20.5F, 2F);
                Lower_Back_side.setTextureSize(64, 32);
                Lower_Back_side.mirror = true;
                setRotation(Lower_Back_side, 0F, 0F, 0F);
                Left_side_ = new ModelRenderer(this, 43, 11);
                Left_side_.addBox(-0.5F, -1.5F, -3F, 1, 3, 6);
                Left_side_.setRotationPoint(2.5F, 18.5F, 0F);
                Left_side_.setTextureSize(64, 32);
                Left_side_.mirror = true;
                setRotation(Left_side_, 0F, 0F, 0F);
                Right_side = new ModelRenderer(this, 43, 11);
                Right_side.addBox(-0.5F, -1.5F, -3F, 1, 3, 6);
                Right_side.setRotationPoint(-2.5F, 18.5F, 0F);
                Right_side.setTextureSize(64, 32);
                Right_side.mirror = true;
                setRotation(Right_side, 0F, 0F, 0F);
                Front_side = new ModelRenderer(this, 30, 6);
                Front_side.addBox(-2F, -1.5F, -0.5F, 4, 3, 1);
                Front_side.setRotationPoint(0F, 18.5F, -2.5F);
                Front_side.setTextureSize(64, 32);
                Front_side.mirror = true;
                setRotation(Front_side, 0F, 0F, 0F);
                Back_side_ = new ModelRenderer(this, 30, 6);
                Back_side_.addBox(-2F, -1.5F, -0.5F, 4, 3, 1);
                Back_side_.setRotationPoint(0F, 18.5F, 2.5F);
                Back_side_.setTextureSize(64, 32);
                Back_side_.mirror = true;
                setRotation(Back_side_, 0F, 0F, 0F);
            }

        @Override
        public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
            {
                super.render(entity, f, f1, f2, f3, f4, f5);
                setRotationAngles(f, f1, f2, f3, f4, f5, entity);
                botton_.render(f5);
                connecter_.render(f5);
                lower_bowl_.render(f5);
                Lower_left_side.render(f5);
                Lower_front_side.render(f5);
                Lower_right_side_.render(f5);
                Lower_Back_side.render(f5);
                Left_side_.render(f5);
                Right_side.render(f5);
                Front_side.render(f5);
                Back_side_.render(f5);
            }

        private void setRotation(ModelRenderer model, float x, float y, float z)
            {
                model.rotateAngleX = x;
                model.rotateAngleY = y;
                model.rotateAngleZ = z;
            }

        @Override
        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
            {

            }

    }
