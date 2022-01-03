package chaosdog.frivycat.entities.hostile;

/*public class IllusionerLadyEntity extends SpellcastingIllagerEntity implements IRangedAttackMob {
    private int ghostTime;
    private final Vector3d[][] renderLocations;

    public IllusionerLadyEntity(EntityType<? extends IllusionerLadyEntity> type, World worldIn){
        super(type, worldIn);
        this.experienceValue = 5;
        this.renderLocations = new Vector3d[2][4];

        for(int i = 0; i < 4; ++i) {
            this.renderLocations[0][i] = Vector3d.ZERO;
            this.renderLocations[1][i] = Vector3d.ZERO;
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new SpellcastingIllagerEntity.CastingASpellGoal());
        this.goalSelector.addGoal(4, new IllusionerLadyEntity.MirrorSpellGoal());
        this.goalSelector.addGoal(5, new IllusionerLadyEntity.BlindnessSpellGoal());
        this.goalSelector.addGoal(6, new RangedBowAttackGoal<>(this, 0.5D, 20, 15.0F));
        this.goalSelector.addGoal(8, new RandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, AbstractRaiderEntity.class)).setCallsForHelp());
        this.targetSelector.addGoal(2, (new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true)).setUnseenMemoryTicks(300));
        this.targetSelector.addGoal(3, (new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false)).setUnseenMemoryTicks(300));
        this.targetSelector.addGoal(3, (new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, false)).setUnseenMemoryTicks(300));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MonsterEntity.func_234295_eP_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
                .createMutableAttribute(Attributes.FOLLOW_RANGE, 18.0D)
                .createMutableAttribute(Attributes.MAX_HEALTH, 32.0D);
    }

    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    protected void registerData() {
        super.registerData();
    }

    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return this.getBoundingBox().grow(3.0D, 0.0D, 3.0D);
    }

    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote && this.isInvisible()) {
            --this.ghostTime;
            if (this.ghostTime < 0) {
                this.ghostTime = 0;
            }

            if (this.hurtTime != 1 && this.ticksExisted % 1200 != 0) {
                if (this.hurtTime == this.maxHurtTime - 1) {
                    this.ghostTime = 3;

                    for(int k = 0; k < 4; ++k) {
                        this.renderLocations[0][k] = this.renderLocations[1][k];
                        this.renderLocations[1][k] = new Vector3d(0.0D, 0.0D, 0.0D);
                    }
                }
            } else {
                this.ghostTime = 3;
                float f = -6.0F;
                int i = 13;

                for(int j = 0; j < 4; ++j) {
                    this.renderLocations[0][j] = this.renderLocations[1][j];
                    this.renderLocations[1][j] = new Vector3d((double)(-6.0F + (float)this.rand.nextInt(13)) * 0.5D, (double)Math.max(0, this.rand.nextInt(6) - 4), (double)(-6.0F + (float)this.rand.nextInt(13)) * 0.5D);
                }

                for(int l = 0; l < 16; ++l) {
                    this.world.addParticle(ParticleTypes.CLOUD, this.getPosXRandom(0.5D), this.getPosYRandom(), this.getPosZWidth(0.5D), 0.0D, 0.0D, 0.0D);
                }

                this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_ILLUSIONER_MIRROR_MOVE, this.getSoundCategory(), 1.0F, 1.0F, false);
            }
        }

    }

    public SoundEvent getRaidLossSound() {
        return SoundEvents.ENTITY_ILLUSIONER_AMBIENT;
    }

    @OnlyIn(Dist.CLIENT)
    public Vector3d[] getRenderLocations(float p_193098_1_) {
        if (this.ghostTime <= 0) {
            return this.renderLocations[1];
        } else {
            double d0 = (double)(((float)this.ghostTime - p_193098_1_) / 3.0F);
            d0 = Math.pow(d0, 0.25D);
            Vector3d[] avector3d = new Vector3d[4];

            for(int i = 0; i < 4; ++i) {
                avector3d[i] = this.renderLocations[1][i].scale(1.0D - d0).add(this.renderLocations[0][i].scale(d0));
            }

            return avector3d;
        }
    }

    public boolean isOnSameTeam(Entity entityIn) {
        if (super.isOnSameTeam(entityIn)) {
            return true;
        } else if (entityIn instanceof LivingEntity && ((LivingEntity)entityIn).getCreatureAttribute() == CreatureAttribute.ILLAGER) {
            return this.getTeam() == null && entityIn.getTeam() == null;
        } else {
            return false;
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ILLUSIONER_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ILLUSIONER_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_ILLUSIONER_HURT;
    }

    protected SoundEvent getSpellSound() {
        return SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL;
    }

    public void applyWaveBonus(int wave, boolean p_213660_2_) {
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack itemstack = this.findAmmo(this.getHeldItem(ProjectileHelper.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.item.BowItem)));
        AbstractArrowEntity abstractarrowentity = ProjectileHelper.fireArrow(this, itemstack, distanceFactor);
        if (this.getHeldItemMainhand().getItem() instanceof net.minecraft.item.BowItem)
            abstractarrowentity = ((net.minecraft.item.BowItem)this.getHeldItemMainhand().getItem()).customArrow(abstractarrowentity);
        double d0 = target.getPosX() - this.getPosX();
        double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
        double d2 = target.getPosZ() - this.getPosZ();
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        abstractarrowentity.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(abstractarrowentity);
    }

    @OnlyIn(Dist.CLIENT)
    public AbstractIllagerEntity.ArmPose getArmPose() {
        if (this.isSpellcasting()) {
            return AbstractIllagerEntity.ArmPose.SPELLCASTING;
        } else {
            return this.isAggressive() ? AbstractIllagerEntity.ArmPose.BOW_AND_ARROW : AbstractIllagerEntity.ArmPose.CROSSED;
        }
    }

    class BlindnessSpellGoal extends SpellcastingIllagerEntity.UseSpellGoal {
        private int lastTargetId;

        private BlindnessSpellGoal() {
        }

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else if (IllusionerLadyEntity.this.getAttackTarget() == null) {
                return false;
            } else if (IllusionerLadyEntity.this.getAttackTarget().getEntityId() == this.lastTargetId) {
                return false;
            } else {
                return IllusionerLadyEntity.this.world.getDifficultyForLocation(IllusionerLadyEntity.this.getPosition()).isHarderThan((float) Difficulty.NORMAL.ordinal());
            }
        }

        public void startExecuting() {
            super.startExecuting();
            this.lastTargetId = IllusionerLadyEntity.this.getAttackTarget().getEntityId();
        }

        protected int getCastingTime() {
            return 20;
        }

        protected int getCastingInterval() {
            return 180;
        }

        protected void castSpell() {
            IllusionerLadyEntity.this.getAttackTarget().addPotionEffect(new EffectInstance(Effects.BLINDNESS, 400));
        }

        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_ILLUSIONER_PREPARE_BLINDNESS;
        }

        protected SpellcastingIllagerEntity.SpellType getSpellType() {
            return SpellcastingIllagerEntity.SpellType.BLINDNESS;
        }
    }

    class MirrorSpellGoal extends SpellcastingIllagerEntity.UseSpellGoal {
        private MirrorSpellGoal() {
        }

        public boolean shouldExecute() {
            if (!super.shouldExecute()) {
                return false;
            } else {
                return !IllusionerLadyEntity.this.isPotionActive(Effects.INVISIBILITY);
            }
        }

        protected int getCastingTime() {
            return 20;
        }

        protected int getCastingInterval() {
            return 340;
        }

        protected void castSpell() {
            IllusionerLadyEntity.this.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 1200));
        }

        @Nullable
        protected SoundEvent getSpellPrepareSound() {
            return SoundEvents.ENTITY_ILLUSIONER_PREPARE_MIRROR;
        }

        protected SpellcastingIllagerEntity.SpellType getSpellType() {
            return SpellcastingIllagerEntity.SpellType.DISAPPEAR;
        }
    }
}*/
