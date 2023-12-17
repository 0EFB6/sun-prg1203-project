package Assignment;

import java.util.Date;
import Assignment.Pokeball;
import Assignment.Pokemon;

// enum for different types of Disks
enum DiskType {
    DISK_TYPE_A,
    DISK_TYPE_B,
    DISK_TYPE_C
}

// Class for Golden Chip
class GoldenChip {
    // You can add more properties or methods as needed
}

// Class for Golden Sand
class GoldenSand {
    // You can add more properties or methods as needed
}

// Class for Drop Item
class DropItem {
    private GoldenChip goldenChip;
    private GoldenSand goldenSand;

    public DropItem(GoldenChip goldenChip, GoldenSand goldenSand) {
        this.goldenChip = goldenChip;
        this.goldenSand = goldenSand;
    }

    public GoldenChip getGoldenChip() {
        return goldenChip;
    }

    public GoldenSand getGoldenSand() {
        return goldenSand;
    }
}

class Disk {
    private DiskType type;

    public Disk(DiskType type) {
        this.type = type;
    }

    public DiskType getType() {
        return type;
    }
}

public class Catch {
    private int collectionNumber;
    private Pokeball pokeBall;
    private boolean success;
    private DropItem dropItem;
    private Disk disk;
    private Date catchTime;

    public Catch(int pokemonCollectionNumber, Pokeball pokeBall, boolean success, DropItem dropItem, Disk disk) {
        this.collectionNumber = pokemonCollectionNumber;
        this.pokeBall = pokeBall;
        this.success = success;
        this.dropItem = dropItem;
        this.disk = disk;
        this.catchTime = new Date();
    }

    public int getCollectionNumber() {
        return collectionNumber;
    }

    public Pokeball getPokeBall() {
        return pokeBall;
    }

    public boolean isSuccess() {
        return success;
    }

    public DropItem getDropItem() {
        return dropItem;
    }

    public Disk getDisk() {
        return disk;
    }

    public Date getCatchTime() {
        return catchTime;
    }

    //method
    public void displayCatchInfo() {
        System.out.println("Pokemon Collection Number: " + collectionNumber);
        System.out.println("Poke Ball Used: " + pokeBall.getType());
        System.out.println("Success: " + success);
        System.out.println("Drop Item: " + dropItem);
        System.out.println("Disk Used: " + disk.getType());
        System.out.println("Catch Time: " + catchTime);
    }
    
}

