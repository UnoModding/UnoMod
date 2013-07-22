/**
 * Wrap around an OEntityWolf to provide extra methods not available to anything but wolves.
 *
 * @author Brian McCarthy
 *
 */
public class Wolf extends TamableEntity {

    /**
     * Basic wolf constructor.
     *
     * @param entity An instance of OEntityWolf to wrap around.
     */
    public Wolf(OEntityWolf entity) {
        super(entity);
    }

    /**
     * If this wolf is angry.
     *
     * @return Boolean of if this wolf is angry.
     */
    public boolean isAngry() {
        // SRG return getEntity().func_70919_bu();
        return getEntity().cc();
    }

    /**
     * Sets if this wolf is angry of not.
     *
     * @param angry New angry state of the wolf.
     */
    public void setAngry(boolean angry) {
        // SRG getEntity().func_70916_h(angry);
        getEntity().l(angry);
    }

    /**
     * Gets this wolf's collar colour.
     *
     * @return collar colour as an int
     */
    public int getCollarColour() {
        // SRG return getEntity().func_82186_bH();
        return getEntity().cd();
    }

    /**
     * Sets this wolf's collar colour.
     *
     * @param colour new collar colour
     */
    public void setCollarColour(int colour) {
        // SRG getEntity().func_82185_r(colour);
        getEntity().p(colour);
    }

    @Override
    public OEntityWolf getEntity() {
        return (OEntityWolf) entity;
    }

}
