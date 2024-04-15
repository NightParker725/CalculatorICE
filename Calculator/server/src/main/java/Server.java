public class Server {
    public static void main(String[] args) {
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "server.config")) {
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("services");
            com.zeroc.Ice.Object object = new CalculatorI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("SimpleCalculator"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}
