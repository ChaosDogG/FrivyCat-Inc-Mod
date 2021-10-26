package chaosdog.frivycat.entities.passive;

/*public class PigperEntity extends PigEntity{
    private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(PigperEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.createKey(PigperEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(PigperEntity.class, DataSerializers.BOOLEAN);
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 3;
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.GUNPOWDER);
    private final BoostHelper field_234214_bx_ = new BoostHelper(this.dataManager, BOOST_TIME, SADDLED);

    public PigperEntity(EntityType<? extends PigEntity> entity, World world) {
        super(entity, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.fromItems(Items.TNT), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }*/


    /*@Nullable
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }*/


/*
    @Override
    public boolean canBeSteered() {
        Entity entity = this.getControllingPassenger();
        if (!(entity instanceof PlayerEntity)) {
            return false;
        } else {
            PlayerEntity playerentity = (PlayerEntity)entity;
            return playerentity.getHeldItemMainhand().getItem() == Items.TNT || playerentity.getHeldItemOffhand().getItem() == Items.TNT;
        }
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        if (BOOST_TIME.equals(key) && this.world.isRemote) {
            this.field_234214_bx_.updateData();
        }

        super.notifyDataManagerChange(key);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SADDLED, false);
        this.dataManager.register(BOOST_TIME, 0);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.field_234214_bx_.setSaddledToNBT(compound);
    }


    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.field_234214_bx_.setSaddledFromNBT(compound);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CREEPER_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    public ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
        boolean flag = this.isBreedingItem(playerIn.getHeldItem(hand));
        ItemStack itemstack = playerIn.getHeldItem(hand);
        if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            this.world.playSound(playerIn, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
            if (!this.world.isRemote) {
                this.ignite();
                itemstack.damageItem(1, playerIn, (player) -> {
                    player.sendBreakAnimation(hand);
                });
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.getEntityInteractionResult(playerIn, hand);
        }
        if (!flag && this.isHorseSaddled() && !this.isBeingRidden() && !playerIn.isSecondaryUseActive()) {
            if (!this.world.isRemote) {
                playerIn.startRiding(this);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            ActionResultType actionresulttype = super.getEntityInteractionResult(playerIn, hand);
            if (!actionresulttype.isSuccessOrConsume()) {
                ItemStack itemstack = playerIn.getHeldItem(hand);
                return itemstack.getItem() == Items.SADDLE ? itemstack.interactWithEntity(playerIn, this, hand) : ActionResultType.PASS;
            } else {
                return actionresulttype;
            }
        }
    }

    @Override
    public boolean func_230264_L__() {
        return this.isAlive() && !this.isChild();
    }

    @Override
    protected void dropInventory() {
        super.dropInventory();
        if (this.isHorseSaddled()) {
            this.entityDropItem(Items.SADDLE);
        }

    }

    @Override
    public boolean isHorseSaddled() {
        return this.field_234214_bx_.getSaddled();
    }

    @Override
    public void func_230266_a_(@Nullable SoundCategory p_230266_1_) {
        this.field_234214_bx_.setSaddledFromBoolean(true);
        if (p_230266_1_ != null) {
            this.world.playMovingSound((PlayerEntity)null, this, SoundEvents.ENTITY_PIG_SADDLE, p_230266_1_, 0.5F, 1.0F);
        }

    }

    @Override
    public Vector3d getDismountPosition(LivingEntity livingEntity) {
        Direction direction = this.getAdjustedHorizontalFacing();
        if (direction.getAxis() == Direction.Axis.Y) {
            return super.getDismountPosition(livingEntity);
        } else {
            int[][] aint = TransportationHelper.func_234632_a_(direction);
            BlockPos blockpos = this.getPosition();
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for(Pose pose : livingEntity.getAvailablePoses()) {
                AxisAlignedBB axisalignedbb = livingEntity.getPoseAABB(pose);

                for(int[] aint1 : aint) {
                    blockpos$mutable.setPos(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
                    double d0 = this.world.func_242403_h(blockpos$mutable);
                    if (TransportationHelper.func_234630_a_(d0)) {
                        Vector3d vector3d = Vector3d.copyCenteredWithVerticalOffset(blockpos$mutable, d0);
                        if (TransportationHelper.func_234631_a_(this.world, livingEntity, axisalignedbb.offset(vector3d))) {
                            livingEntity.setPose(pose);
                            return vector3d;
                        }
                    }
                }
            }

            return super.getDismountPosition(livingEntity);
        }
    }

    @Override
    public void causeLightningStrike(ServerWorld world, LightningBoltEntity lightning) {
        if (world.getDifficulty() != Difficulty.PEACEFUL && net.minecraftforge.event.ForgeEventFactory.canLivingConvert(this, EntityType.ZOMBIFIED_PIGLIN, (timer) -> {})) {
            ZombifiedPiglinEntity zombifiedpiglinentity = EntityType.ZOMBIFIED_PIGLIN.create(world);
            zombifiedpiglinentity.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            zombifiedpiglinentity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
            zombifiedpiglinentity.setNoAI(this.isAIDisabled());
            zombifiedpiglinentity.setChild(this.isChild());
            if (this.hasCustomName()) {
                zombifiedpiglinentity.setCustomName(this.getCustomName());
                zombifiedpiglinentity.setCustomNameVisible(this.isCustomNameVisible());
            }

            zombifiedpiglinentity.enablePersistence();
            net.minecraftforge.event.ForgeEventFactory.onLivingConvert(this, zombifiedpiglinentity);
            world.addEntity(zombifiedpiglinentity);
            this.remove();
        } else {
            super.causeLightningStrike(world, lightning);
        }

    }

    @Override
    public void travel(Vector3d travelVector) {
        this.ride(this, this.field_234214_bx_, travelVector);
    }

    @Override
    public float getMountedSpeed() {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 0.225F;
    }

    /*@Override
    public void travelTowards(Vector3d travelVec) {
        super.travel(travelVec);
    }

    @Override
    public boolean boost() {
        return this.field_234214_bx_.boost(this.getRNG());
    }

    @Override
    public PigEntity createChild(ServerWorld world, AgeableEntity mate) {
        return ModEntityTypes.PIGPER.get().create(world);
    }*/


