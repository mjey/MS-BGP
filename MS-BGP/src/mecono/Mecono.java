package mecono;

public class mecono {
    private Endpoints endpoints;
    private void start() {
        ve = new VirtualEnvironment();
        ve.setNodeCount(100);
        ve.runSim();
        ve.printSelfList();
        endpoints = new Endpoints(ve.getSelfList().get(5));
    }
    private void stop() {
        System.out.println("Java ISP stopping");
        endpoints.stopServer();
        ve.stopSim();
    }
    public static void main(String[] args) {
        (new mecono()).start();
    }
    public static String getVersionString() {
        return "v" + PROTOCOL_VERSION + "." + IMPLEMENTATION_VERSION;
    }
    // The implementation version is the current state of the software that interacts with the underlying protocol
    // This includes GUI, simulations, data organization techniques, etc.
    public static final int IMPLEMENTATION_VERSION = 1;
    // The protocol version is the current state of the underlying protocol that connects with other nodes
    // If this is different from another node, they will not be able to communicate at all
    public static final int PROTOCOL_VERSION = 2;
    private VirtualEnvironment ve;
}