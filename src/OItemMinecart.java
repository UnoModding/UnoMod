public class OItemMinecart extends OItem {
    public int a;

    public OItemMinecart(int paramInt1, int paramInt2) {
        super(paramInt1);
        be = 1;
        a = paramInt2;
    }

    @Override
    public boolean a(OItemStack paramOItemStack, OEntityPlayer paramOEntityPlayer, OWorld paramOWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramOWorld.a(paramInt1, paramInt2, paramInt3);

        if (i == OBlock.aG.bl) {
            if (!paramOWorld.t)
                paramOWorld.a(new OEntityMinecart(paramOWorld, paramInt1 + 0.5F, paramInt2 + 0.5F, paramInt3 + 0.5F, a));
            paramOItemStack.a -= 1;
            return true;
        }
        return false;
    }
}