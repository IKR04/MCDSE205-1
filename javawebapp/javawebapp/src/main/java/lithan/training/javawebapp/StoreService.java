package lithan.training.javawebapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    @Autowired
    private StoreDAO storeDAO;

    public void addStore(Store store) {
        storeDAO.addStore(store);
    }

    public List<Store> getStores() {
        return storeDAO.getStores();
    }

    public boolean deleteStore(String storeName) {
        List<Store> stores = storeDAO.getStores();
        for (Store store : stores) {
            if (store.getName().equals(storeName)) {
                storeDAO.deleteStore(store);
                return true;
            }
        }
        return false;
    }
}
