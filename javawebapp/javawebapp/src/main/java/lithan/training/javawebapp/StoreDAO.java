package lithan.training.javawebapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {

    private final List<Store> stores = new ArrayList<>();

    public void addStore(Store store) {
        stores.add(store);
    }

    public List<Store> getStores() {
        return new ArrayList<>(stores); 
    }

    public void deleteStore(Store store) {
        stores.remove(store);
    }

    public Store findStoreByName(String storeName) {
        for (Store store : stores) {
            if (store.getName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }
}
