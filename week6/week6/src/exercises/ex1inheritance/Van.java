package exercises.ex1inheritance;

public class Van  extends Vehicle{
    private double maxCargo;

    public Van(Person owner,String id, double maxCargo) {
        super(owner, id);
        this.maxCargo = maxCargo;
    }

    @Override
    public String toString() {
        return "Van{" + "maxCargo=" + maxCargo + "{owner=" + getOwner() + ", id='" + getId() +"'}}";
    }

    // TODO
}
