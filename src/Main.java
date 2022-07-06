public class Main {
    public static void main(String[] args) {

        int width = 100;
        int height = 50;

        double x0 = (width / 2);
        double y0 = (height / 2);
        double scale = 10;
        double lenghtX0 = 2 * scale;
        double lenghtY0 = 1 * scale;
        ConsolDraw c = new ConsolDraw(width, height);
        Complex z;
        c.clsBorder();
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / lenghtX0;
                double y = (j - y0) / lenghtY0;
                z = new Complex(x, y);

                int color = getColor(z);

                c.draw64Color(i, j, color - 192);
                // c.draw16Color(i, j, color-240);

            }
        }
        c.show();
    }

    private static int getColor(Complex z0) {
        Complex z = z0;
        for (int i = 255; i > 1; i--) {
            if (z.abs() > 2) {

                return i;
            }
            z = z.mul(z).add(z0);

        }
        return 0;
    }


}