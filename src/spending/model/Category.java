package spending.model;

import javafx.scene.control.Button;

public class Category extends Button {
    private long costs;

    public long getCosts() { return costs; }

    public void setCosts(Long newCosts){
        this.costs = newCosts;
    }
}
