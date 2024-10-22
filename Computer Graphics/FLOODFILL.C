 
#include <graphics.h>
#include <stdio.h>

void floodFill(int x, int y, int oldColor, int newColor) {
    int currentColor = getpixel(x, y);
    if (currentColor == oldColor) {
        putpixel(x, y, newColor);
        floodFill(x + 1, y, oldColor, newColor);
        floodFill(x - 1, y, oldColor, newColor);
        floodFill(x, y + 1, oldColor, newColor);
        floodFill(x, y - 1, oldColor, newColor);
    }
}

int main() {
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    
    rectangle(100, 100, 200, 200); // Draw boundary
    floodFill(150, 150, 0, 4);     // Fill inside rectangle
    
    getch();
    closegraph();
    return 0;
}
