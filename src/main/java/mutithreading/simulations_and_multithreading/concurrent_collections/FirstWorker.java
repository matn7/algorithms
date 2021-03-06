package mutithreading.simulations_and_multithreading.concurrent_collections;

import java.util.concurrent.ConcurrentMap;

public class FirstWorker implements Runnable {

    private ConcurrentMap<String, Integer> map;

    public FirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.map.put("A", 1);
        this.map.put("B", 2);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
