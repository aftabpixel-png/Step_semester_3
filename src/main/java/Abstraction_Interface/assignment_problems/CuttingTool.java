public class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return superUse() + ", blade sharpened first";
    }

    protected String superUse() {
        return "Using the tool in the garden";
    }
}
