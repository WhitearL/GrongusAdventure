package grongusadventure.world;

public class WorldBuilder {

    private Tile[][] tileGrid;
    private final int width;
    private final int height;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tileGrid = new Tile[width][height];
    }

    public World build() {
        return new World(tileGrid);
    }

    private WorldBuilder randomiseTiles() {

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tileGrid[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private WorldBuilder smoothTiles(int passes) {
        Tile[][] smoothedTiles = new Tile[width][height];

        for (int pass = 0; pass < passes; pass++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floorCount = 0;
                    int rockCount = 0;

                    for (int cellX = -1; cellX < 2; cellX++) {
                        for (int cellY = -1; cellY < 2; cellY++) {

                            if (x + cellX < 0 || x + cellX >= width || y + cellY < 0 || y + cellY >= height) {

                                continue;
                            }

                            if (tileGrid[x + cellX][y + cellY] == Tile.FLOOR) {
                                floorCount++;
                            } else {
                                rockCount++;
                            }

                        }
                    }
                    smoothedTiles[x][y] = floorCount >= rockCount ? Tile.FLOOR : Tile.WALL;
                }
            }
            tileGrid = smoothedTiles;
        }
        return this;
    }

    public WorldBuilder generateCaves() {
        return randomiseTiles().smoothTiles(8);
    }

}
