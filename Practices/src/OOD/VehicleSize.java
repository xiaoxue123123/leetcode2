package OOD;

public enum VehicleSize {
    Large(3),
    Compact(1);

    private final int size;

    VehicleSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
