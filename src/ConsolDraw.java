public class ConsolDraw {
    private static boolean borderOn = false;
    private int x;
    private int y;
    private char[][] consoleMatrix;

    public ConsolDraw(int x, int y) {
        borderOn = false;
        this.x = x;
        this.y = y;
        this.consoleMatrix = new char[x][y];
        cls();
    }

    public void show() {
        String screen = "";
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                screen += consoleMatrix[xi][yi];
            }
            screen += "\n";
        }
        System.out.print(screen);
    }

    public void drawChar(int xChar, int yChar, char setChar) {
        if (borderOn) {
            if (xChar < x - 1 && xChar > 0 && yChar < y - 1 && yChar > 0) {
                consoleMatrix[xChar][yChar] = setChar;
            }
        } else if (xChar < x && xChar > -1 && yChar < y && yChar > -1) {
            consoleMatrix[xChar][yChar] = setChar;
        }
    }

    public void drawChar(int xChar, int yChar, int colorChar) {

        char setChar = ' ';
        switch (colorChar) {
            case (1):
                setChar = '░';
                break;
            case (2):
                setChar = '▒';
                break;
            case (3):
                setChar = '▓';
                break;
            case (4):
                setChar = '█';
                break;
        }

        drawChar(xChar, yChar, setChar);
    }

    public void cls() {
        borderOn = false;
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                consoleMatrix[xi][yi] = ' ';
            }
        }
    }

    public void border() {
        for (int yi = 0; yi < y; yi++) {
            consoleMatrix[0][yi] = '│';
            consoleMatrix[x - 1][yi] = '│';
        }
        for (int xi = 0; xi < x; xi++) {
            consoleMatrix[xi][0] = '─';
            consoleMatrix[xi][y - 1] = '─';
        }
        consoleMatrix[0][0] = '┌';
        consoleMatrix[x - 1][y - 1] = '┘';
        consoleMatrix[0][y - 1] = '└';
        consoleMatrix[x - 1][0] = '┐';
        borderOn = true;
    }

    public void clsBorder() {
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                consoleMatrix[xi][yi] = ' ';
            }
        }
        border();
    }
}