/*
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return TEMPTATION_ITEMS.test(stack);
    }


    @Override
    public Vector3d getLeashStartPosition() {
        return new Vector3d(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
    }

    protected ActionResultType getEntityInteractionResult(PlayerEntity playerIn, Hand hand) {
        ItemStack itemstack = playerIn.getHeldItem(hand);
        if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            this.world.playSound(playerIn, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, this.getSoundCategory(), 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
            if (!this.world.isRemote) {
                this.ignite();
                itemstack.damageItem(1, playerIn, (player) -> {
                    player.sendBreakAnimation(hand);
                });
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.getEntityInteractionResult(playerIn, hand);
        }
    }*/


    /*
    private void explode() {
        if (!this.world.isRemote) {
            Explosion.Mode explosion$mode = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this) ? Explosion.Mode.DESTROY : Explosion.Mode.NONE;
            this.dead = true;
            this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), (float)this.explosionRadius, explosion$mode);
            this.remove();
            this.spawnLingeringCloud();
        }

    }

    private void spawnLingeringCloud() {
        Collection<EffectInstance> collection = this.getActivePotionEffects();
        if (!collection.isEmpty()) {
            AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
            areaeffectcloudentity.setRadius(2.5F);
            areaeffectcloudentity.setRadiusOnUse(-0.5F);
            areaeffectcloudentity.setWaitTime(10);
            areaeffectcloudentity.setDuration(areaeffectcloudentity.getDuration() / 2);
            areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float)areaeffectcloudentity.getDuration());

            for(EffectInstance effectinstance : collection) {
                areaeffectcloudentity.addEffect(new EffectInstance(effectinstance));
            }

            this.world.addEntity(areaeffectcloudentity);
        }

    }

    public boolean hasIgnited() {
        return this.dataManager.get(IGNITED);
    }

    public void ignite() {
        this.dataManager.set(IGNITED, true);
    }
}*/
