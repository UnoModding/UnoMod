/**
 * Interface for living entities.
 */
public class LivingEntity extends LivingEntityBase {

    /**
     * Interface for living entities
     */
    public LivingEntity() {}

    /**
     * Interface for living entities
     *
     * @param livingEntity
     */
    public LivingEntity(OEntityLiving livingEntity) {
        super(livingEntity);
    }

    /**
     * Returns the entity we're wrapping.
     *
     * @return
     */
    @Override
    public OEntityLiving getEntity() {
        return (OEntityLiving) entity;
    }

    /**
     * Returns the entity's health.
     *
     * @return health
     * @deprecated Health is measured in floats now, use
     * {@link #getHealthFloat()} instead.
     */
    @Deprecated
    public int getHealth() {
        return (int) getHealthFloat();
    }

    /**
     * Increase entity health.
     *
     * @param health
     *            amount of health to increase the players health with.
     * @deprecated Health is measured in floats now, use
     * {@link #increaseHealth(float)} instead.
     */
    @Deprecated
    public void increaseHealth(int health) {
        this.increaseHealth((float) health);
    }

    /**
     * Sets the entity's health. 20 = max health 1 = 1/2 heart 2 = 1 heart
     *
     * @param health The entity's new health.
     * @deprecated Health is measured in floats now, use
     * {@link #setHealth(float)} instead.
     */
    @Deprecated
    public void setHealth(int health) {
        setHealth((float) health);
    }

    /**
     * Get the amount of ticks this entity is dead. 20 ticks per second.
     *
     * @return
     */
    // TODO: pull up
    public int getDeathTicks() {
        // SRG return getEntity().field_70725_aQ;
        return getEntity().aB;
    }

    /**
     * Set the amount of ticks this entity is dead. 20 ticks per second.
     *
     * @param ticks
     */
    // TODO: pull up
    public void setDeathTicks(int ticks) {
        // SRG getEntity().field_70725_aQ = ticks;
        getEntity().aB = ticks;
    }

    /**
     * Get an entities max health value
     * @return max health
     * @deprecated Max health is measured in doubles now, use
     * {@link #getMaxHealthDouble()} instead.
     */
    @Deprecated
    public int getMaxHealth(){
        return (int) getMaxHealthDouble();
    }

    /**
     * Set the entities max health
     * @param toSet max health
     * @deprecated Max health is measured in doubles now, use
     * {@link #setMaxHealth(double)} instead.
     */
    @Deprecated
    public void setMaxHealth(int toSet){
        setMaxHealth(toSet);
    }

    /**
     * Get the amount of ticks this entity will not take damage. (unless it
     * heals) 20 ticks per second.
     *
     * @return
     */
    // TODO: pull up
    public int getBaseNoDamageTicks() {
        // SRG return getEntity().field_70771_an;
        return getEntity().aI;
    }

    /**
     * Get the current maximum damage taken during this NoDamageTime
     *
     * @return
     * @deprecated Damage is measured in floats now, use
     * {@link #getLastDamageFloat()} instead.
     */
    public int getLastDamage() {
        return (int) getLastDamageFloat();
    }

    /**
     * Set the current maximum damage taken during this NoDamageTime (if any
     * damage is higher than this number the difference will be added)
     *
     * @param amount
     * @deprecated Damage is measured in floats now, use
     * {@link #setLastDamage(float)} instead.
     */
    public void setLastDamage(int amount) {
        setLastDamage((float) amount);
    }

    /**
     * Drops this mob's loot. Automatically called if health is set to 0.
     */
    public void dropLoot() {
        // SRG getEntity().func_82160_b(true, 0);
        getEntity().a(true, 0);
    }

    /**
     * Sets the item held by the entity.
     *
     * @param item
     */
    public void setItemInHand(Item item) {
        // SRG getEntity().func_70062_b(0, item.getBaseItem());
        getEntity().c(0, item.getBaseItem());
    }

    /**
     * Gets the item held by the entity.
     *
     * @return
     */
    public Item getItemStackInHand() {
        // SRG OItemStack stack = getEntity().func_70694_bm();
        OItemStack stack = getEntity().aY();
        return stack == null ? null : new Item(stack);
    }

    /**
     * Sets an armor slot of the entity.
     *
     * @param slot
     *             The slot of the armor, 0 being boots and 3 being helmet
     * @param armor
     *             The item of armor to add
     */
    public void setArmorSlot(int slot, Item armor) {
        if(slot >= 0 && slot <= 3) {
            // SRG getEntity().func_70062_b(slot + 1, armor.getBaseItem());
            getEntity().c(slot + 1, armor.getBaseItem());
        }
    }

    /**
     * Gets the item in one of the entity's armor slots.
     *
     * @param slot
     *             The slot of the armor, 0 being boots and 3 being helmet
     * @return
     */
    public Item getArmorSlot(int slot) {
        if(slot < 0 || slot > 3) {
            return null;
        }
        // SRG OItemStack stack = getEntity().func_130225_q(slot);
        OItemStack stack = getEntity().o(slot);
        return stack == null ? null : new Item(stack);
    }

