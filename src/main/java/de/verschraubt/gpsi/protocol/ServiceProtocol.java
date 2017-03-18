package de.verschraubt.gpsi.protocol;

import com.google.common.base.Preconditions;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by Verschraubt on 16.03.2017 for GlobalPlayerServiceInterface.
 */
public abstract class ServiceProtocol {


    private final String protocolId;
    private final JSONObject data;
    private final UUID receiverServiceId;


    public ServiceProtocol(String protocolId, UUID receiverServiceId, JSONObject data) {
        Preconditions.checkNotNull(protocolId, "The protocolId cannot be null");
        Preconditions.checkNotNull(data, "The data cannotb be null");
        Preconditions.checkArgument(protocolId.length() == 10, "The length of the id is not ten.");
        Preconditions.checkNotNull(receiverServiceId, "The serviceId(s) cannot be null");

        this.data = data;
        this.receiverServiceId = receiverServiceId;
        this.protocolId = protocolId;
    }

    public ServiceProtocol(JSONObject data, UUID receiverServiceId) {
        this(UUID.randomUUID().toString().substring(0, 10), receiverServiceId, data);
    }

    public JSONObject getData() {
        return data;
    }

    public String getProtocolId() {
        return protocolId;
    }

    public UUID getReceiverServiceId() {
        return receiverServiceId;
    }

    public abstract void handle(JSONObject data);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceProtocol that = (ServiceProtocol) o;

        if (protocolId != null ? !protocolId.equals(that.protocolId) : that.protocolId != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return receiverServiceId != null ? receiverServiceId.equals(that.receiverServiceId) : that.receiverServiceId == null;
    }

    @Override
    public int hashCode() {
        int result = protocolId != null ? protocolId.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (receiverServiceId != null ? receiverServiceId.hashCode() : 0);
        return result;
    }
}
