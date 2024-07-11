package lithan.training.javawebapp;

import java.util.List;

public class Store {
    public Store(String name, String phoneNumber, List<String> localities) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.localities = localities;
    }
    private String name;
    private String phoneNumber;
    private List<String> localities;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<String> getLocalities() {
        return localities;
    }
    public void setLocalities(List<String> localities) {
        this.localities = localities;
    }
    
    public static boolean deleteStore(List<Store> stores, String storeName) {
        return stores.removeIf(store -> store.getName().equals(storeName));
    }

}
    
    