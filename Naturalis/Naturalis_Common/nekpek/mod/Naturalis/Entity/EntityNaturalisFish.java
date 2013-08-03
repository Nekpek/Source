package nekpek.mod.Naturalis.Entity;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityNaturalisFish extends EntityWaterMob
    {

        private float randomMotionVecX;
        private float randomMotionVecY;
        private float randomMotionVecZ;
        private float randomMotionSpeed;

        public EntityNaturalisFish(World par1World)
            {
                super(par1World);
                this.motionX = 0.0F;
                this.motionY = 0.0F;
                this.motionZ = 0.0F;
                this.randomMotionSpeed = 1.0F;

                // this.texture = "Naturalis/NaturalisFish.png";

            }

        @Override
        protected String getLivingSound()
            {
                return null;
            }

        @Override
        protected String getHurtSound()
            {
                return null;
            }

        @Override
        protected String getDeathSound()
            {
                return null;
            }

        @Override
        protected int getDropItemId()
            {
                return Item.fishRaw.itemID;
            }

        @Override
        protected void updateEntityActionState()
            {
                ++this.entityAge;

                if (this.entityAge > 40)
                    {
                        this.randomMotionVecX = this.randomMotionVecY = this.randomMotionVecZ = 0.0F;
                    }
                else
                    if (this.rand.nextInt(50) == 0 || !this.inWater || this.randomMotionVecX == 0.0F && this.randomMotionVecY == 0.0F && this.randomMotionVecZ == 0.0F)
                        {
                            float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
                            // this.randomMotionVecX = MathHelper.cos(f) * 0.2F;
                            this.randomMotionVecY = -0.1F + this.rand.nextFloat() * 0.2F;
                            this.randomMotionVecZ = MathHelper.sin(f) * 0.2F;
                        }

                this.despawnEntity();
            }

        @Override
        public void onLivingUpdate()
            {
                super.onLivingUpdate();

                if (this.isInWater())
                    {
                        float f;

                        if (!this.worldObj.isRemote)
                            {
                                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
                            }

                        f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                        this.renderYawOffset += (-((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.1F;
                        this.rotationYaw = this.renderYawOffset;
                    }
                else
                    {
                        if (!this.worldObj.isRemote)
                            {
                                this.motionX = 0.0D;
                                this.motionY -= 0.8D;
                                this.motionZ = 0.0D;
                            }

                    }
            }

        @Override
        public void moveEntityWithHeading(float par1, float par2)
            {
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
            }
    }
