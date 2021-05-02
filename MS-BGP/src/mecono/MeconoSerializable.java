package mecono;

import node.BadSerializationException;
import org.json.JSONObject;
import org.json.JSONString;

public interface meconoSerializable {
	public JSONObject serialize();
	public void deserialize(JSONObject json) throws BadSerializationException;
}
