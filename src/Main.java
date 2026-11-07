import java.util.*;

public class Main
{
    public static final int MAP_SIZE = 5;
    public static final int MAX_TREASURES = 5;
    public static final int MIN_TREASURES = 2;
    public static final int MAX_BLOCKS = 7;
    public static final int MIN_BLOCKS = 2;
    public static final int MAX_ENEMIES = 5;
    public static final int MIN_ENEMIES = 1;

    public static int numOfTreasures = 3;
    public static int numOfBlocks = 3;
    public static int numOfEnemies = 2;

    public static Scanner reader = new Scanner(System.in);
    public static Tile[][] map = new Tile[MAP_SIZE][MAP_SIZE];
    public static Player player = new Player();

    public static void generateMap()
    {
        numOfTreasures = (int)(Math.random() * (MAX_TREASURES - MIN_TREASURES + 1)) + MIN_TREASURES;
        numOfBlocks = (int)(Math.random() * (MAX_BLOCKS - MIN_BLOCKS + 1)) + MIN_BLOCKS;
        numOfEnemies = (int)(Math.random() * (MAX_ENEMIES - MIN_ENEMIES + 1)) + MIN_ENEMIES;

        // set the player & exit
        map[0][0] = new Tile(TileType.Player);
        map[MAP_SIZE - 1][MAP_SIZE - 1] = new Tile(TileType.Exit);

        // generate treasures
        for (int i = 0; i < numOfTreasures; i++)
        {
            int x, y;
            do
            {
                x = (int)(Math.random() * ((MAP_SIZE - 1) + 1));
                y = (int)(Math.random() * ((MAP_SIZE - 1) + 1));
            } while (map[x][y] != null);

            map[x][y] = new Tile(TileType.Treasure);
        }

        // generate enemies
        for (int i = 0; i < numOfEnemies; i++)
        {
            int x, y;
            do
            {
                x = (int)(Math.random() * ((MAP_SIZE - 1) - 1 + 1)) + 1;
                y = (int)(Math.random() * ((MAP_SIZE - 1) + 1));
            } while (map[x][y] != null);

            map[x][y] = new Tile(TileType.Enemy);
        }

        // generate blocks
        for (int i = 0; i < numOfBlocks; i++)
        {
            int x, y;
            do
            {
                x = (int)(Math.random() * ((MAP_SIZE - 2))) + 1;
                y = (int)(Math.random() * ((MAP_SIZE - 2))) + 1;
            } while (map[x][y] != null);

            map[x][y] = new Tile(TileType.Block);
        }

        // generate empty
        for (int i = 0; i < MAP_SIZE; i++)
        {
            for (int j = 0; j < MAP_SIZE; j++)
            {
                if (map[i][j] == null) map[i][j] = new Tile(TileType.Empty);
            }
        }
    }

    public static void displayMap()
    {
        for (int i = 0; i < MAP_SIZE; i++)
        {
            for (int j = 0; j < MAP_SIZE; j++)
            {
                System.out.print("[" + map[i][j].toString() + "] ");
            }
            System.out.println();
        }
    }

    public static void displayPlayerStats()
    {
        System.out.println("Player Stats:");
        System.out.println("HP: " + player.getHp() + "/" + Entity.getMaxHp());
        System.out.println("Attack: " + player.getAttackPower());
        System.out.println("Treasures: " + player.getTreasures() + "/" + numOfTreasures);
    }

    public static void game() {
        System.out.println("=== Dungeon Crawler ===\n");

        displayMap();
        System.out.println();

        displayPlayerStats();
        System.out.println();

        System.out.print("Enter your move (W/A/S/D) or action (Q):");
        char action = reader.next().charAt(0);

        switch (action) {
            case 'W':
                player.move(map, 'u');
                break;
            case 'A':
                player.move(map, 'l');
                break;
            case 'D':
                player.move(map, 'r');
                break;
            case 'S':
                player.move(map, 'd');
                break;
            default:
                break;
            //save(); TODO
        }

        // TODO: FINISH CHECK
    }

    public static void main(String[] args)
    {
        generateMap();

        while (true)
            game();
    }
}