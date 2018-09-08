package joaogouveia89.github.io.testedeperformance.model.enums;

public enum Algorithm {
    BUBBLE_SORT(1),
    QUICK_SORT(2),
    VIEW_CASCADE(3);

    private int id;

    Algorithm(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
