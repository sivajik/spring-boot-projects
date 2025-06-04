package lld.rover;

import lombok.Getter;

public class Plateau {
    @Getter
    private int width;

    @Getter
    private int height;

    public Plateau(int i, int j) {
        this.width = i;
        this.height = j;
    }
    
    public boolean isValid(int i, int j) {
        return i >= 0 && i <= width && j >= 0 && j <= width;
    }
}
