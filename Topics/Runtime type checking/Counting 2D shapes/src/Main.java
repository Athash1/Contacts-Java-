class Counter {
    public static int count2DShapes(Shape[] shapes) {
        int c = 0;
        for(Shape s: shapes) {
            if(s instanceof Shape2D && (s.getClass() != Shape2D.class)) {
                c += 1;
            }
        };
        return c;
    }
}

// Don't change the code below

class Shape {
}

class Shape2D extends Shape {
}

class Shape3D extends Shape {
}


class Circle extends Shape2D {
}

class Shape2DSub1 extends Shape2D {
}

class Shape2DSub2 extends Shape2D {
}


class Cube extends Shape3D {
}

class Shape3DSub1 extends Shape3D {
}

class Shape3DSub2 extends Shape3D {
}