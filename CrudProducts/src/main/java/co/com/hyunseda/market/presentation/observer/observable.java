package co.com.hyunseda.market.presentation.observer;

import java.util.ArrayList;
import java.util.List;

public class observable {
    List<IOberver> listObservers;
    public void addObserver(IOberver oberver){
        if (listObservers==null){
            listObservers = new ArrayList<>();
        }
        listObservers.add(oberver);
    }
    public void notifyAllObservers(){
        for (IOberver obs:listObservers){
            obs.update();
        }
    }
}
