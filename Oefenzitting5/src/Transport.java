import be.kuleuven.cs.som.annotate.*;

/**
 * An enum class containing the means of transport.
 *
 * @author Flor De Meulemeester
 * @version 1.0
 */
public enum Transport {
    BIKE("bike"), TRAIN("train"), CAR("car");

    private final String transport;

    Transport(String transport) {
        this.transport = transport;
    }

    @Basic
    public String getTransport() {
        return transport;
    }
}
