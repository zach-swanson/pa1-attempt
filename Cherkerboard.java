void main() {
    String dark = "blue";
    String light = "white";
    int size = 16;

    Pict darkSquare = new Rect(size, size, dark);
    Pict lightSquare = new Rect(size, size, light);
    Pict darkDomino = new Beside(darkSquare, lightSquare);
    Pict lightDomino = new Beside(lightSquare, darkSquare);
    Pict fourSquares = new Above(lightDomino, darkDomino);
    Pict twoRows = fourSquares.beside(fourSquares).beside(fourSquares).beside(fourSquares);
    Pict checkerboard = twoRows.above(twoRows).above(twoRows).above(twoRows);

    ImageIO_.show(checkerboard);

    // I was able to reduce loops by building the checkerboard modularly, starting with
    // dominoes, then squares, then rows, then the whole checkerboard.
}
