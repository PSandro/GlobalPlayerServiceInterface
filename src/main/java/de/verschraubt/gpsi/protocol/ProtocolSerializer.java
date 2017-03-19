package de.verschraubt.gpsi.protocol;

import com.google.common.base.Preconditions;
import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.util.UUID;

/**
 * Created by Verschraubt on 18.03.2017 for GlobalPlayerServiceInterface.
 */
public class ProtocolSerializer {

    public JSONObject serialize(ServiceProtocol serviceProtocol) {
        Preconditions.checkNotNull(serviceProtocol, "The serviceProtocol cannot be null");
        return new JSONObject()
                .put("protocolId", serviceProtocol.getProtocolId())
                .put("data", serviceProtocol.getData())
                .put("serviceId", serviceProtocol.getReceiverServiceId().toString())
                .put("className", serviceProtocol.getClass().getSimpleName());
    }

    public ServiceProtocol deserialize(JSONObject jsonObject) throws Exception {
        Preconditions.checkArgument(jsonObject.has("protocolId"), "The jsonObject does not contain the field `id`");
        Preconditions.checkArgument(jsonObject.has("data"), "The jsonObject does not contain the field `data`");
        Preconditions.checkArgument(jsonObject.has("serviceId"), "The jsonObject does not contain the field `serviceId`");
        Preconditions.checkArgument(jsonObject.has("className"), "The jsonObject does not contain the field `className`");
        String protocolId = jsonObject.getString("protocolId");
        JSONObject data = jsonObject.getJSONObject("data");
        UUID serviceId = UUID.fromString(jsonObject.getString("serviceId"));
        String className = jsonObject.getString("className");

        Class<? extends ServiceProtocol> protocolClass = (Class<? extends ServiceProtocol>) Class.forName(className);
        Constructor constructor = protocolClass.getConstructor(String.class, UUID.class, JSONObject.class);
        return (ServiceProtocol) constructor.newInstance(protocolId, serviceId, data);
    }

}
