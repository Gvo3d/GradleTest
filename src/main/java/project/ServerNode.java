package project;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.Map;

/**
 * Created by Gvozd on 22.07.2017.
 */
public class ServerNode {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        Map<Long, String> map = hazelcastInstance.getMap("data");
        IdGenerator idGenerator = hazelcastInstance.getIdGenerator("newid");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "message" + 1);
        }
    }
}