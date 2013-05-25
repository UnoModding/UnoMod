import java.util.HashMap;
import java.util.Map;


/**
 * PotionEffect.java - Interface to potions Effects, (poison in 1.8.1).
 * @author Talmor
 */
public class PotionEffect {
    public final OPotionEffect potionEffect;

    public enum Type {
        MOVE_SPEED(1), //
        SLOW_DOWN(2), //
        DIG_SPEED(3), //
        DIG_SLOW(4), //
        DAMAGE_BOOST(5), //
        HEAL(6), //
        HARM(7), //
        JUMP(8), //
        CONFUSION(9), //
        REGENERATION(10), //
        RESISTANCE(11), //
        FIRE_RESISTANCE(12), //
        WATER_BREATHING(13), //
        INVISIBILITY(14), //
        BLINDNESS(15), //
        NIGHTVISION(16), //
        HUNGER(17), //
        WEAKNESS(18), //
        POISON(19),
        WITHER(20);

        private int id;
        private static Map<Integer, Type> map;

        Type(int id) {
            this.id = id;
            add(id, this);
        }

        private static void add(int id, Type name) {
            if (map == null) {
                map = new HashMap<Integer, Type>();
            }
            map.put(id, name);
        }

        public int getId() {
            return id;
        }

        public static Type fromId(final int id) {
            return map.get(id);
        }

    }

    /**
     * Instantiated this wrapper around OPotionEffect
     * @param potionEffect the OPotionEffect to wrap
     */
    public PotionEffect(OPotionEffect potionEffect) {
        this.potionEffect = potionEffect;
    }

    /**
     * Creates a new PotionEffect
     *
     * @param effect
     * @param amplifier
     * @param duration
     * @return
     */
    public static PotionEffect getNewPotionEffect(PotionEffect.Type effect, int amplifier, int duration) {
        return new OPotionEffect(effect.getId(), duration, amplifier).potionEffect;
    }

    /**
     * Creates a new PotionEffect
     *
     * @param tag the tag to get the potion effect's data from
     * @return
     */
    public static PotionEffect getNewPotionEffect(NBTTagCompound tag) {
        return OPotionEffect.b(tag.getBaseTag()).potionEffect;
    }

    public PotionEffect.Type getType() {
        return PotionEffect.Type.fromId(potionEffect.a());
    }

    public int getAmplifier() {
        return potionEffect.c();
    }

    public int getDuration() {
        return potionEffect.b();
    }

    public void setType(Type effect) {
        potionEffect.a = effect.getId();
    }

    public void setDuration(int duration) {
        potionEffect.b = duration;
    }

    public void setAmplifier(int amplifier) {
        potionEffect.c = amplifier;
    }

    /**
     * Writes this potion effect's data to an NBTTagCompound
     *
     * @param tag the tag to write to
     * @return the same tag that was passed in, but rewrapped
     */
    public NBTTagCompound writeToTag(NBTTagCompound tag) {
        return new NBTTagCompound(potionEffect.a(tag.getBaseTag()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.potionEffect != null ? this.potionEffect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PotionEffect other = (PotionEffect) obj;
        if (this.potionEffect != other.potionEffect && (this.potionEffect == null || !this.potionEffect.equals(other.potionEffect))) {
            return false;
        }
        return true;
    }
}