    /**
     * Returns whether or not this entity will despawn naturally.
     *
     * @return
     */
    public boolean isPersistent() {
        // SRG return getEntity().field_82179_bU;
        return getEntity().bt;
    }

    /**
     * Sets whether or not this entity will despawn naturally.
     *
     * @param isPersistent
     */
    public void setPersistent(boolean isPersistent) {
        // SRG getEntity().field_82179_bU = isPersistent;
        getEntity().bt = isPersistent;
    }

    /**
     * Returns the drop chance of an item owned by this entity.
     *
     * @param slot The slot of the item, 0-4: 0 is hand, 1-4 are armor slots (1=boots and 4=helmet)
     * @return The drop chance, 0-1 (anything greater than 1 is guaranteed to drop)
     */
    public float getDropChance(int slot) {
        if(slot >= 0 && slot <= 4) {
            // SRG return getEntity().field_82174_bp[slot];
            return getEntity().e[slot];
        }
        return 0;
    }

    /**
     * Sets the drop chance of an item owned by this entity.
     *
     * @param slot The slot of the item, 0-4: 0 is hand, 1-4 are armor slots (1=boots and 4=helmet)
     * @param chance The drop chance, 0-1 (anything greater than 1 is guaranteed to drop)
     */
    public void setDropChance(int slot, float chance) {
        if(slot >= 0 && slot <= 4) {
            // SRG getEntity().field_82174_bp[slot] = chance;
            getEntity().e[slot] = chance;
        }
    }

    /**
     * Whether or not this entity can pick up items.
     *
     * @return
     */
    public boolean canPickUpLoot() {
        // SRG return getEntity().func_98052_bS();
        return getEntity().bD();
    }

    /**
     * Sets whether or not this entity can pick up items.
     *
     * @param flag
     */
    public void setCanPickUpLoot(boolean flag) {
        // SRG getEntity().func_98053_h(flag);
        getEntity().h(flag);
    }

    /**
     * Damages this entity, taking into account armor/enchantments/potions
     *
     * @param type The type of damage to deal (certain types byass armor or affect potions differently)
     * @param amount The amount of damage to deal (2 = 1 heart)
     * @deprecated use applyDamage(DamageType, int)
     */
    @Deprecated
    public void applyDamage(PluginLoader.DamageType type, int amount) {
        applyDamage(type.getDamageSource().damageSource, (float) amount);
    }

    /**
     * Damages this entity, taking into account armor/enchantments/potions
     * @param type
     * @param amount
     * @deprecated Damage is measured in floats now. Use
     * {@link #applyDamage(DamageType, float)} instead.
     */
    @Deprecated
    public void applyDamage(DamageType type, int amount) {
        applyDamage(type.getDamageSource(), (float) amount);
    }

    /**
     * Damages this entity, taking into account armor/enchantments/potions
     * @param source
     * @param amount
     * @deprecated Damage is measured in floats now, use
     * {@link #applyDamage(DamageSource, float)} instead.
     */
    @Deprecated
    public void applayDamage(DamageSource source, int amount) {
        applyDamage(source, (float) amount);
    }

    /**
     * Damages this entity, taking into account armor/enchantments/potions
     * @param source
     * @param amount
     */
    // TODO: pull up
    public void applyDamage(DamageSource source, float amount) {
        // SRG getEntity().func_70665_d(source.getDamageSource(), amount);
        getEntity().d(source.getDamageSource(), amount);
    }

    /**
     * Returns this entity's custom name.
     * @return This entity's custom name if it has one, an empty string otherwise
     */
    public String getCustomName() {
        // SRG return getEntity().func_94057_bL();
        return getEntity().bA();
    }

    /**
     * Sets this entity's custom name.
     * @param name This entity's new custom name
     */
    public void setCustomName(String name) {
        // SRG getEntity().func_94058_c(name);
        getEntity().a(name);
    }

    /**
     * Returns whether this entity has a custom name.
     * @return <tt>true</tt> if this entity has a custom name, <tt>false</tt>
     * otherwise.
     */
    public boolean hasCustomName() {
        // SRG return getEntity().func_94056_bM();
        return getEntity().bB();
    }

    /**
     * Returns whether a possible custom name is shown on this entity.
     * @return <tt>true</tt> if a possible custom name is shown, <tt>false</tt>
     * otherwise.
     */
    public boolean isCustomNameVisible() {
        // SRG return getEntity().func_94062_bN();
        return getEntity().bC();
    }

    /**
     * Sets whether a possible custom name is shown on this entity.
     * @param visible <tt>true</tt> to show a possible custom name,
     * <tt>false</tt> to hide it.
     */
    public void setCustomNameVisible(boolean visible) {
        // SRG getEntity().func_94061_f(visible);
        getEntity().g(visible);
    }
}
