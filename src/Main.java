public class Main {
    public static void main(String[] args) {

        int width = 100;
        int height = 50;

        int x0 = (width / 2);
        int y0 = (height / 2);
        double lenghtX0 = 20.0;
        double lenghtY0 = 10.0;
        ConsolDraw c = new ConsolDraw(width, height);
        Complex z;
        c.clsBorder();
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                double x = (i - x0) / lenghtX0;
                double y = (j - y0) / lenghtY0;
                z = new Complex(x,y);

                int color = getColor(z);

                    c.drawChar(i, j, adaptColor(color));

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

    private static int adaptColor(int color) {
        switch (color) {
            case (252):
                return 1;
            case (253):
                return 2;
            case (254):
                return 3;
            case (255):
                return 4;

        }
        return 0;
    }


}