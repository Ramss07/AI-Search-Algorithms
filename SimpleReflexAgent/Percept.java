
public class Percept {
    private int location; 
    private boolean isDirty; 

    public Percept(int location, boolean isDirty) {
        this.location = location;
        this.isDirty = isDirty;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean isDirty) {
        this.isDirty = isDirty;
    }
}
