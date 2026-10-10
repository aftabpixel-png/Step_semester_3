public class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return id + " flying with a delivery";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}
